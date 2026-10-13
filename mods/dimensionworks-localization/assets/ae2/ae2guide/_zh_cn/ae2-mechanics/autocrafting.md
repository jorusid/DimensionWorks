---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 手工手合成
  icon: pattern_provider
---

# 手工手合成

### 大号

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/autocraft_setup_greebles.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

汽车手工业是 AE2,而不是手动计算每个子内容的正确编号。
劳作,象工作一样,*普丁人*您可以询问您的 ME 系统来为你做它。或者自动地将物品加工并出口到某个地方。
或者通过聪明的突发行为自动保存一定数量的物品。它也与液体有关,如果有的话。
用于外型材料类型的某些加仑,例如 Mekanism 气体,那些材料,也不错

这是一个相当复杂的话题, 所以绑好绳子,我们走吧。

自动合成装置由三件事组成:
- 发送手写请求的东西
- 合成 CPU
- <ItemLink id="pattern_provider" />.

以下是接下来发生的情况:

1.  某事创造了一个手合成请求。这可能是您在终端点击一些可以自动合成的东西,
    或 a/输出总线或与手合成卡接口 要求其中一件 用于导出/存储的物品

*   (**重要:**使用任何您必须使用的“ 选择块块”(通常为中下移动)要求您已经拥有的手合成品, 这可能会与库存分类模式发生冲突),

2.  ME 系统计算所需原料和满足请求的先决条件设计步骤,并将其存储在选定的合成 CPU

3.  <ItemLink id="pattern_provider" />有关缔约方与相关[样式](../items-blocks-machines/patterns.md)将图案中指定的原料推到任何相邻的清册中。
    用于计算餐桌食谱的(一种“手合成模式”)这将是<ItemLink id="molecular_assembler" />.
    在非合成食谱的情况下:(a “处理模式”)这将是一些其他块或机器 或精心设计的红石控制装置。

4.  以某种方式 返回到系统 无论是由输入总线、接口或将结果推回样板供应器.
    **请注意,“物品输入系统”事件必须发生, 你不能仅仅将结果用<ItemLink id="storage_bus" />开始吧**

5.  如果该飞行器是请求中另一飞行器的前提条件,这些物项存储在合成 CPU 然后用在那个木器上。

# 模式

<ItemImage id="crafting_pattern" scale="4" />

以<ItemLink id="pattern_encoding_terminal" />空白模式的空白。

不同事物有几种不同的模式:

*   <ItemLink id="crafting_pattern" />由设计表格合成的编码配方编码。它们可以直接放在<ItemLink id="molecular_assembler" />让它成为
    当给定原料,但其主要用途为<ItemLink id="pattern_provider" />旁边分子装配室.
    样板供应器在这种情况下有特殊行为,并将将有关模式和原料连同原料发送到邻近装配厂。
    由于装配人自动将手合成结果输入邻近的库存清单,因此,一个组装人将样板供应器是自动生成图案所需的全部。

***

*   <ItemLink id="smithing_table_pattern" />与设计图案非常相似, 但是它们编码了拼装表格食谱。它们也用一个图法自动
    样板供应器和样板供应器分子装配室事实上,设计、铁匠和石块切割模式
    在同一设置中使用。

***

*   <ItemLink id="stonecutting_pattern" />与编织图案非常相似, 但是它们编码石墨配方。它们也用一种图法自动
    样板供应器和样板供应器分子装配室事实上,设计、铁匠和石块切割模式
    在同一设置中使用。

***

*   <ItemLink id="processing_pattern" />汽车手合成的灵活度来自其中。它们是最普遍的类型,很简单
    说:"如果样板供应器将这些原料推向相邻的库存清单,ME 系统将在
    或近近的或远的将来。他们都是你用几乎任何变形的机器,或火炉等,来合成他们的。因为他们是这样的。
    在使用中一般使用, 且不关心在推进原料和接收结果之间会发生什么, 您可以做一些非常有趣的东西, 比如输入
    整个复杂的工厂生产链的原料 将整理出材料 吸收出无穷生产的其他原料
    印刷《蜜蜂电影》的剧本 ME 系统只要得到模式所指定的结果, 就不会在意。事实上,
    它根本不在乎原料是否与结果有任何关系。你可以告诉它“1 樱桃木木板 = 1 根恒星”
    你枯萎的农场在接到樱桃木板后 杀死一片枯燥的枯草 它会起作用的

多个<ItemLink id="pattern_provider" />相同的模式得到支持,并平行工作。此外,您还可以使用一种模式来表示,
例如,8 个可碎石 = 8 块石头,而不是 1 个 可碎岩 等于 1 颗石头样板供应器将插入 8 COB 石
每一次行动都安排好 而不是一次行动

## “父亲”的最一般形式

实际上,“模式”的“一般”形式甚至比处理模式更为“通用”。<ItemLink id="level_emitter" />手合成卡可以设置
发出一个红石信号,以便合成某种东西。这个“模式”没有定义,甚至没有关注原料。
上面写着"如果你从这层排放物中 释放出红石 ME 系统将在
通常用于激活和拆除不需要投入原料的无限农场,
或激活一个处理循环食谱的系统(标准自动隐藏无法理解)例如,“1 个可碎石 = 2 块可裂石”
如果你有一台机器 复制了可塑石

