---
navigation:
  parent: example-setups/example-setups-index.md
  title: 级别 Eniut 自动存储
  icon: level_emitter
---

# 级别 Eniut 自动存储

有人可能会问:“我如何保存一定数量的物品,

一种解决办法是使用<ItemLink id="export_bus" />,<ItemLink id="level_emitter" />,和<ItemLink id="crafting_card" />自动要求新物品
来自您的网络[自动自制](../ae2-mechanics/autocrafting.md)。这一设置是为了维持一个大宗物品。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/level_emitter_autostocking.snbt" />

  <BoxAnnotation color="#dddddd" min="1 1 0" max="2 1.3 1">
        (1)输出总线: 过滤到想要的物品中。有红石卡和笔卡。红岩模式设置为
        "用信号启动" 编程行为设定为"不要使用库存物品"
        <Row><ItemImage id="redstone_card" scale="2" /><ItemImage id="crafting_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="0.7 1 0" max="1 2 1">
        (2)级别 Eminister: 配置了想要的物品和数量, 设定为“ 当水平低于限制时退出 ”。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1 0 0" max="2 1 1">
        (3)接口: 在其默认配置中。
  </BoxAnnotation>

<DiamondAnnotation pos="4 0.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* <ItemLink id="export_bus" />(1)被过滤到想要的物品。它有一个<ItemLink id="redstone_card" />和<ItemLink id="crafting_card" />.
  “红石模式”设置为“信号引导”,“偷窃行为”设定为:“不使用库存物品”。
* <ItemLink id="level_emitter" />(2)设置为“在水平低于限制时退出”。
* <ItemLink id="interface" />(3)默认配置。

## 如何运作

1. 如果想要的物品数量在[网络存储](../ae2-mechanics/import-export-storage.md)低于该天中指定数量
   <ItemLink id="level_emitter" />它会发出一个红石信号
2. 收到一个红石信号后(应付和应付款<ItemLink id="crafting_card" />准备不使用库存物品),
   排<ItemLink id="export_bus" />将要求网络[自动自制](../ae2-mechanics/autocrafting.md)手 车
   更多想要的物品,然后导出它。
3. 当一件东西被推入它时(并且未配置为内部库存中的任何内容), 显示<ItemLink id="interface" />将会将该物品推入网络存储。