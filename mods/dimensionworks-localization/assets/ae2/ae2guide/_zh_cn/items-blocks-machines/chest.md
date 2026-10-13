---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: ME 箱子
  icon: chest
  position: 210
categories:
- devices
item_ids:
- ae2:chest
---

# ME 箱子

<GameScene zoom="8" background="transparent">
<ImportStructure src="../assets/blocks/chest.snbt" />
</GameScene>

ME 箱子就像一个微型网络 与<ItemLink id="terminal" />,<ItemLink id="drive" />,和<ItemLink id="energy_acceptor" />.
虽然它可以用作一个小的存储网络,但它仅能维持一个单一的[存储元件](../items-blocks-machines/storage_cells.md)
是指它本身的效用有限。

相反,它有助于与具体存储元件其集成终端只能查看和访问
挂载驱动器中的物品,而[设备](../ae2-mechanics/devices.md)在一般网络上,一般网可访问任何[网络存储](../ae2-mechanics/import-export-storage.md),
包括 ME 箱子。

它有两个不同的图形界面,并且为物品传输而侧面。与顶端终端交互,打开集成终端。物品可以插入到
挂载存储元件与任何其他面孔的交互作用打开 GUI 与空档存储元件
和优先设置。单元格只能通过带单元格槽的面部,通过物品后勤程序插入并删除。

轮轮用<ItemLink id="certus_quartz_wrench" />.

它有一个小型的 AE 能源存储缓冲器,如果它没有在与[能量元件](../items-blocks-machines/energy_cells.md),
立即插入或提取过多的物品可能导致其脱色。

终端可使用<ItemLink id="color_applicator" />.

<GameScene zoom="6" background="transparent">
<ImportStructure src="../assets/assemblies/chest_color.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 设置

ME 箱子具有全部相同的设置<ItemLink id="terminal" />或<ItemLink id="crafting_terminal" />.
然而,它不支持<ItemLink id="view_cell" />.

## 存储元件 LED

箱子的细胞上有一个 LED,显示他们的状态:

| 颜色  | 状态状况现状状况                                                                           |
| :----- | :------------------------------------------------------------------------------- |
| 绿色  | 空空                                                                            |
| 蓝蓝色   | 有一些内容                                                                |
| 橙橙 | [类型](../ae2-mechanics/bytes-and-types.md)全部, 无法添加新类型     |
| 红红    | [字节](../ae2-mechanics/bytes-and-types.md)全部, 不再可以插入物品 |
| 黑黑色  | 没有动力或驱动器没有[频道](../ae2-mechanics/channels.md)                 |

## 优先

在单元格槽的右上角单击扳手就可以设定优先级 GUI.
输入网络的物品将在最优先存储时开始
在两个储藏室或牢房中,其优先程度相同,
如果其中有一个已经包含此物品,他们宁可存放该物品而不愿存储任何物品。
任何其他[元件工作台](cell_workbench.md)单元格将被视为已经包含物品
当与其他存储器处于相同的优先级组时。从存储中移除的物品将
优先级别最低的存储器,从存储中移除。优先系统是指插入和删除物品。
从网络存储中取出,将填充更优先的存储,并清空更次要的贮存。

## 用途

<RecipeFor id="chest" />
