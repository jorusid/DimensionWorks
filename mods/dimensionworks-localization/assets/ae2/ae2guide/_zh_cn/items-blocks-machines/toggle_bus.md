---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 切换公交车
  icon: toggle_bus
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:toggle_bus
- ae2:inverted_toggle_bus
---

# 切换公交列

<GameScene zoom="8" background="transparent">
<ImportStructure src="../assets/assemblies/toggle_bus.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

类似于<ItemLink id="fluix_glass_cable" />或其他电缆,
允许通过 redstone 跳入连接状态。这样您可以剪切
a 区段外[ME 网络网网](../ae2-mechanics/me-network-connections.md).

当红石信号提供时 部分能够连接<ItemLink id="inverted_toggle_bus" />提供反向
行为, 使连接失效。

值得指出的是,将这些装置套在一起可能导致网络重新启用和重新计算连接的设备。

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

## 食食权

<RecipeFor id="toggle_bus" />

<RecipeFor id="inverted_toggle_bus" />
