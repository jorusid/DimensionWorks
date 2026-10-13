---
navigation:
  title: 开始(1.20+)
  position: 10
---

<div class="notification is-info">
  以下信息仅适用于 Minecraft 1.20 及更新版本中的应用能源 2。
</div>

# 开始

## 获取初始材料

<GameScene zoom="4" background="transparent">
  <ImportStructure src="assets/assemblies/meteor_interior.snbt" />
</GameScene>

要开始使用应用能源 2，必须首先找到[陨石](ae2-mechanics/meteorites.md)。这些相当常见, 并且往往在地形上留下巨大的洞, 所以你可能已经遇到一个 在旅行中。
如果没有，你可以制作一个<ItemLink id="meteorite_compass" />,它将指向最近的<ItemLink id="mysterious_cube" />.

一旦你发现一颗陨石, 挖掘到它的中心, 你会发现赛特斯石英簇,赛特斯石英芽,[赛特斯石英母岩](items-blocks-machines/budding_certus.md)以及位于中心的神秘方块。

开采你发现的赛特斯石英簇和赛特斯石英块。你也可以采集赛特斯石英母岩，但若不使用精准采集，它们会降低一个等级。

不要破坏任何无瑕的赛特斯石英母岩；即使使用精准采集，它们也会退化为有瑕的赛特斯石英母岩，而且无法恢复为无瑕状态。

还要挖掘陨石中心的神秘方块，以获得全部 4 个压印模板。

## 培育赛特斯石英

<GameScene zoom="4" background="transparent">
<ImportStructure src="assets/assemblies/budding_certus_1.snbt" />
</GameScene>

赛特斯石英芽会从[赛特斯石英母岩](items-blocks-machines/budding_certus.md)上长出，与紫水晶类似。如果破坏尚未长成的芽
它会掉落一个<ItemLink id="certus_quartz_dust" />，不受时运影响。如果破坏完全长成的晶簇，它会掉落四个
<ItemLink id="certus_quartz_crystal" />，时运会增加掉落数量。

赛特斯石英母岩共有 4 个等级：无瑕、有瑕、开裂和损坏。

<GameScene zoom="4" background="transparent">
<ImportStructure src="assets/assemblies/budding_blocks.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

每当一个芽生长在另一个阶段, 赛特斯石英母岩 有机会降解 在一个层次,最终变成
普通的赛特斯石英块.它们可以修复(创建新的母岩)扔出赛特斯石英母岩(或 a/
赛特斯石英块)水中含有一种或多种<ItemLink id="charged_certus_quartz_crystal" />.

<RecipeFor id="damaged_budding_quartz" />

无瑕的赛特斯石英母岩不会退化，并且会无限产生赛特斯石英。但它们无法被合成或移动
，即使使用精准采集也不行。(和*能够*移动[空间存储](ae2-mechanics/spatial-io.md)虽然)

单靠自己赛特斯石英芽生长非常缓慢,幸运的是<ItemLink id="growth_accelerator" />大规模
当放置在萌芽区块附近时, 加速此进程。您应该将其中的几处建起作为您的第一优先。

<GameScene zoom="4" background="transparent">
<ImportStructure src="assets/assemblies/budding_certus_2.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

如果你没有足够的石英 来做一个<ItemLink id="energy_acceptor" />或<ItemLink id="vibration_chamber" />,
您可以做一个<ItemLink id="crank" />并坚持在你的加速器的尽头。

自动收获赛特斯石英[此处说明](example-setups/simple-certus-farm.md).

## 关于福鲁伊克斯的简要说明

你需要的另一种材料是福鲁伊克斯，你在制作晶体催生器时已经见过它。将充能赛特斯石英、红石和下界石英丢入水中即可制成。自动完成这一过程“留作读者的练习”。

<ItemLink id="charger" />生产所需<ItemLink id="charged_certus_quartz_crystal" />如果你还没有做的话

## 压印一些处理器

在你对陨石的搜刮中,你将发现四颗 "压印模板"打破"神秘方块。这些用在<ItemLink id="inscriber" />来合成三种类型的处理器。

<ItemGrid>
  <ItemIcon id="silicon_press" />

  <ItemIcon id="logic_processor_press" />

  <ItemIcon id="calculation_processor_press" />

  <ItemIcon id="engineering_processor_press" />
</ItemGrid>

压印器是一个侧面机器,非常像原版熔炉。从上方或下方的位置插入物品,从侧面或后方插入到中间槽位。结果可以从侧面或背面拉动。

