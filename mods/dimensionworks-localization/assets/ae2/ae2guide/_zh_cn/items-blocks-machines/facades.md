---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 法卡德
  icon: facade
  icon_nbt: '{item: "minecraft:stone"}'
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:facade
---

# 法卡德

Facades 可以用来让你的基地看起来更干净。它们可以覆盖两个尺寸的电缆, 并且由许多电缆组成。
区块类型。

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/facades_1.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

他们能覆盖电缆的四面,但[子子 part](../ae2-mechanics/cable-subparts.md)和电缆连接
虽说是箱子刺伤

<GameScene zoom="6"  interactive={true}>
  <ImportStructure src="../assets/assemblies/facades_2.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

聪明点,要改进你的底部美学 或者用不同的纹理做砖块

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/facades_3.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 隐藏远藏缓冲

持有 a 时会隐藏 Facades<a href="network_tool.md">网络工具</a>两只手的两只手上

你可以与隐蔽的外表后面的街区互动,而不必先清除外观。

## 用途

将您想要的 4 中区块的纹理置于中间<ItemLink id="cable_anchor" />.

![虚假食宿](../assets/diagrams/facade_recipe.png)
