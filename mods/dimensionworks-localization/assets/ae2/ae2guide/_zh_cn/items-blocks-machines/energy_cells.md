---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 能源电池
  icon: energy_cell
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:energy_cell
- ae2:dense_energy_cell
- ae2:creative_energy_cell
---

# 能源电池

<Row gap="20">
  <BlockImage id="energy_cell" scale="8" p:fullness="4" />

  <BlockImage id="dense_energy_cell" scale="8" p:fullness="4" />

  <BlockImage id="creative_energy_cell" scale="8" />
</Row>

能量电池能给网络带来更多[能源](../ae2-mechanics/energy.md)存储一定数量的能源缓冲剂有助于平滑
当大量物品被插入或抽取,以及大量能源贮存时,能源抽出
允许网络运行, 而能源没有产生(晚上和太阳能电池板一样)或操作巨大的瞬时
电能抽取[空间存储](../ae2-mechanics/spatial-io.md).

## 填充栏

<Row>
<BlockImage id="energy_cell" scale="4" p:fullness="0" />
<BlockImage id="energy_cell" scale="4" p:fullness="1" />
<BlockImage id="energy_cell" scale="4" p:fullness="2" />
<BlockImage id="energy_cell" scale="4" p:fullness="3" />
<BlockImage id="energy_cell" scale="4" p:fullness="4" />
</Row>

细胞侧边的栅栏与它能耐的能量相符。

*   0 低于 25%时收费
*   1 收取 25%至 50%
*   2 收费在 50%至 75%之间
*   3 年,75%至 99%收费
*   4 高于 99%的收费

## 单元格类型

*   <ItemLink id="energy_cell" />可以存储 200 公里的可控电源,而且对于处理电流的多数使用案例来说,只要一个就足够了。
    * 容易地正常使用网络。
*   <ItemLink id="dense_energy_cell" />可存储 1.6M 电源, 用于您想要用存储的电量运行网络时, 或者
    处理大型瞬时能量抽取[空间存储](../ae2-mechanics/spatial-io.md)设置。
*   <ItemLink id="creative_energy_cell" />是一个用于测试的创意物品,提供 UNLIMITED POWAHH HH 或其它东西。

## 食食权

<Row>
  <RecipeFor id="energy_cell" />

  <RecipeFor id="dense_energy_cell" />
</Row>
