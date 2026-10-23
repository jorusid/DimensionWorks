# MEK 机械 SU/RPM 严格供能设计

## 目标

把 DimensionWorks 中合格的 Mekanism 加工机器从 FE/J 改为只接受相邻 Create 动力网络提供的机械动力，并让 ME Gearbox EXPORT / ME Memory 的 SU 库存与 RPM 带宽继续作为其中一种严格供能路径。

机械动力覆盖 `StressRules.isEligible` 判定为合格加工机器的方块，充能器也按基础档接入。能量立方、能量平板、感应 Cell 与感应 Provider 由 KubeJS 作为 FE 储能元件退役；残留非储能配方中的能量平板输入统一替换为标签 `#mekanism:alloys/infused`。通用线缆、发电机、多方块结构和物流结构不再提供或显示内部 FE 能量。

## 核心规则

- 合格 MEK 机器不再读取、换算或接收 FE。内部配方系统在有有效机械动力时看到满能量，无有效机械动力时看到零能量。
- 合格 MEK 机器在每个服务端 tick 向真实 `MachineEnergyContainer` 补充最多 `20,000,000 J`（20,000 kJ）；网络停止、SU 不足或 Create 网络过载时清零。充能器使用同一供能判定。
- 机器扫描主机与全部 Mekanism `AttributeHasBounding` 占位方块的外表面。任意相邻 `KineticBlockEntity` 只要其轴朝向其中一面，就可以提供该元件所在的 Create 网络；`3x2x2` 等非立方单方块机器不会因主机侧面被自身包围方块占据而断线。
- 每台机器对应一个虚拟 `KineticBlockEntity` 成员，并插入实际 `KineticNetwork.members`。网络按虚拟成员的理论 RPM 计算 `RPM × 256` 应力，因此原版 Create 应力统计、齿轮箱需求扫描和过载状态都能看到机器负载。
- 齿轮箱不依赖下游机器决定是否启动。空载时使用 `有效 RPM × 8` 的齿轮箱基础负载；接入机器后，SU 需求取基础负载与下游实际完整应力负载的较大值。
- 机器能量是二元值：网络支付当前 RPM 对应的 SU 时保持满能量；SU 不足、路线停止或 Create 网络过载时为零。有效 RPM 低于机器目标 RPM 时仍为满能量，但工作速度按 `min(1, 有效 RPM / 目标 RPM)` 缩放。
- 有效 RPM 高于目标 RPM 时，生产倍率按 `有效 RPM / 目标 RPM` 计算，并在 Mekanism 输出边界统一作用于物品、气体、流体、复合输出和随机副产物；每个逻辑产物先按该 tick 的实际操作次数求和，再乘倍率并向下取整。
- 四档目标 RPM 为基础 `1024`、高级 `2048`、精英 `4096`、终极 `8192`。每台机器按自身当前 RPM 向对应 Create 网络施加 `RPM × 256` 的应力需求。
- 单台标准机器仍对应每 RPM `256` SU；多台机器只放大齿轮箱的 SU 负载，不重复累计 RPM。
- ME Gearbox IMPORT 仍把 Create 应力存入 AE；ME Gearbox EXPORT 从 AE 输出应力，并执行严格 SU 守恒。
- Applied Create 原有的 `stress_output_card`、AE 输出总线路由和相关 Jade 总线显示保持退役。

## 网络计算

```text
idleLoad       = effectiveRpm * 8
fullLoad       = max(idleLoad, Create 网络完整应力负载)
requestedSu    = ceil(fullLoad)
rpmQ           = min(1, bandwidthRpm / requestedRpm)
requiredSu     = ceil(requestedSu * rpmQ)
stockQ         = storedSu >= requiredSu ? 1 : 0
q              = min(stockQ, rpmQ)
outputRpm      = round(effectiveRpm * q)
chargedSu      = requiredSu
perRpmCapacity = chargedSu / outputRpm
```

