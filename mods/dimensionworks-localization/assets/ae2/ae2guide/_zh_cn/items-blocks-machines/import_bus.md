---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: ME 输入总线
  icon: import_bus
  position: 220
categories:
- devices
item_ids:
- ae2:import_bus
---

# 输入总线

<GameScene zoom="8" background="transparent">
<ImportStructure src="../assets/blocks/import_bus.snbt" />
</GameScene>

输入总线拉拉物品和液体(或别的,或给加文,)从清册中,它触动并把它们推入
[网络存储](../ae2-mechanics/import-export-storage.md).

为了减少时差,如果输入总线最近没有导入最近的东西, 它进入了一种
"睡眠模式" 缓慢运行, 醒来并加速到全速(每秒 4 次行动)当它成功地进口了东西

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

## 过滤

默认情况下, 公车会导入任何它可以访问的东西。插入到过滤器槽中的物品将作为空白列表, 只作为白色列表
允许进口这些特定物品。

物品和液体可以拖进从 JEI 即使你没有那东西

用液体容器右键单击(象桶或液罐一样)将液体设置为过滤器,而不是桶或罐体物品。

## 升级

输入总线支持以下支持[升级](upgrade_cards.md):

*   <ItemLink id="capacity_card" />增加过滤空格的数量
*   <ItemLink id="speed_card" />增加每次操作移动的物品数量
*   <ItemLink id="fuzzy_card" />使总线通过损坏等级和/或忽略物品过滤 NBT
*   <ItemLink id="inverter_card" />将过滤器从白色列表切换为黑名单
*   <ItemLink id="redstone_card" />添加红岩控制,允许在高信号、低信号或每脉冲一次时使用

## 速度

| 加速卡卡 | 每个操作都移动的物品 |
|:-------------------|:--------------------------|
| 0                  | 1                         |
| 1                  | 8                         |
| 2                  | 32                        |
| 3                  | 64                        |
| 4                  | 96                        |

## 用途

<RecipeFor id="import_bus" />