# 术术 CPU

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/crafting_cpus.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

手合成的 CPU 管理手写要求/工作,它们存储中间原料,同时用多步制来合成工作。
这些工作正在进行中,影响到大型工作的规模和完成的速度。它们是多区,以及
必须是至少 1 的矩形棱晶体合成存储.

合成式 CPU 由下列单位制成:

*   (所需)[手合成存储库](../items-blocks-machines/crafting_cpu_multiblock.md),在所有标准单元格大小中都可用(1k, 4k, 16k, 64k, 256k)它们存储原料和
    合成品中含有的中间原料,因此需要较大的或更多的存储库,以达到以下条件:CPU 处理手合成工作
    含有更多原料。
*   (任择)<ItemLink id="crafting_accelerator" />,它们使系统发送更多的原料批量 从样板供应器。
    允许,例如,a 样板供应器由 6 个分子组装器包围,将原料发送到(并因此使用)全部六点一次,而不是一个
*   (任择)<ItemLink id="crafting_monitor" />,他们展示了工作 CPU 正在处理中。它们可以通过<ItemLink id="color_applicator" />
*   (任择)<ItemLink id="crafting_unit" />,它们只是填补空间,以便 CPU 矩形棱柱。

每个合成 CPU 处理 1 个请求或工作, 所以如果您想要同时请求计算处理器和 256 块平滑石, 您需要 2。CPU 多个区块。

他们可以处理球员的要求,自动化(导出总车和接口)或者两者兼而有之

# 模式型提供商

<Row>
<BlockImage id="pattern_provider" scale="4" />

<BlockImage id="pattern_provider" p:push_direction="up" scale="4" />

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/blocks/cable_pattern_provider.snbt" />
</GameScene>
</Row>

<ItemLink id="pattern_provider" />您的自制系统与世界互动的主要方式。它们将元素推入
其[模式](../items-blocks-machines/patterns.md)相邻的库存,物品可以插入其中,以便插入网络。
将机器的输出再回到附近时, 通道就可以被保存样板供应器(经常推动原料的)
而不是使用<ItemLink id="import_bus" />将机器的输出拉入网络。

值得注意的是,由于它们直接将原料从[合成存储](../items-blocks-machines/crafting_cpu_multiblock.md#crafting-storage)a 中合成 CPU,他们
从未将原料包含在他们的库存中, 所以您无法从中解开。您必须让样板供应器推
对另一个清单的(像桶一样)然后从那管。

另外,样板供应器必须同时推所有原料, 不能推半个孔。这很有用
剥削。

样板供应器与[子网](../ae2-mechanics/subnetworks.md):如果接口未修改(请求空档中无)
提供商将完全跳过接口 直接按到子网[存储](../ae2-mechanics/import-export-storage.md),
跳过接口,不填满配方批量, 更重要的是,在存储空间之前不要插入下一批。

支持模式相同的多种模式样板供应器,并平行运作。

样板供应器将试图将分批的物品围在他们所有的脸部,从而同时使用所有附属机器。

## 变式

样板供应器有三个不同的变式:正常、方向和平坦。这影响到他们推向的具体边
元素,接收物品,并提供网络连接。

*   正常样板供应器将原料推向各方,接受各方的投入,并像大多数样板供应器一样 AE2 机器,动作
    就像一条线 提供网络连接到所有侧面

*   使用<ItemLink id="certus_quartz_wrench" />正常时样板供应器更改
    方向。它们只将原料推向选定侧面, 接收来自各方的投入, 尤其是不提供网络
    选择的侧面的连接。这样他们就可以按到 AE2 如果您想要创建子网络, 则不连接网络的机器。

*   平板型样样板供应器是[有线子分区](../ae2-mechanics/cable-subparts.md),因此可以在同一条电缆上安装多个,允许设置压缩装置。
    它们在方向上与选定方相似样板供应器提供模式、接受投入,而不是
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

可以通过单击扳手在 GUI. 在几个案件中[模式](../items-blocks-machines/patterns.md)
对于同一物品,优先程度较高的样板供应器模式将相对于优先度较低的样板供应器的模式使用,
除非网络没有更高优先级模式的原料。

# 分子组装器

<BlockImage id="molecular_assembler" scale="4" />

<ItemLink id="molecular_assembler" />将物品输入它,并进行相邻物品定义的操作<ItemLink id="pattern_provider" />,
插入<ItemLink id="crafting_pattern" />,<ItemLink id="smithing_table_pattern" />,或<ItemLink id="stonecutting_pattern" />,
然后将结果推到相邻的清点中。

其主要用途在<ItemLink id="pattern_provider" />模式样板供应器在这种情况下有特殊行为
并会将有关模式的信息和原料连同原料发送给相邻的装配组装组。
手合成类相邻库存清单(从而进入了缔约方的返回位置样板供应器),一个装配器样板供应器
是自动生成图案所需的全部。

<GameScene zoom="4" background="transparent">
<ImportStructure src="../assets/assemblies/assembler_tower.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>
