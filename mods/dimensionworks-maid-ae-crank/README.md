# DimensionWorks Maid AE2 Crank

为 Minecraft 1.20.1 Forge 的车万女仆增加“AE2 手摇曲柄”工作选项。

## 行为

- 女仆会在自身工作范围内寻找连接到可手摇 AE2 方块、且当前确实可以转动的 `ae2:crank`。
- 女仆会走到曲柄外侧并定期调用 AE2 曲柄自身的 `power()` 逻辑。
- 不使用假玩家模拟右键。AE2 会在假玩家触发曲柄交互时主动移除曲柄，因此必须调用方块实体的原生供能方法。
- 当目标没有可进行的工作时，不调用供能方法，避免触发 AE2 对无效摇动的计数和曲柄销毁逻辑。
- 搜索半径最多 8 格；仅在女仆任务检查时搜索附近方块，避免每 tick 扫描工作区。

## 依赖

- Minecraft 1.20.1 Forge
- Applied Energistics 2 15.4.x
- Touhou Little Maid 1.5.3+

## 静态检查与限制

本模组依赖 AE2 的 `CrankBlockEntity#power` 与女仆任务扩展 API。仓库 CI 负责执行 Gradle 构建；实际游戏内寻路、任务显示和曲柄工作仍需在运行环境验收。
