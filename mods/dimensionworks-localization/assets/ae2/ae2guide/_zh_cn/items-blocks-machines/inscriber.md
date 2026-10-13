---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 压印器
  icon: inscriber
  position: 310
categories:
- machines
item_ids:
- ae2:inscriber
---

# 压印器

<BlockImage id="inscriber" scale="8" />

压印器用于安装电路和[处理器](processors.md)使用[压印模板](presses.md),并粉碎各种物品。
它可以接受其中之一 AE2 电源(英英阿英)或合成/Forge 能源(E/FE)。它可以被置于一边,以便插入来自不同侧面的物品
将它们插入到其清单中不同的空格中。<ItemLink id="certus_quartz_wrench" />.
还可以将手合成成果推向邻近的库存清单。

输入缓冲的大小可以调整。例如,如果您想要从一个清单中输入大量压印器,
您需要一个小缓冲器,以使材料在压印器之间更优化地分布(代替第一个
压印器填充最多 64 个,其余为空).

4 电路压印模板用于编织[处理器](processors.md)

<Row>
  <ItemImage id="silicon_press" scale="4" />

  <ItemImage id="logic_processor_press" scale="4" />

  <ItemImage id="calculation_processor_press" scale="4" />

  <ItemImage id="engineering_processor_press" scale="4" />
</Row>

名称按键可以用来命名类似弧形块的区块,但可用于在<ItemLink id="pattern_access_terminal" />.

<ItemImage id="name_press" scale="4" />

## 设置

* 压印器可设置为侧面(解释如下:)或允许从任何一侧输入任何空格, 由内部过滤器决定
    哪里去。在非偏向模式下, 无法从上位和下位提取物品。
* 压印器可设定将物品推入相邻的库存清单。
* 输入缓冲的大小可以调整,大选项是独立压印器手动喂养
小选项使大型平行设置更加可行。

## GUI 和忧愁,

在侧边模式中时,压印器过滤器,什么是插入或提取的侧边。

![压印器 GUI](../assets/diagrams/inscriber_gui.png)![压印器侧面](../assets/diagrams/inscriber_sides.png)

A.**顶输入**可以通过压印器(既可以推到此位置,也可以从这个位置拉动物品)

B.**中心输入**插入,以通过左、右、前和后侧压印器(只能将物品推到此位置, 而不是从)

C.**下输入**通过下侧访问压印器(既可以推到此位置,也可以从这个位置拉动物品)

D.**产出 输出产出**从左、右、前和后侧拉出压印器(只能从此时档中拖动物品, 而不是推到)

## 简单自动化

举例来说,侧面和可旋转性 意味着你可以半自动登记员喜欢这样:

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/inscriber_hopper_automation.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

或直接进出压印器以非倾斜的状态的时候。

## 升级

压印器支持以下支持[升级](upgrade_cards.md):

*   <ItemLink id="speed_card" />

## 用途

<RecipeFor id="inscriber" />
