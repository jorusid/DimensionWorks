---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 成型面板
  icon: formation_plane
  position: 210
categories:
- devices
item_ids:
- ae2:formation_plane
---

# 成型面板

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/blocks/formation_plane.snbt" />
</GameScene>

成型面板设置空格和滴放物品。它的工作方式类似于只插入的<ItemLink id="storage_bus" />,
当东西被“存储”时放置/ 投放[设备](../ae2-mechanics/devices.md)插入[网络存储](../ae2-mechanics/import-export-storage.md),
类似<ItemLink id="import_bus" />和<ItemLink id="interface" />.

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/formation_plane_demonstration.snbt" />
  <IsometricCamera yaw="255" pitch="30" />
</GameScene>

这个[设备](../ae2-mechanics/devices.md)使用存储总客车在诸如[管道子网](../example-setups/pipe-subnet.md),
如果您想要丢弃物品/位置块而不是运输物品, 还可以在这些设置中替换存储总线。

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

**E. 记得在您的索赔中**

## 过滤

默认情况下, 平面将放置/ 放下任何东西。插入到过滤器槽中的物品将作为空白列表, 只有
允许放置这些具体物品。

物品和液体可以拖进从 JEI 即使你没有那东西

用液体容器右键单击(象桶或液罐一样)将液体设置为过滤器,而不是桶或罐体物品。

## 优先

可以通过单击扳手在 GUI.
输入网络的物品将从最优先存储开始。

## 设置

*   平面可以设置为在世界上放置块块或投放物品

## 升级

成型面板支持以下支持[升级](upgrade_cards.md):

*   <ItemLink id="capacity_card" />增加过滤空格的数量
*   <ItemLink id="fuzzy_card" />让平面通过损坏等级和/或忽略物品过滤 NBT
*   <ItemLink id="inverter_card" />将过滤器从白色列表切换为黑名单

## 用途

<RecipeFor id="formation_plane" />
