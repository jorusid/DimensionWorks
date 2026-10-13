---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: ME 驱动器
  icon: drive
  position: 210
categories:
- devices
item_ids:
- ae2:drive
---

# ME 驱动器

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/blocks/drive.snbt" />
</GameScene>

车道是[设备](../ae2-mechanics/devices.md)您插入了您的[存储单元格](storage_cells.md)用于
[网络存储](../ae2-mechanics/import-export-storage.md)。它有 10 个空位,每个空档都接受一个单元格。

如果出于某种原因你愿意,你可以将电池从其库存中推出,并用任何物品物流,如直升机或 AE2 总客车。

轮轮用<ItemLink id="certus_quartz_wrench" />.

## 存储元件 LED

驱动器内的细胞有 LED,显示其状态:

| 颜色  | 状态状况现状状况                                                                           |
| :----- | :------------------------------------------------------------------------------- |
| 绿色  | 空空                                                                            |
| 蓝蓝色   | 有一些内容                                                                |
| 橙橙 | [类型](../ae2-mechanics/bytes-and-types.md)全部, 无法添加新类型     |
| 红红    | [字节](../ae2-mechanics/bytes-and-types.md)全部, 不再可以插入物品 |
| 黑黑色  | 没有动力或驱动器没有[频道](../ae2-mechanics/channels.md)                 |

## 优先

可以通过单击扳手在 GUI.
输入网络的物品将在最优先存储时开始
在两个储藏室或牢房中,其优先程度相同,
如果其中有一个已经包含此物品,他们宁可存放该物品而不愿存储任何物品。
任何其他[元件工作台](cell_workbench.md)单元格将被视为已经包含物品
当与其他存储器处于相同的优先级组时。从存储中移除的物品将
优先级别最低的存储器,从存储中移除。优先系统是指插入和删除物品。
从网络存储中取出,将填充更优先的存储,并清空更次要的贮存。

## 用途

<RecipeFor id="drive" />
