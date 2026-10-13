---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 网络连接
  icon: fluix_glass_cable
---

# 网络连接

## "网络"意味着什么?

“网络”是一组[设备](../ae2-mechanics/devices.md)由能够通过的链接的区块组成[频道](../ae2-mechanics/channels.md),
类似[电缆](../items-blocks-machines/cables.md)或整盘机器,[设备](../ae2-mechanics/devices.md). 
(<ItemLink id="charger" />,<ItemLink id="interface" />,<ItemLink id="drive" />等,等等。)
实际上,从技术上讲,单一电缆是一个网络。

## 设备定位旁

用于[设备](../ae2-mechanics/devices.md)具有某些特定网络功能的网络(类似<ItemLink id="interface" />
推着拉着[网络存储](../ae2-mechanics/import-export-storage.md), a<ItemLink id="level_emitter" />
读取网络存储内容, a<ItemLink id="drive" />正在网络存储等)
设备的实际位置无关紧要。

再说一遍**设备的实际位置无关紧要**。所有重要的是该设备与网络连接。
(以及它连接的网络).

## 网络连接

确定网络连接到什么的简单方法 使用<ItemLink id="network_tool" />它将显示每个
网络的组件,所以如果你看到的东西 你不应该或看不到的东西,你应该, 你有问题。

例如,这是两个独立的网络。

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/2_networks_1.snbt" />

  <BoxAnnotation color="#915dcd" min="0 0 0" max="1 2 2">
        网络 1
  </BoxAnnotation>

<BoxAnnotation color="#915dcd" min="2 0 0" max="3 2 2">
        网络 2
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

这也是两个独立的网络,因为<ItemLink id="quartz_fiber" />股份[能源](../ae2-mechanics/energy.md)
没有提供网络连接。

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/2_networks_2.snbt" />

  <BoxAnnotation color="#915dcd" min="0 0 0" max="1 2 2">
        网络 1
  </BoxAnnotation>

  <BoxAnnotation color="#915dcd" min="1.3 0 0" max="3 2 2">
        网络 2
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

不过,这只是一个网络,不是两个独立的网络。[量量桥](../items-blocks-machines/quantum_bridge.md)类似行为
a 无线[密集电缆](../items-blocks-machines/cables.md#dense-cable),所以两个端都在同一网络上。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/actually_1_network.snbt" />

  <BoxAnnotation color="#915dcd" min="0 0 0" max="7 3 3">
        所有 1 个网络
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

也只是一个网络,因为[电缆](../items-blocks-machines/cables.md)除了不同颜色的电缆以外,与网络连接无关的颜色
相互连接。所有颜色连接到福鲁伊克斯(或“未颜色”)电缆。

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/actually_1_network_2.snbt" />

  <BoxAnnotation color="#915dcd" min="0 0 0" max="4 2 2">
        所有 1 个网络
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 减少直觉连接

在这种情况下,这只是一个网络,因为<ItemLink id="pattern_provider" />,作为一个完整的街区装置, 行为像
一条电缆,<ItemLink id="inscriber" />因此,网络连接通过
样板供应器和压印器.

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/pattern_provider_network_connection_1.snbt" />

  <BoxAnnotation color="#915dcd" min="0 0 0" max="4 2 2">
        所有 1 个网络
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

防止发生这种情况(许多手合成装置都非常有用,包括:[子网络](../ae2-mechanics/subnetworks.md)),
您可以用<ItemLink id="certus_quartz_wrench" />使它具有方向性,在这种情况下,它将
不能通过一条通道通过另一条通道。

<Row gap="40">
<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/pattern_provider_network_connection_2.snbt" />

  <BoxAnnotation color="#915dcd" min="0 0 0" max="2 2 2">
        网络 1
  </BoxAnnotation>

  <BoxAnnotation color="#915dcd" min="2 0 0" max="4 2 2">
        网络 2
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/pattern_provider_directional_connection.snbt" />

  <BoxAnnotation color="#ee3333" min="1 .3 .3" max="1.3 .7 .7">
        观察电缆如何不连接
  </BoxAnnotation>

  <IsometricCamera yaw="255" pitch="30" />
</GameScene>
</Row>

其他不提供定向网络连接的部分最多[下分部分](../ae2-mechanics/cable-subparts.md)
[设备](../ae2-mechanics/devices.md)类似<ItemLink id="import_bus" />赛斯,<ItemLink id="storage_bus" />和
<ItemLink id="cable_interface" />.

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/subpart_no_connection.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>