---
navigation:
    parent: epp_intro/epp_intro-index.md
    title: ME 阈下限输出总线
    icon: expatternprovider:threshold_export_bus
categories:
- extended devices
item_ids:
- expatternprovider:threshold_export_bus
---

# ME 阈下限输出总线

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../structure/cable_threshold_export_bus.snbt"></ImportStructure>
</GameScene>

ME 阈下限输出总线存储在 ME 网络高于/低于阈值。

## 示例实例

![GUI](../pic/thr_bus_gui1.png)

铜的门槛定在 128,因此当网络中存储的铜超过 128 时,铜出口铜。

![GUI](../pic/thr_bus_gui2.png)

阈值与以上相同,但模式设定为 BELOW。当存储的铜低于 128 时,它出口铜。
