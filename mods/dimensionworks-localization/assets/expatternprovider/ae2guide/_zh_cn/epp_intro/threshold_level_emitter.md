---
navigation:
    parent: epp_intro/epp_intro-index.md
    title: ME 最低限额水平
    icon: expatternprovider:threshold_level_emitter
categories:
- extended devices
item_ids:
- expatternprovider:threshold_level_emitter
---

# ME 最低限额水平

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../structure/cable_threshold_level_emitter.snbt"></ImportStructure>
</GameScene>

它像重置- 连接 Latch 一样工作。当网络中的物品数量小于
下限阈值,当数量大于上限值时打开。

例如,设定了较低的门槛值 100,上限值 150。

起初网络是空的, 所以发射者不会活动。

随着物品数量的增长 超过 150 个 发射者会发出红石信号

当数量下降,不到 150, 发射者仍然发出信号。

最终数量不到 100,发射者将被关闭。
