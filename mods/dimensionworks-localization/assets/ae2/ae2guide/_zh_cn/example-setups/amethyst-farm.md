---
navigation:
  parent: example-setups/example-setups-index.md
  title: 阿米思斯特农场
  icon: minecraft:amethyst_shard
---

# 种植阿米塞斯特

期间的<ItemLink id="growth_accelerator" />用于防腐蚀的常规过滤方法[赛特斯芽芽](../items-blocks-machines/budding_certus.md)
与 a 具有<ItemLink id="annihilation_plane" />与不成熟的不一样,不以复合的芽为试验对象。赛特斯下落的芽芽
<ItemLink id="certus_quartz_dust" />,非自然的 复合蕾丝芽 落空无踪,所以破坏面板总是会打碎他们
因为网络总能存储"什么都没有"

绕着这个方向是迷惑破坏面板与精准采集。然后非自然的复合芽芽*do do 做*放下东西
(物理芽块不同阶段),从而可以被过滤。

<ItemLink id="minecraft:amethyst_cluster" />然后必须由 a 重新放置<ItemLink id="formation_plane" />,然后成为
被一个<ItemLink id="annihilation_plane" />无无精准采集,以获得<ItemLink id="minecraft:amethyst_shard" />.

请注意,由于该组具有方向性,因此必须有一个与成型面板.

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/amethyst_farm.snbt" />

  <BoxAnnotation color="#dddddd" min="2.7 1 1" max="3 2 2">
        (1)破坏面板#1:没有 GUI 要配置,但被施魔法精准采集.
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2 1 1" max="2.3 2 2">
        (2)成型面板: 过滤到 Amethyst 群集。
        <ItemImage id="minecraft:amethyst_cluster" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1.3 0.7 1" max="2 1 2">
        (3)破坏面板#2:否 GUI 来配置,但可以用财富来施魔法。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1 0 1" max="1.3 1 2">
        (4)存储总线#1: 过滤到 Amenthyst Shard。
        <ItemImage id="minecraft:amethyst_shard" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="0 0 .7" max="1 1 1">
        (5)存储总线# 2 : 过滤到 Amenthyst Shard。优先级设置高于您主存储处。
        <ItemImage id="minecraft:amethyst_shard" scale="2" />
  </BoxAnnotation>

<DiamondAnnotation pos="0 0.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* 第一个<ItemLink id="annihilation_plane" />(1)没有无 GUI 并且无法配置, 但必须被施魔法精准采集.
* <ItemLink id="formation_plane" />(2)过滤到<ItemLink id="minecraft:amethyst_cluster" />.
* 第二次<ItemLink id="annihilation_plane" />(3)没有无 GUI 无法配置,但可以被魔法 与财富。
* 第一个<ItemLink id="storage_bus" />(4)过滤到<ItemLink id="minecraft:amethyst_shard" />.
* 第二次<ItemLink id="storage_bus" />(5)过滤到<ItemLink id="minecraft:amethyst_shard" />,并且拥有
  [优先](../ae2-mechanics/import-export-storage.md#storage-priority)设置高于主存储处。

## 如何运作

1. 第一个<ItemLink id="annihilation_plane" />试图打破前面的,但只能打破<ItemLink id="minecraft:amethyst_cluster" />
    因为子网上唯一的存储器是<ItemLink id="formation_plane" />,过滤到 ameethethyst 集。这只因为
飞机被施魔法精准采集否则它就能打破非成熟的芽 因为它们没有掉下来
2. <ItemLink id="formation_plane" />将晶簇置于反对区块上。
3. 第二次<ItemLink id="annihilation_plane" />制成<ItemLink id="minecraft:amethyst_shard" />.
4. 第一个<ItemLink id="storage_bus" />将碎片存储在桶内。
第二件事破坏面板遇到的应该是成熟的集群。
5. 第二次<ItemLink id="storage_bus" />主网络允许主网络进入桶内所有含铁晶碎片。
高[优先](../ae2-mechanics/import-export-storage.md#storage-priority)以便(真主使众人)享受至善的,
放在桶里,而不是在主仓库里
