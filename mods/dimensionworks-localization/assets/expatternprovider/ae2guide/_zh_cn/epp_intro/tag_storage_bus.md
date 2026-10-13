---
navigation:
    parent: epp_intro/epp_intro-index.md
    title: ME 标签存储总线
    icon: expatternprovider:tag_storage_bus
categories:
- extended devices
item_ids:
- expatternprovider:tag_storage_bus
---

# ME 标签存储总线

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../structure/cable_tag_storage_bus.snbt"></ImportStructure>
</GameScene>

ME 标签存储总线是一种<ItemLink id="ae2:storage_bus" />，可以按物品或流体标签过滤，并支持一些基本的逻辑运算符。

以下是一些示例：

- 只接受原矿

forge:raw_materials/*

- 接受所有锭和宝石

forge:ingots/* | forge:gems/*

