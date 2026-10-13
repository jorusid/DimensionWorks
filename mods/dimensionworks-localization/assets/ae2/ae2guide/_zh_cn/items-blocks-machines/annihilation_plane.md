---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 破坏面板
  icon: annihilation_plane
  position: 210
categories:
- devices
item_ids:
- ae2:annihilation_plane
---

# 破坏面板

<GameScene zoom="8" background="transparent">
<ImportStructure src="../assets/blocks/annihilation_plane.snbt" />
</GameScene>

破坏面板中断区块和取取物品。<ItemLink id="import_bus" />推东西
与[网络存储](../ae2-mechanics/import-export-storage.md)。要取取物品,它们必须和
飞机的表面,它不 在一个区域取出。

粉碎的飞机可以被任何 砍轴魔法所迷惑, 所以,是的,你可以把 疯狂的财富水平 在少数和
[自动解动矿石处理](../example-setups/ore-fortuner.md)如果你的软件包允许的话精准采集做什么 做什么
效率会降低突破一个街区的能源成本 破碎后就有机会不使用任何能源

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

**E. 记得在您的索赔中**

## 过滤

破坏面板只有在能够存储产生的滴滴/项时,才会打破块块或取取物品。
在其网络中。这意味着过滤一个,*您必须限制其网络上存储的内容*,最有可能
以一个[子网络](../ae2-mechanics/subnetworks.md). A<ItemLink id="storage_bus" />或[单元格](../items-blocks-machines/storage_cells.md)
可以是[元件工作台](cell_workbench.md)实现这一点。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/annihilation_filtering.snbt" />

  <DiamondAnnotation pos="1 0.5 0.5" color="#00ff00">
        过滤到任何您想要打破的东西的滴子。
  </DiamondAnnotation>

  <DiamondAnnotation pos=".5 0.5 2.5" color="#00ff00">
        切换到任何你想要破碎的东西的滴水
  </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

它再次过滤*依物品滴滴*例如,如果您想要过滤<ItemLink id="minecraft:amethyst_cluster" />,
需要一架飞机施魔法精准采集,否则之前的每个成长阶段 都不会有任何下降 所以飞机会打破它们
网络总能存储"什么都没有"

## 用途

<RecipeFor id="annihilation_plane" />
