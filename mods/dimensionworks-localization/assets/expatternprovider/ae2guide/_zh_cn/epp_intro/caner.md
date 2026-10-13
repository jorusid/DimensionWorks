---
navigation:
    parent: epp_intro/epp_intro-index.md
    title: MECaner 罐
    icon: expatternprovider:caner
categories:
- extended devices
item_ids:
- expatternprovider:caner
---

# MECaner 罐

<BlockImage id="expatternprovider:caner" scale="8"></BlockImage>

ME 罐头是一台机器 它能“扫描”东西 包括液体 Mekanism 天然气,Botaniamana 甚至能源!

第一个空位是填充什么,第二个空档是填写什么。

它需要能源才能运行,每个运行费用为 80 个 AE。

![GUI](../pic/caner_gui.png)

它只默认地填充液体, 您需要安装相应的配方, 才能填满其它东西。

### 支持附加词 :
- 应用流量
- 应用中养量体
- 应用植物添加剂

## 与 MECaner 罐

只有上方和下方才能接受能量并连接到网络。

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../structure/caner_example.snbt"></ImportStructure>
</GameScene>

简单设置 ME 坎纳 MECaner 接受从<ItemLink id="ae2:pattern_provider" />.

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../structure/caner_auto.snbt"></ImportStructure>
</GameScene>

模式只必须包含要填充的材料和要装满的容器。以下是一些例子:

装满水桶:

![P1](../pic/fill_water.png)

增强权能能源板(安装了应用车辆):

![P1](../pic/fill_energy.png)


## 取消扫描

MECaner 也可以用空模式从容器中排出垃圾。您需要以模式转换输入和输出。
