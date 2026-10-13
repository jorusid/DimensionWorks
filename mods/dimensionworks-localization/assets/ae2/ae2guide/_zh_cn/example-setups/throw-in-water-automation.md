---
navigation:
  parent: example-setups/example-setups-index.md
  title: 水中投掷自动化
  icon: fluix_crystal
---

# 将投入水中食用物投放自动化

请注意,由于此用途 a<ItemLink id="pattern_provider" />,它意指融入[自动自制](../ae2-mechanics/autocrafting.md)
设置。

有些食谱要求将物品扔入水中(虽然可以使用类似的设置来扔东西到其他地方).
这可以自动<ItemLink id="formation_plane" />,<ItemLink id="annihilation_plane" />,以及一些支持
基础设施(基本上为 2 已修改[管道子网](pipe-subnet.md)).

此设置意在与[充电器自动化](charger-automation.md)提供<ItemLink id="charged_certus_quartz_crystal" />.

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/throw_in_water.snbt" />

<BoxAnnotation color="#dddddd" min="2 0 1" max="3 1 2">
        (1)样板供应器:在默认配置中,使用相关处理模式。

        ![福鲁伊克斯模式](../assets/diagrams/fluix_pattern_small.png)![易闪闪烧模式](../assets/diagrams/flawed_budding_pattern_small.png)
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1.7 0 1" max="2 1 2">
        (2)接口: 在其默认配置中。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 .7 1" max="2 1 2">
        (3)成型面板: 设置将输入作为物品投放。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 2 1" max="2 2.3 2">
        (4)破坏面板:否 GUI 要配置。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="2 1 1" max="3 1.3 2">
        (5)存储总线:过滤到模式输出
        <Row><ItemImage id="fluix_crystal" scale="2" /><BlockImage id="flawless_budding_quartz" scale="2" /></Row>
  </BoxAnnotation>

<DiamondAnnotation pos="3.9 0.5 1.5" color="#00ff00">
        致主网络和充电自动
        <GameScene zoom="3" background="transparent">
          <ImportStructure src="../assets/assemblies/charger_automation.snbt" />
          <IsometricCamera yaw="195" pitch="30" />
        </GameScene>
    </DiamondAnnotation>

  <IsometricCamera yaw="180" pitch="0" />
</GameScene>

## 配置和模式

* <ItemLink id="pattern_provider" />(1)处于默认配置中,且相关<ItemLink id="processing_pattern" />
  * 用于<ItemLink id="fluix_crystal" />默认食谱的默认配方 JEIREI 工作顺利:

    ![福鲁伊克斯模式](../assets/diagrams/fluix_pattern.png)

  * 用于<ItemLink id="flawed_budding_quartz" />最好直接从<ItemLink id="quartz_block" />,
    从而避免了一种配方的投入是另一种配制的输出,从而导致存储总线无法过滤 :

    ![易闪闪烧模式](../assets/diagrams/flawed_budding_pattern.png)

* <ItemLink id="interface" />(2)默认配置。
* <ItemLink id="formation_plane" />(3)设置为作为物品投放输入。
* <ItemLink id="annihilation_plane" />(4)没有无 GUI 无法配置。
* <ItemLink id="storage_bus" />(5)过滤到模式的输出。

## 如何运作

1.  <ItemLink id="pattern_provider" />将元素推进<ItemLink id="interface" />在绿色的子网上,
2.  接口界面(被配置为默认不存储任何文件)试图将其内容推入[网络存储](../ae2-mechanics/import-export-storage.md)
3.  绿色子网上唯一的存储库是<ItemLink id="formation_plane" />,它把所接收的物品投入水中
4.  <ItemLink id="annihilation_plane" />在橙橙子网上试图 捡起那些刚刚丢掉的物品 但是不能 因为
    排<ItemLink id="storage_bus" />上样板供应器(橙色子网上唯一的存储器)过滤,只接收可能的手合成品的结果
5.  这些物品进行着它们在世界范围内的转换。
6.  破坏面板现在可以拿起物品 在它前面,作为存储总线被允许存储它们。
7.  存储总线所存储的物品样板供应器让他们返回网络