- MEK 直接动力与 ME Gearbox EXPORT 在读取 Create 已传播的网络转速后，先套玩家有效 RPM 上限，再经过 `directMaxRpm`。原始理论转速只用于 Create 网络传播；MEK 消费、Jade 显示、虚拟成员负载与 Create 自身消费端共享同一有效转速空间。
- `requestedRpm` 以每台 EXPORT 齿轮箱为一个占用单位；同一 AE 网络内的齿轮箱需求求和。多台下游机器只增加 SU 应力，不重复占用 RPM。
- 齿轮箱空载时的固定贡献是每 RPM `8` SU 应力；有下游负载时取较大值。实际通过网络扣除的 SU 仍按实际输出 RPM 等比例计算。
- RPM 带宽按可用比例连续缩放，不再设置 60% 启动门槛。库存 SU 是硬门控：`storedSu < requiredSu` 时 `stockQ = 0` 且 `q = 0`，不允许赊速。
- 齿轮箱在有效 RPM、实际输出 RPM、实际扣费和 `q > 0` 全部有效时运行，不要求存在下游负载；否则立即清除输出速度与宣告容量。
- 齿轮箱向 Create 宣告的每 RPM 容量必须等于实际扣除的 SU 除以实际输出 RPM。下游不能消费高于本次 ME 库存允许值的应力。

## 路由与缓存

- `MachinePowerManager` 每 tick 从主机及全部包围方块的外表面选择可用的 `KineticBlockEntity`，并直接绑定它当前的 `KineticNetwork`；相邻元件或网络消失时立即撤销虚拟成员。
- 虚拟成员按玩家上限收口后的有效网络 RPM 计费；只有网络有源且未过载时，机器才获得 `currentRpm` 并保持满能量。过载时负载保留、能量归零，避免清除负载后网络瞬间恢复而振荡。
- `MemoryGridService` 每 10 tick 扫描同一 AE 网格内全部 EXPORT 齿轮箱并重建需求缓存；齿轮箱每 tick 仍会做最终 `q`、扣费和输出门控。

## FE 契约

- `getEnergy()`：有机械动力返回 `getMaxEnergy()`，否则返回 0。
- `isEmpty()`：无机械动力时为 `true`。
- `insert()`：合格机器的任何 FE 插入都返回未接受量，不修改实体 FE。
- `extract()`：仅 `AutomationType.INTERNAL` 且机械动力有效时返回请求量；不修改实体 FE，SU 已由齿轮箱在网络层扣除。
- 删除 `ProcessingEnergyRegistry`、`SuConversion`、`mekanismPerSu` 配置及其测试。

## Jade

- 所有 `TileEntityMekanism` 的 Mekanism Jade 能量元素必须移除，不再显示 FE/J。
- Jade 通用 FE/J provider 对 `TileEntityMekanism` 的服务端数据和客户端 tooltip 都必须取消。
- 本 Mod 的 MEK Jade 条目显示 Create 路线、当前有效 RPM、`RPM × 256` 的 SU/t 占用和工作倍率。
- Jade 的生产倍率显示端到端吞吐倍率；低于目标时显示小于 `1x` 的实际工作速度，高于目标时显示配方放大后的吞吐倍率。
- 非加工 MEK 设备不显示本 Mod 的机械动力条目。

## 验收

- 纯逻辑测试覆盖每 RPM 固定 8 SU、SU 硬门控、目标 RPM 以下工作速度缩放、目标 RPM 以上生产倍率与向下取整，以及断网路由不能刷新应力。
- 契约测试覆盖 `getEnergy`、`isEmpty`、`extract`、`insert` 注入点，以及齿轮箱只有在负载、RPM、扣费全部有效时才进入运行状态。
- 资源测试断言旧 FE 换算类和两份配置中的 `mekanismPerSu` 已删除。
- `gradle test --no-daemon` 与 `gradle build --no-daemon` 通过。
