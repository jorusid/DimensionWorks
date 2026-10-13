---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: ME 输出总线
  icon: export_bus
  position: 220
categories:
- devices
item_ids:
- ae2:export_bus
---

# 输出总线

<GameScene zoom="8" background="transparent">
<ImportStructure src="../assets/blocks/export_bus.snbt" />
</GameScene>

输出总线拉拉物品和液体(或别的,或给加文,)调自[网络存储](../ae2-mechanics/import-export-storage.md)
把他们推入它感动的目录

为了减少时差,如果输出总线最近没有导出什么, 它进入了一种
"睡眠模式" 缓慢运行, 醒来并加速到全速(每秒 4 次行动)当它成功地出口了东西

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

## 过滤

默认情况下,总线不会导出任何文件。插入到其过滤槽的物品将起到“白列表”的作用,
允许出口这些特定物品。

物品和液体可以拖进从 JEI 即使你没有那东西

用液体容器右键单击(象桶或液罐一样)将液体设置为过滤器,而不是桶或罐体物品。

## 升级

输入总线支持以下支持[升级](upgrade_cards.md):

*   <ItemLink id="capacity_card" />增加过滤槽的数量, 并设定要导出过滤器的顺序。
*   <ItemLink id="speed_card" />增加每次操作移动的物品数量
*   <ItemLink id="fuzzy_card" />使总线通过损坏等级和/或忽略物品过滤 NBT
*   <ItemLink id="crafting_card" />让公交车向您发送伪造请求[自动自制](../ae2-mechanics/autocrafting.md)
    系统以获取它想要的物品。可以设置在可能情况下将物品从存储中拉出, 或者总是提出请求
    用于设计新物品。
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
