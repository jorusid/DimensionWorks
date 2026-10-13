---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 赛特斯增长 增长率
  icon: quartz_cluster
---

# 赛特斯增长 增长率

## 基本上只是从获取开始页面上打印的版面

<GameScene zoom="6" background="transparent">
<ImportStructure src="../assets/assemblies/budding_certus_1.snbt" />
</GameScene>

赛特斯石英芽会从[赛特斯石英母岩](../items-blocks-machines/budding_certus.md)上长出，与紫水晶类似。如果破坏尚未长成的芽
它会掉落一个<ItemLink id="certus_quartz_dust" />，不受时运影响。如果破坏完全长成的晶簇，它会掉落四个
<ItemLink id="certus_quartz_crystal" />，时运会增加掉落数量。

赛特斯石英母岩共有 4 个等级：无瑕、有瑕、开裂和损坏。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/budding_blocks.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

每当一个芽生长在另一个阶段, 赛特斯石英母岩 有机会降解 在一个层次,最终变成
普通的赛特斯石英块.它们可以修复(创建新的母岩)扔出赛特斯石英母岩(或 a/
赛特斯石英块)水中含有一种或多种<ItemLink id="charged_certus_quartz_crystal" />.

<RecipeFor id="damaged_budding_quartz" />

无瑕的赛特斯石英母岩不会退化，并且会无限产生赛特斯石英。但它们无法被合成或移动
，即使使用精准采集也不行。(和*能够*移动[空间存储](../ae2-mechanics/spatial-io.md)虽然)

单靠自己赛特斯石英芽生长非常缓慢,幸运的是<ItemLink id="growth_accelerator" />大规模
当放置在萌芽区块附近时, 加速此进程。您应该将其中的几处建起作为您的第一优先。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/budding_certus_2.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

如果你没有足够的石英 来做一个<ItemLink id="energy_acceptor" />或<ItemLink id="vibration_chamber" />,
您可以做一个<ItemLink id="crank" />并坚持在你的加速器的尽头。

自动收获赛特斯石英[此处说明](../example-setups/simple-certus-farm.md).
