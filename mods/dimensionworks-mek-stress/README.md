# DimensionWorks ME Mechanical Power

把 Create 机械动力、Mekanism 机器和 AE2 内存网络连接成两条明确边界：

- AE 侧库存由 Memory Drive 与 Memory Card 提供。Gearbox IMPORT 把 Create 应力存入网络，Gearbox EXPORT 从网络扣除 SU 后输出应力。
- Create 侧动力可由相邻动力网络中的任意有效动力源提供；ME Gearbox EXPORT 是其中一种源，普通传动杆、齿轮组和其他有源 Create 网络也能直接接入。
- 机器能量采用二元供能：网络能支付当前 RPM 对应的 SU 且 Create 网络未过载时，内部能量契约保持满值；SU 不足、路线停止或 Create 网络过载时为零。兼容层还会每 tick 向真实 `MachineEnergyContainer` 补充最多 `20,000,000 J`（20,000 kJ），无有效动力时清零。充能器也属于合格机器，按基础档 `1024 RPM` 接入。RPM 低于机器目标时保留满能量，但按 `min(1, 有效 RPM / 目标 RPM)` 降低工作速度。RPM 高于目标时，生产倍率按 `有效 RPM / 目标 RPM` 提升，并在 Mekanism 输出边界统一作用于物品、气体、流体、复合输出和随机副产物；每个逻辑产物先按该 tick 的实际操作次数求和，再乘倍率并向下取整，避免概率副产物被重复放大。
- 合格 Mekanism 机器会检查主机与全部 Mekanism 包围方块的外表面；任意相邻 `KineticBlockEntity` 只要其轴朝向其中一面就可以接通。机器作为虚拟成员加入实际的 `KineticNetwork.members`，因此它按 Create 已传播的网络 RPM 计算 `RPM × 8` 应力并直接计入网络总量与过载判定，不再只是显示值；空闲机器也保留零速虚拟成员。机器拒绝一切 FE 输入。
- MEK 直接动力与 ME Gearbox EXPORT 在读取 Create 已传播的网络转速后，先经过玩家的有效 RPM 上限，再受 `directMaxRpm` 收口。原始理论转速只用于 Create 网络传播；MEK 消费、Jade 显示与虚拟成员负载都使用收口后的有效转速。因此玩家上限降低后，MEK 不会再继续按旧的高速运行。
- 四档目标 RPM 分别为基础 `1024`、高级 `2048`、精英 `4096`、终极 `8192`。每台机器向所在 Create 网络施加 `当前 RPM × 8` 的应力需求；网络应力不足时由 Create 规则判定过载。

本 Mod 不分发或替换 Applied Create、AE2、Mekanism、Create 的源码；兼容通过自研 Mod 与运行时 Mixin 完成。Applied Create 原有的应力存储 Cell、组件、外壳和创造 Cell 全部退役，不能继续挂载、读写或供应 `StressKey`。
Mekanism 的能量立方、能量平板、感应 Cell 与感应 Provider 由 KubeJS 退役：移除配方、移出创造栏、隐藏 JEI、阻止拾取和使用，并清除玩家库存。为避免配置器、碎星者、激光器等非储能配方失去材料，残留配方中的 `mekanism:energy_tablet` 输入会替换为物品标签 `#mekanism:alloys/infused`。感应外壳与感应端口不属于储能元件，继续保留；没有 Cell 与 Provider 后无法组成可储能的感应矩阵。

KubeJS 会把 `memory_drive_ddr1..5` 和 DDR1～5 × 六形态共 30 个 `memory_card_ddrN_*` 加入创造标签；`stress_output_card` 及其配方、资源、总线逻辑和 Jade 显示已全部删除。

## Memory 参数

| DDR | 每 Drive 槽位 | 基础单卡容量 `C_d` | 基础驱动带宽 `B_d` |
|---|---:|---:|---:|
| DDR1 | 4 | 8,192 SU | 8,192 RPM |
| DDR2 | 8 | 9,216 SU | 16,384 RPM |
| DDR3 | 16 | 10,240 SU | 32,768 RPM |
| DDR4 | 32 | 12,288 SU | 65,536 RPM |
| DDR5 | 64 | 16,384 SU | 131,072 RPM |

