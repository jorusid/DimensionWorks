---
navigation:
  parent: example-setups/example-setups-index.md
  title: Furnace 火爆自动化
  icon: minecraft:furnace
---

# Furnace 火爆自动化

请注意,由于此用途 a<ItemLink id="pattern_provider" />,它意指融入[自动自制](../ae2-mechanics/autocrafting.md)
设置。如果您只想将一个炉子独立自动化, 请使用 lippers 和 pricks 之类的。

自动调<ItemLink id="minecraft:furnace" />比简单机器自动化复杂多了一点[充电器](../example-setups/charger-automation.md).
熔炉需要两个不同的侧面输入, 从第三个侧端提取。要熔化的物品必须被推到顶部,
燃料必须放在侧面,结果必须从底部取出。 

可通过下列途径:<ItemLink id="pattern_provider" />
在顶顶上,<ItemLink id="export_bus" />以便他们不断地用燃料和燃料,<ItemLink id="import_bus" />日期 上
将结果输入网络的底端。但是, 这使用 3[频道](../ae2-mechanics/channels.md).

仅用一个频道,你就可以做到这一点:

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/furnace_automation.snbt" />

<BoxAnnotation color="#dddddd" min="1 0 0" max="2 1 1">
        (1)样板供应器:通过使用赛特斯石英扳手,用相关的处理模式

        ![铁铁模式](../assets/diagrams/furnace_pattern_small.png)
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 1 0" max="2 1.3 1">
        (2)接口: 在其默认配置中。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 1 0" max="1.3 2 1">
        (3)存储总线#1:过滤到煤炭。
        <ItemImage id="minecraft:coal" scale="2" />
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 2 0" max="1 2.3 1">
        (4)存储总线#2:用反转卡将煤列入黑名单。
        <Row><ItemImage id="minecraft:coal" scale="2" /><ItemImage id="inverter_card" scale="2" /></Row>
  </BoxAnnotation>

<DiamondAnnotation pos="4 0.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* <ItemLink id="pattern_provider" />(1)处于默认配置中,且相关<ItemLink id="processing_pattern" />.
    使用<ItemLink id="certus_quartz_wrench" />开始吧

  ![铁铁模式](../assets/diagrams/furnace_pattern.png)

* <ItemLink id="interface" />(2)默认配置。
* 第一个<ItemLink id="storage_bus" />(3)过滤到煤炭或任何你想使用的燃料。
* 第二次<ItemLink id="storage_bus" />(4)使用<ItemLink id="inverter_card" />.

## 如何运作

1. <ItemLink id="pattern_provider" />将元素推进<ItemLink id="interface" />.
   (实际上,作为一种优化,它直接通过存储总车,好像是样板供应器面部的延伸。这些物品从未实际进入接口。)
2. 接口设置为不存储任何存储, 所以它试图将原料推入[网络存储](../ae2-mechanics/import-export-storage.md).
3. 绿色子网上唯一的存储库是<ItemLink id="storage_bus" />Ses. 被过滤到煤炭的总线将煤放在炉子燃料槽的侧面。
    被过滤到非煤的总线将要熔化的物品放在顶层槽中,贯穿顶部脸部。
4. 熔炉的熔化炉
5. 直升机从炉子底部取出结果 把它们放到样板供应器的回程槽里 回到主网络
