---
navigation:
  parent: example-setups/example-setups-index.md
  title: 简单赛特斯农场
  icon: certus_quartz_crystal
  position: 110
---

# 简单赛特斯农场

如前文所述[赛特斯增长 增长率](../ae2-mechanics/certus-growth.md)自动化的自动化<ItemLink id="certus_quartz_crystal" />
涉及伐木<ItemLink id="annihilation_plane" />和<ItemLink id="storage_bus" />Ses. 国家 
<ItemLink id="growth_accelerator" />用来大大加速赛特斯石英芽,然后飞机
断断完全增长<ItemLink id="quartz_cluster" />利用不成熟的可疑幸运特征过滤它们,
赛特斯芽芽下降<ItemLink id="certus_quartz_dust" />而不是空投任何东西。

这个农场完全自动运作<ItemLink id="flawless_budding_quartz" />但有缺陷, 芯片,和损坏
赛特斯石英母岩您必须手动替换 coming 块。或者, 如[半自动赛特斯农场](semiauto-certus-farm.md)
和[高级赛特斯农场](advanced-certus-farm.md),自动。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/simple_certus_farm.snbt" />

  <BoxAnnotation color="#dddddd" min="3.7 1 1" max="4 2 2">
        (1)破坏面板:否 GUI 来配置,但可以用财富来施魔法。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="3 1 1" max="3.3 2 2">
        (2)存储总线# # 1: 过滤到赛特斯石英水晶体
        <ItemImage id="certus_quartz_crystal" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="3 1 .7" max="2 2 1">
        (3)存储总线# 2: 过滤到赛特斯石英水晶,优先级设定高于主贮存。
        <ItemImage id="certus_quartz_crystal" scale="2" />
  </BoxAnnotation>

<DiamondAnnotation pos="1 0.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* 第一个<ItemLink id="annihilation_plane" />(1)没有无 GUI 无法配置,但可以被魔法 与财富。
* 第一个<ItemLink id="storage_bus" />(2)过滤到<ItemLink id="certus_quartz_crystal" />.
* 第二次<ItemLink id="storage_bus" />(3)过滤到<ItemLink id="certus_quartz_crystal" />,并且拥有
  [优先](../ae2-mechanics/import-export-storage.md#storage-priority)设置高于主存储。

## 如何运作

1. <ItemLink id="annihilation_plane" />试图打破前面的,但只能打破<ItemLink id="quartz_cluster" />
   因为子网上唯一的存储器是<ItemLink id="storage_bus" />,过滤到<ItemLink id="certus_quartz_crystal" />.
4. 第一个<ItemLink id="storage_bus" />存储赛特斯石英桶里有水晶
5. 第二次<ItemLink id="storage_bus" />提供所有赛特斯石英水晶体在桶内。
   高[优先](../ae2-mechanics/import-export-storage.md#storage-priority)因此,赛特斯石英水晶是优美的,
   放在桶里,而不是在主仓库里
