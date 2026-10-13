---
navigation:
    parent: epp_intro/epp_intro-index.md
    title: ME 无线连接器
    icon: expatternprovider:wireless_connect
categories:
- extended devices
item_ids:
- expatternprovider:wireless_connect
- expatternprovider:wireless_tool
---

# ME 无线连接器

<Row gap="20">
<BlockImage id="expatternprovider:wireless_connect" scale="6"></BlockImage>
<ItemImage id="expatternprovider:wireless_tool" scale="6"></ItemImage>
</Row>

ME 无线连接器可以连接两个网络,例如<ItemLink id="ae2:quantum_link" />但距离有限,不能 
交叉维度。ME 无线连接器只支持一对一连接, 您需要使用<ItemLink id="expatternprovider:wireless_hub" />
如果您想要很多到很多连接。

## 链接无线连接器

单击要连接到 ME 无线设置工具包, 然后你可以把它们连接在一起。

溜溜 + 单击以清除 ME 无线设置工具包的当前设置。

ME 无线连接器将在成功建立链接时改变其纹理。

断开 ME 无线连接器

<GameScene zoom="5" background="transparent">
  <ImportStructure src="../structure/wireless_connector_off.snbt"></ImportStructure>
</GameScene>

链接 ME 无线连接器

<GameScene zoom="5" background="transparent">
  <ImportStructure src="../structure/wireless_connector_on.snbt"></ImportStructure>
</GameScene>

## 颜色

无线连接器的颜色可以像电缆一样,只能用同样的颜色连接电缆/连接机。

你需要一个<ItemLink id="ae2:color_applicator" />以颜色显示连接符。

这样你就可以设置这样的无线连接器:

<GameScene zoom="3" background="transparent" interactive={true}>
  <ImportStructure src="../structure/wireless_connector_setup.snbt"></ImportStructure>
</GameScene>

## 电力使用

ME 无线连接器离线越远,能源成本越高。它的成本-距离曲线不是线性曲线,所以电能 
如果相距太远,成本会非常高。

您可以使用<ItemLink id="ae2:energy_card" />为了节省电力,每张卡片都能降低 10%的能源成本。

