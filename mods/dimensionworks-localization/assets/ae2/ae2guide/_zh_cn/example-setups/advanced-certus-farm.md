---
navigation:
  parent: example-setups/example-setups-index.md
  title: 高级赛特斯农场
  icon: certus_quartz_crystal
  position: 120
---

# 高级赛特斯农场

这基本上只是[半自动赛特斯农场](semiauto-certus-farm.md),但已完全融入您的
ME 系统。

而不是有一大堆新形成的区块 和手动刷新它们 每隔一段时间,
此设置的用途[充电自动](charger-automation.md)和[水中投掷自动化](throw-in-water-automation.md)
自动进行。

**这是一个完整的连接 与东西隐藏的 HIDDEN 背后的其它的东西, 围成一整圈 从所有语言中观察它**

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/advanced_certus_farm.snbt" />

  <BoxAnnotation color="#ddaaaa" min="3.7 2 1" max="4 3 2">
        (1)破坏面板#1:没有 GUI 来配置,但可以用财富来施魔法。
  </BoxAnnotation>

  <BoxAnnotation color="#ddaaaa" min="2 2 1.7" max="3 3 2">
        (2)存储总线# # 1: 过滤到赛特斯石英水晶体
        <ItemImage id="certus_quartz_crystal" scale="2" />
  </BoxAnnotation>

  <DiamondAnnotation pos="3 2.5 1.5" color="#ff0000">
    群组断盘子网
  </DiamondAnnotation>

  <BoxAnnotation color="#aaddaa" min="3.7 1 1" max="4 2 2">
        (3)破坏面板#2:否 GUI 要配置,但被施魔法精准采集.
  </BoxAnnotation>

  <BoxAnnotation color="#aaddaa" min="2 1 1.7" max="3 2 2">
        (4)存储总线# 2: 过滤到赛特斯石英块.
        <BlockImage id="quartz_block" scale="2" />
  </BoxAnnotation>

  <DiamondAnnotation pos="3 1.5 1.5" color="#00ff00">
    赛特斯块断开器子网
  </DiamondAnnotation>

  <BoxAnnotation color="#ffddaa" min="4 0.7 1" max="5 1 2">
        (5)成型面板:在其默认配置中。
  </BoxAnnotation>

  <BoxAnnotation color="#ffddaa" min="2 0.7 2" max="3 1 3">
        (6)输入总线: 过滤到易燃赛特斯石英母岩石卫一
        <BlockImage id="flawed_budding_quartz" scale="2" />
  </BoxAnnotation>

  <DiamondAnnotation pos="3 0.5 1.5" color="#ddcc00">
    正在 Dudding 块块放置器子网
  </DiamondAnnotation>

  <BoxAnnotation color="#aaaadd" min="1.7 2 2" max="2 3 3">
        (7)存储总线# 3: 过滤到赛特斯石英水晶 优先级设定高于主贮存
        <ItemImage id="certus_quartz_crystal" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#aaaadd" min="2 1 2" max="3 2 3">
        (8)接口: 设置以保存 1 点赛特斯石英母岩 Quartz 本身就有手合成卡
        <Row><BlockImage id="flawed_budding_quartz" scale="2" /><ItemImage id="crafting_card" scale="2" /></Row>
  </BoxAnnotation>

<DiamondAnnotation pos="1.5 0.5 0" color="#00ff00">
        至主网络、充电自动和扔入水中的自动
        <Row>
        <GameScene zoom="3" background="transparent">
          <ImportStructure src="../assets/assemblies/charger_automation.snbt" />
          <IsometricCamera yaw="195" pitch="30" />
        </GameScene>
        <GameScene zoom="3" background="transparent">
          <ImportStructure src="../assets/assemblies/throw_in_water.snbt" />
          <IsometricCamera yaw="195" pitch="30" />
        </GameScene>
        </Row>
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
* <ItemLink id="import_bus" />(6)过滤到<ItemLink id="flawed_budding_quartz" />.

### 主网络 :

* 第三次<ItemLink id="storage_bus" />(7)过滤到<ItemLink id="certus_quartz_crystal" />,并且拥有
  [优先](../ae2-mechanics/import-export-storage.md#storage-priority)设置高于主存储处。
* <ItemLink id="interface" />(8)设置为保持 1 点赛特斯石英母岩本身就具有一个<ItemLink id="crafting_card" />.

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
2. <ItemLink id="storage_bus" />存储赛特斯石英块和在<ItemLink id="interface" />,允许
   [水中投掷自动化](throw-in-water-automation.md)使用它来合成新的<ItemLink id="flawed_budding_quartz" />.

### 介面块放置器

正在萌芽的块放置器子网将放置一个新的<ItemLink id="flawed_budding_quartz" />当断线器的下网破碎时,

1. <ItemLink id="import_bus" />导入来自<ItemLink id="interface" />与[网络存储](../ae2-mechanics/import-export-storage.md)
2. 子网上唯一的存储器是<ItemLink id="formation_plane" />,它放置了萌芽区块。

### 主网络

* <ItemLink id="storage_bus" />主网络(以及《公约》[充电自动](charger-automation.md))A. 访问所有无障碍环境、赛特斯石英水晶体在桶内。
  高[优先](../ae2-mechanics/import-export-storage.md#storage-priority)因此,赛特斯石英水晶是优美的,
  放在桶里,而不是在主仓库里
* <ItemLink id="interface" />给予 rootr 子网访问权限<ItemLink id="flawed_budding_quartz" />,和
    给给赛特斯截断器子网 一种将枯竭的区块 带回主网络的方法。
    <ItemLink id="crafting_card" />允许接口请求主网络的新起始区块[自动自制](../ae2-mechanics/autocrafting.md).