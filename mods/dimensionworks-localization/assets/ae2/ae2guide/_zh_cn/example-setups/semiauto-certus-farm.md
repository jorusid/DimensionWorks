---
navigation:
  parent: example-setups/example-setups-index.md
  title: 半自动赛特斯农场
  icon: certus_quartz_crystal
  position: 115
---

# 半自动赛特斯农场

不幸的是,[简单赛特斯农场](simple-certus-farm.md)a 需要<ItemLink id="flawless_budding_quartz" />充分工作以充分
自动。这需要其中之一[空间 IO](../ae2-mechanics/spatial-io.md)或建造农场[陨石](../ae2-mechanics/meteorites.md).

不过,AE2 和断开的砖块,所以它可能只是
有可能成为你的农场*替换赛特斯石英母岩为您提供的*.(您必须定期插入一些
<ItemLink id="flawed_budding_quartz" />输入桶和提取<ItemLink id="quartz_block" />所花的
布丁赛特斯桶桶)

要完全自动完成此功能,请查看[高级赛特斯农场](advanced-certus-farm.md).

这个农场比这个农场复杂得多[简单赛特斯农场](simple-certus-farm.md),因为它实际上是
3 个分开的套装 一起挤在一起

**这是一个完整的连接 与东西隐藏的 HIDDEN 背后的其它的东西, 围成一整圈 从所有语言中观察它**

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/semiauto_certus_farm.snbt" />

  <BoxAnnotation color="#ddaaaa" min="3.7 2 1" max="4 3 2">
        (1)破坏面板#1:没有 GUI 来配置,但可以用财富来施魔法。
  </BoxAnnotation>

  <BoxAnnotation color="#ddaaaa" min="2 2 1" max="2.3 3 2">
        (2)存储总线# # 1: 过滤到赛特斯石英水晶体
        <ItemImage id="certus_quartz_crystal" scale="2" />
  </BoxAnnotation>

  <DiamondAnnotation pos="3 2.5 1.5" color="#ff0000">
    群组断盘子网
  </DiamondAnnotation>

  <BoxAnnotation color="#aaddaa" min="3.7 1 1" max="4 2 2">
        (3)破坏面板#2:否 GUI 要配置,但被施魔法精准采集.
  </BoxAnnotation>

  <BoxAnnotation color="#aaddaa" min="2 1 1" max="2.3 2 2">
        (4)存储总线# 2: 过滤到赛特斯石英块.
        <BlockImage id="quartz_block" scale="2" />
  </BoxAnnotation>

  <DiamondAnnotation pos="3 1.5 1.5" color="#00ff00">
    赛特斯块断开器子网
  </DiamondAnnotation>

  <BoxAnnotation color="#ffddaa" min="4 0.7 1" max="5 1 2">
        (5)成型面板:在其默认配置中。
  </BoxAnnotation>

  <BoxAnnotation color="#ffddaa" min="2 0 1" max="2.3 1 2">
        (6)输入总线:在其默认配置中。
  </BoxAnnotation>

  <DiamondAnnotation pos="3 0.5 1.5" color="#ddcc00">
    正在 Dudding 块块放置器子网
  </DiamondAnnotation>

  <BoxAnnotation color="#aaaadd" min="0.7 2 1" max="1 3 2">
        (7)存储总线# 3: 过滤到赛特斯石英水晶 优先级设定高于主贮存
        <ItemImage id="certus_quartz_crystal" scale="2" />
  </BoxAnnotation>

    <DiamondAnnotation pos="1.5 0.5 1.5" color="#00ff00">
        手插入易燃赛特斯石英母岩石卫一
        <BlockImage id="flawed_budding_quartz" scale="2" />
    </DiamondAnnotation>

    <DiamondAnnotation pos="1.5 1.5 1.5" color="#00ff00">
        手工提取赛特斯石英块.
        <BlockImage id="quartz_block" scale="2" />
    </DiamondAnnotation>

<DiamondAnnotation pos="0.5 0.5 0" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="165" pitch="5" />
</GameScene>

## 配置

### 组断开器 :

* 第一个<ItemLink id="annihilation_plane" />(1)没有无 GUI 并且无法配置,但可以被财富魔法所迷惑。
* 第一个<ItemLink id="storage_bus" />(2)过滤到<ItemLink id="certus_quartz_crystal" />.

### 赛特斯块断开器 :

* 第二次<ItemLink id="annihilation_plane" />(3)没有无 GUI 并且无法配置, 但必须被施魔法精准采集.
* 第二次<ItemLink id="storage_bus" />(4)过滤到<ItemLink id="quartz_block" />.

### 混凝土块放置器( D) :

* <ItemLink id="formation_plane" />(5)默认配置。
* <ItemLink id="import_bus" />(6)默认配置。

### 主网络 :

* 第三次<ItemLink id="storage_bus" />(7)过滤到<ItemLink id="certus_quartz_crystal" />,并且拥有
  [优先](../ae2-mechanics/import-export-storage.md#storage-priority)设置高于主存储处。

## 如何运作

### 组断开器 :

集束断裂器子网与[简单赛特斯农场](simple-certus-farm.md).

1. <ItemLink id="annihilation_plane" />试图打破前面的,但只能打破<ItemLink id="quartz_cluster" />
   因为子网上唯一的存储器是<ItemLink id="storage_bus" />,过滤到<ItemLink id="certus_quartz_crystal" />.
2. <ItemLink id="storage_bus" />存储赛特斯石英桶里有水晶

### 赛特斯块断开器

赛特斯块断裂器子网一旦变成平原,就会打破耗竭的起始块<ItemLink id="quartz_block" />.
它的工作与分组断裂器类似。

1. <ItemLink id="annihilation_plane" />试图打破前面的,但只能打破<ItemLink id="quartz_block" />
   因为子网上唯一的存储器是<ItemLink id="storage_bus" />,过滤到<ItemLink id="quartz_block" />.
   飞机需要飞机精准采集,这样,开始的块不会退化 被打破, 因此飞机不会打破它过早。
2. <ItemLink id="storage_bus" />存储赛特斯石英块在已用
   布丁赛特斯桶,你必须手动把它扔进水里<ItemLink id="charged_certus_quartz_crystal" />以刷新它。

### 介面块放置器

正在萌芽的块放置器子网将放置一个新的<ItemLink id="flawed_budding_quartz" />当断线器的下网破碎时,

1. <ItemLink id="import_bus" />从输入桶进口一个刚开始的块。
2. 子网上唯一的存储器是<ItemLink id="formation_plane" />,它放置了萌芽区块。

### 主网络

* <ItemLink id="storage_bus" />主网络(以及《公约》[充电自动](charger-automation.md))A. 访问所有无障碍环境、赛特斯石英水晶体在桶内。
  高[优先](../ae2-mechanics/import-export-storage.md#storage-priority)因此,赛特斯石英水晶是优美的,
  放在桶里,而不是在主仓库里