使用漏斗可以方便自动化（并可能减少管道杂乱）,压印器可使用<ItemLink id="certus_quartz_wrench" />.

在准备下一步工作时,每种处理器都生产出几种加工处理器,使程序非常基本。ME 系统。自动处理器生产是“留作读者的练习”。

## 物质能源技术:ME 网络和存储

### 什么是 ME 存储?

其宣布的 EM-EEEAE, 并代表物质能源。

能源是能源的主要组成部分应用能源 2 就像是疯狂的科学家版的多锁箱
它可以改变你的存储状况 ME 与国内其他存储系统极为不同 Minecraft,和
可能要花一小点心思才能习惯 但一旦你开始大量存储在
空间和多个接入终端 只是可能的冰山的一角

### 要开始我需要知道什么?

首先,ME 其他物品内存放的物品,称为[存储电池](items-blocks-machines/storage_cells.md);有 5 个层级,其数量不断增加
用于使用存储元件必须放在<ItemLink id="chest" />,
或 a/<ItemLink id="drive" />.

<ItemLink id="chest" />单元格内容一放入内,你就显示它的内容。
可以如同 a 一样从中添加和删除物品<ItemLink id="minecraft:chest" />,但物品为
实际存储在存储单元格中,而不是<ItemLink id="chest" />本身。

期间的<ItemLink id="chest" />是一个很好的方法 来介绍 ME,以真正
需要设置[ME 网络网网](ae2-mechanics/me-network-connections.md).

## 你最先 ME 系统

现在,你已经拥有了所有的基本材料和机器应用能源 2,你可以第一次 ME(能源)这将是一个非常基本的系统, 没有汽车,没有物流, 只是很好,简单,可以搜索的存储。

<GameScene zoom="6" interactive={true}>
<ImportStructure src="assets/assemblies/tiny_me_system.snbt" />

</GameScene>

*   您的原料列表 :
    * 1x<ItemLink id="drive" />
    * 1x<ItemLink id="terminal" />或<ItemLink id="crafting_terminal" />
    * 1x<ItemLink id="energy_acceptor" />
    * 几个[电缆](items-blocks-machines/cables.md),要么玻璃, 遮盖, 或者聪明, 但并不稠密
    * 几个[存储单元格](items-blocks-machines/storage_cells.md),建议 4k 品种的 4K
    和类型的能力和类别(更有效率,[分区](items-blocks-machines/cell_workbench.md)4k 和 1k 的混合体 但是现在我们不会进入这个复杂问题)
---
1.  把驱动器放下
2.  能源接收器(和若干其他 AE2[设备](ae2-mechanics/devices.md))以 2 模式、立方体和平平的两种方式, 共产生两个模式。它们可以在编织网格中互换。如果您的能源接收器是立方体,把它放在驱动器旁边。如果它是平方,请在硬盘上安装电缆,并安装接收器。
3.  将能量冲入能源接收器与电缆/管道/连接 从你最喜欢的能源产生模式。
4.  在驱动器顶部放置电缆(或其他在眼部水平)确定您的终点点,或合成终端开始吧
5.  将存储单元格放入驱动器
6.  利润
7.  与终端的设置相调和
8.  在你终极力量和能力中打屁股
9.  意识到这个网络在大计划里 相当小

### 正在扩展您的网络

所以,你有一些基本的存储器, 和进入该存储库, 这是一个良好的开始, 但你可能正在寻找
使一些处理过程自动化。

其中一个很好的例子就是<ItemLink id="export_bus" />在火炉的顶端,
矿砂中倾弃物,和<ItemLink id="import_bus" />
在毛皮底部 提取熔炉矿石。

<ItemLink id="export_bus" />使您能够从网络中导出物品,然后导入所附的
清单,而<ItemLink id="import_bus" />从所附清单中进口的物项
网络。

### 克服限制

此时此刻你可能接近八点左右[设备](ae2-mechanics/devices.md)一旦击中 9 个装置,你就得开始
管理[频道](ae2-mechanics/channels.md)。许多设备,但并非全部,需要一条渠道
函数。

默认情况下网络可以支持 8 个频道, 一旦您打破此限制, 您必须添加
a , a)<ItemLink id="controller" />这可以大大扩展网络
[智能电缆](items-blocks-machines/cables.md)将允许您看到频道如何通过您的网络。在开始学习频道是如何运作的时, 或如果您有很多红石和光石, 请广泛使用它们。
