---
navigation:
  parent: example-setups/example-setups-index.md
  title: 自动 Ore Fortuner 自动化 ORE 工具
  icon: minecraft:raw_iron
---

# Ore 调制自动化

<ItemLink id="annihilation_plane" />能够施魔法 任何摘食的魔法, 包括财富, 所以一个明显的用途是
将财富应用到少数,并且已经<ItemLink id="formation_plane" />和<ItemLink id="annihilation_plane" />快速地点和
打破矿石。

请注意,自<ItemLink id="import_bus" />Ses "Spin up to speed," 设置将缓慢启动 然后在几秒钟内达到全速。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/ore_fortuner.snbt" />

  <BoxAnnotation color="#dddddd" min="2.7 0 2" max="3 1 3">
        (1)输入总线里面有几张加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="0 0 2" max="2 1 2.3">
        (2)构造图案: 在默认配置中。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="0 0 0.7" max="2 1 1">
        (3)平整计划:无 GUI 来配置,但被财富所迷惑。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.7 0 0" max="3 1 1">
        (4)存储总线:在其默认配置中。
  </BoxAnnotation>

<DiamondAnnotation pos="3.5 0.5 2.5" color="#00ff00">
        投入输入投入
    </DiamondAnnotation>

<DiamondAnnotation pos="3.5 0.5 0.5" color="#00ff00">
        产出 输出产出
    </DiamondAnnotation>

<DiamondAnnotation pos="4 0.5 1.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

*   <ItemLink id="import_bus" />(1)有少数<ItemLink id="speed_card" />越多编队飞机,就越需要更多。
    在数组中,当他们使输入总线立即拉动更多物品。
*   <ItemLink id="formation_plane" />(2)是在默认配置中。
*   <ItemLink id="annihilation_plane" />(3)没有无 GUI 无法被配置, 却被施魔法 与财富。
*   <ItemLink id="storage_bus" />(4)默认配置。

## 如何运作

1.  <ItemLink id="import_bus" />绿色子网从第一桶到[网络存储](../ae2-mechanics/import-export-storage.md)
2.  绿色子网上唯一的存储库是<ItemLink id="formation_plane" />,这设置了街区。
3.  <ItemLink id="annihilation_plane" />在橙色亚网上打破了区块, 给它们带来财富。
4.  <ItemLink id="storage_bus" />在橙色亚网上存储 第二桶破碎的结果