每种卡用二维二进制指数 `(a,v)` 描述：劣质 `(-2,-2)`、经济 `(-1,-1)`、均衡 `(0,0)`、高速 `(-1,+1)`、高存储 `(+1,-1)`、最终 `(+2,+2)`。单卡容量 `C(d,t)=C_d×2^a`；驱动器有效带宽 `B=max(0,B_d+Σ round(B_d×(2^v-1)/S_d))`。空驱动器保留基础速度，均衡满盘保持原标定。

每个逻辑 AE 网络最多统计两台 Drive。第三台会使网络容量、带宽和输出归零，但 Drive 内已有 Card 与 SU 不会丢失；移除多余 Drive 后自动恢复。

## 应力守恒

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

空载 EXPORT 齿轮箱的基础负载为 `有效 RPM × 8`。接入下游机器时取“基础负载”与“实际完整应力负载”的较大值，因此单台标准机器仍保持原有 `RPM × 8` 标定，多台机器会继续按总负载增长。

ME Gearbox EXPORT 只有在有效 RPM、实际输出 RPM、实际扣费和 `q > 0` 全部有效时才运行；任一条件缺失都会同时清除输出速度与宣告容量。`storedSu < requiredSu` 时整台齿轮箱无能量输出，不允许用库存比例赊速；RPM 带宽不足时则按比例输出转速。没有下游机器时，齿轮箱仍按基础负载运行。

RPM 需求以每台 EXPORT 齿轮箱为一个占用单位，同一 AE 网络内求和；下游机器只放大该齿轮箱的 SU 应力需求，不重复占用 RPM。齿轮箱不需要等待下游机器出现才开始运行，因此不会形成“机器等齿轮箱、齿轮箱等负载”的死锁。

ME Gearbox EXPORT 向 Create 网络宣告的容量严格等于本次实际扣除的 SU。下游机器在 `outputRpm` 下最多只能消费 `chargedSu`；超出部分触发 Create 原有应力过载，不能无中生有。

## Jade

- 所有 Mekanism 方块的 Mekanism FE/J 元素，以及 Jade 通用 FE/J provider 对 Mekanism 方块的显示，都被移除。
- 本 Mod 的 MEK Jade 条目显示当前有效 RPM、`RPM × 8` 的 SU/t 占用和当前工作倍率。
- MEK Jade 的“生产倍率”显示端到端吞吐倍率：低于目标时小于 `1x`，达到目标为 `1x`，高于目标时按比例大于 `1x`；配方内部仍不会在低转速时重复放大产出，避免二次取产。
- 非加工 MEK 设备仍不会出现本 Mod 的机械动力条目。

## 工程接口

- `memory_drive_ddr1..5`：使用 AE2 驱动器背景，每页 4 列 × 5 行共 20 槽，按 DDR 等级只接受同等级 Memory Card。
- `memory_card_ddrN_{economy,balanced,high_speed,high_storage,defective,final}`：只影响所在驱动器的容量与有效带宽。
- 正常卡配方每次固定产出 4 张；每张独立有 25% 概率变为同 DDR 劣质卡，自动合成假玩家跳过该判定。
- 经济型、均衡型、高速型、高存储型可合成；劣质型只作副产物，最终型仅注册，毕业配方待定。
- `appliedcreate:me_gearbox`：IMPORT 输入应力到 AE，EXPORT 从 AE 输出应力并执行 SU 守恒。
- `/dw memory`：读取附近已连接 Drive 所在逻辑网格的状态快照。

所有平衡值位于 COMMON 配置 `dimensionworks_mek_stress-common.toml`。槽数、结构规则、两台 Drive 上限、公式和齿轮箱守恒边界不可配置。

## 构建

```sh
gradle build --no-daemon
```
