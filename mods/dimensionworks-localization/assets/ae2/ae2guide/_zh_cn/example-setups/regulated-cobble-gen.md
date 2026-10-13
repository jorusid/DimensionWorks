---
navigation:
  parent: example-setups/example-setups-index.md
  title: 自动调节可塑石发电机
  icon: minecraft:cobblestone
---

# 自动调节可塑石发电机

COBB 石生成器的自动化很简单,只要面对<ItemLink id="annihilation_plane" />变成标准香草
然而,这样做最终会干扰你的网络 充满了可塑石 所以有些规定
需要。

由于毁灭飞机如何运作(他们的行为就像<ItemLink id="import_bus" />赛 数)我们不能简单地将<ItemLink id="level_emitter" />
A. 面对的<ItemLink id="export_bus" />具有 a 和<ItemLink id="redstone_card" />(您无法直接进口出口
中间没有存储)我们必须再绕圈子一点

<ItemLink id="toggle_bus" />允许你用红石信号 连接和切断网络部分的网络 但它们导致
当他们这样做时, 即重新启动网络。有一个简单的变通办法: 将拖动的公交车加到[子网络](../ae2-mechanics/subnetworks.md)
以便它重新启用子网。

我们可以有一个自足的<ItemLink id="annihilation_plane" />和<ItemLink id="storage_bus" />[子网络](../ae2-mechanics/subnetworks.md)
键向<ItemLink id="interface" />主网络上的主网络。切换总线将连接和断开子网
<ItemLink id="quartz_fiber" />切断飞机的电源

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/regulated_cobble_gen.snbt" />

<BoxAnnotation color="#dddddd" min="3 2 2" max="7 2.3 3">
        (1)平整计划:无 GUI 要配置,但可以用效率与破碎法来施以魔法,以减少电源的抽取。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2 2 2" max="2.3 3 3">
        (2)存储总线:在其默认配置中。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.3 2.3 2" max="2.7 2.7 2.3">
        (3)Toggle 公交车: 切换公用车在
        子网络,而不是主网络。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.3 3 2.3" max="2.7 3.3 2.7">
        (4)级别 Eminister : 配置有 cobblestone 和理想数量, 设定为“ 当水平低于极限时退出 ”。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1 2 3" max="2 3 2">
        (5)接口: 在其默认配置中。
  </BoxAnnotation>

<DiamondAnnotation pos="0 2.5 1.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

<DiamondAnnotation pos="5 1.5 3.5" color="#00ff00">
        水下楼梯防止水流 把熔岩变成粘糊糊的岩浆
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* <ItemLink id="annihilation_plane" />(1)没有 GUI 要配置,但可以用效率与破碎法来施以魔法,以减少电源的抽取。
* <ItemLink id="storage_bus" />(2)默认配置。
* <ItemLink id="toggle_bus" />(3)必须位于石英纤维的亚网络侧面,而不是主网络或主
  网络将每次重启它时都重新启动。
* <ItemLink id="level_emitter" />(4)设置为“在水平低于限制时退出”。
* <ItemLink id="interface" />(5)默认配置。

## 如何运作

1. COBBlestone 的产生器合成了一些 COPBLESON。
2. <ItemLink id="annihilation_plane" />打破了可塑石 
3. <ItemLink id="storage_bus" />将可塑石存储在<ItemLink id="interface" />发送到主网络
4. 当主网络中的可碎石数量超过设定数量时,<ItemLink id="level_emitter" />停止
   发送信号,关闭<ItemLink id="toggle_bus" />.
5. 这切断了亚网络的电源 阻止了毁灭飞机的工作
