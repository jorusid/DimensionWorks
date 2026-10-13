---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 主计长
  icon: controller
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:controller
---

# 主计长

<BlockImage id="controller" p:state="online" scale="8" />

控制器是[ME 网络网网](../ae2-mechanics/me-network-connections.md).
没有它,一个网络是“ad-hoc”,最多只能使用 8 个频道[设备](../ae2-mechanics/devices.md)总计。

无法在其中设置两个控制器[ME 网络网网](../ae2-mechanics/me-network-connections.md).

控制器提供 32[声道](../ae2-mechanics/channels.md)脸部。

控制器需要每个控制区块 6 个 AE/t 的
函数。每个控制器块块可以存储 8000 AE,因此更大的网络可能需要额外的
能源存储。[能源](../ae2-mechanics/energy.md)详细信息。

多块控制器可以相当自由的形式建立。

<GameScene zoom="2" background="transparent">
  <ImportStructure src="../assets/assemblies/controllers.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

然而,必须遵循几项规则:

1.  A 上的所有控制器区块[ME 网络网网](../ae2-mechanics/me-network-connections.md)必须连接; 否则, 区块会变成红色。
2.  控制器的大小必须在 7x7 x7 内; 否则它会变成红色。
3.  控制器最多可有两个相邻区块,最多为 1 轴;如果一个区段违反这一规则,则会禁用并变红。

<GameScene zoom="2" background="transparent">
  <ImportStructure src="../assets/assemblies/controller_rules.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

只要所有规则都得到遵守和授权,控制器就应当发光和发亮
循环颜色。

您可以右键单击控制器以获得相同的 GUI 作为 a 的<ItemLink id="network_tool" />

## 用途

<RecipeFor id="controller" />
