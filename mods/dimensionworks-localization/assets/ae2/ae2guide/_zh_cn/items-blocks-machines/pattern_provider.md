---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 样板供应器
  icon: pattern_provider
  position: 210
categories:
- devices
item_ids:
- ae2:pattern_provider
- ae2:cable_pattern_provider
---

# 样板供应器

<Row gap="20">
<BlockImage id="pattern_provider" scale="8" />
<BlockImage id="pattern_provider" p:push_direction="up" scale="8" />
<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/blocks/cable_pattern_provider.snbt" />
</GameScene>
</Row>

样板供应器是[自动自制](../ae2-mechanics/autocrafting.md)系统与世界互动。它们将元素推入
其[模式](patterns.md)相邻的库存,物品可以插入其中,以便插入网络。
将机器的输出再回到附近时, 通道就可以被保存样板供应器(经常推动原料的)
而不是使用<ItemLink id="import_bus" />将机器的输出拉入网络。

值得注意的是,由于它们直接将原料从[合成存储](crafting_cpu_multiblock.md#crafting-storage)a 中合成 CPU,他们
从未将原料包含在他们的库存中, 所以您无法从中解开。您必须让样板供应器推
对另一个清单的(像桶一样)然后从那管。

另外,样板供应器必须同时推所有原料, 不能推半个孔。这很有用
剥削。

样板供应器与[子网](../ae2-mechanics/subnetworks.md):如果接口未修改(请求空档中无)
提供商将完全跳过接口 直接按到子网[存储](../ae2-mechanics/import-export-storage.md),
跳过接口,不填入配方批次,更重要的是,在机器有空间之前,不要插入下一批。
这在屏蔽模式下正确工作, 提供商将监测机器中的空位的原料, 而不要监视接口中的空缺。

例如,这种设置将把要熔化的燃料和燃料直接推入炉内的相应槽。
您可以使用此模式向机器或多机器的多个侧面提供模式。

<GameScene zoom="6" background="transparent">
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

这是向多台机器提供的一般说明。

<GameScene zoom="6" background="transparent">
<ImportStructure src="../assets/assemblies/provider_interface_storage.snbt" />

<BoxAnnotation color="#dddddd" min="2.7 0 1" max="3 1 2">
        界面(必须是平平的,而不是满满的)
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 0 0" max="1.3 1 4">
        存储库
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 0 0" max="1 1 4">
        您想要提供模式提供的位置
  </BoxAnnotation>

<IsometricCamera yaw="185" pitch="30" />
</GameScene>

支持模式相同的多种模式样板供应器,并平行运作。

样板供应器将试图将分批的物品围在他们所有的脸部,从而同时使用所有附属机器。

## 变式

提供商有三种不同的变式:正常、方向和固定/固定。[下分部分](../ae2-mechanics/cable-subparts.md)这影响到它们所推动的具体方面。
元素,接收物品,并提供网络连接。

*   正常样板供应器将原料推向各方,接受各方的投入,并像大多数样板供应器一样 AE2 机器,动作
    就像一条线 提供网络连接到所有侧面

*   使用<ItemLink id="certus_quartz_wrench" />正常时样板供应器更改
    方向。它们只将原料推向选定侧面, 接收来自各方的投入, 尤其是不提供网络
    选择的侧面的连接。这样他们就可以按到 AE2 如果您想要创建子网络, 则不连接网络的机器。

*   平板型式样板供应器是[电缆子部件](../ae2-mechanics/cable-subparts.md),因此可以在同一条电缆上安装多个,允许设置压缩装置。
    它们在方向上与选定方相似样板供应器提供模式,接受投入,以及**否**
    提供他们脸上的网络连接。

样板供应器可以在正常和平坦的编织网格中互换。

## 设置

样板供应器有多种模式:

*   **阻塞模式**：如果机器中已有原料，样板供应器将停止推送新原料
    当机器中的原料被处理完后才会继续。
*   **锁定合成**可在各种红石条件下或直到产生结果时将样板供应器锁定在
    插入该特定的样板供应器.
*   样板供应器可以显示或隐藏于<ItemLink id="pattern_access_terminal" />.

## 优先

可以通过单击扳手在 GUI. 在几个案件中[模式](patterns.md)
对于同一物品,优先程度较高的样板供应器模式将相对于优先度较低的样板供应器的模式使用,
除非网络没有更高优先级模式的原料。

## 常见误解

出于某种原因 人们一直这么做 我不明白为什么 但我希望这能帮上忙(也许
人误认为<ItemLink id="export_bus" />只有这样,才能让事情脱离网络,不知道
样板供应器也出口物品)

这将不做您想要它做的事情。如前文所提及[电缆](cables.md),电缆不是物品管道,没有内部管道
样板供应器不会投入这些清单。

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/assemblies/provider_misconception_1.snbt" />

  <BoxAnnotation color="#dddddd" min="1 0 3" max="2 1 4">
        不是爆爆火
  </BoxAnnotation>

  <IsometricCamera yaw="95" pitch="5" />
</GameScene>

因为样板供应器没有东西可以推动,所以它会的
无法运作。它在这里所做的就是像电缆一样,连接着<ItemLink id="export_bus" />会 议 日 和 排
网络。

提供商也不会不知怎么告诉<ItemLink id="export_bus" />要导出什么,输出总线将只出口
你放进过滤器里的东西

我们基本上所做的是:

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/assemblies/provider_misconception_2.snbt" />

  <BoxAnnotation color="#dddddd" min="1 0 3" max="2 1 4">
        不是爆爆火
  </BoxAnnotation>

  <IsometricCamera yaw="95" pitch="5" />
</GameScene>

可能你真正想要做的就是这里样板供应器其模式的内容可以导出到
相邻的机器:

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/assemblies/provider_misconception_3.snbt" />

  <BoxAnnotation color="#dddddd" min="1 0 3" max="2 1 4">
        不是爆爆火
  </BoxAnnotation>

  <IsometricCamera yaw="95" pitch="5" />
</GameScene>

## 食食权

<RecipeFor id="pattern_provider" />

<RecipeFor id="cable_pattern_provider" />
