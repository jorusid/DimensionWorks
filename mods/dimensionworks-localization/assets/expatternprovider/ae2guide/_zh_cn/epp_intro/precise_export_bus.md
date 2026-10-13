---
navigation:
    parent: epp_intro/epp_intro-index.md
    title: ME 精确输出总线
    icon: expatternprovider:precise_export_bus
categories:
- extended devices
item_ids:
- expatternprovider:precise_export_bus
---

# ME 精确输出总线

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../structure/cable_precise_export_bus.snbt"></ImportStructure>
</GameScene>

ME 精确输出总线出口物品/液体,按规定数量计算,只有容器能够完全接受全部产出时,才出口。

## 示例实例

![GUI](../pic/pre_bus_gui1.png)

这意味着每次操作出口 3 个可碎石。当网络中的可裂石数量低于 3 时,它停止出口。

![GUI](../pic/pre_bus_gui2.png)

当目标容器无法控制全部出口时,它也停止出口。箱子现在只能再持有 2 个可塑石, 所以输出总线停止。
