---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 存储电池
  icon: item_storage_cell_1k
  position: 410
categories:
- tools
item_ids:
- ae2:item_cell_housing
- ae2:fluid_cell_housing
- ae2:cell_component_1k
- ae2:cell_component_4k
- ae2:cell_component_16k
- ae2:cell_component_64k
- ae2:cell_component_256k
- ae2:item_storage_cell_1k
- ae2:item_storage_cell_4k
- ae2:item_storage_cell_16k
- ae2:item_storage_cell_64k
- ae2:item_storage_cell_256k
- ae2:fluid_storage_cell_1k
- ae2:fluid_storage_cell_4k
- ae2:fluid_storage_cell_16k
- ae2:fluid_storage_cell_64k
- ae2:fluid_storage_cell_256k
---

# 存储电池

<Column>
  <Row>
    <ItemImage id="item_storage_cell_1k" scale="4" />

    <ItemImage id="item_storage_cell_4k" scale="4" />

    <ItemImage id="item_storage_cell_16k" scale="4" />

    <ItemImage id="item_storage_cell_64k" scale="4" />

    <ItemImage id="item_storage_cell_256k" scale="4" />
  </Row>

  <Row>
    <ItemImage id="fluid_storage_cell_1k" scale="4" />

    <ItemImage id="fluid_storage_cell_4k" scale="4" />

    <ItemImage id="fluid_storage_cell_16k" scale="4" />

    <ItemImage id="fluid_storage_cell_64k" scale="4" />

    <ItemImage id="fluid_storage_cell_256k" scale="4" />
  </Row>
</Column>

存储槽是存储在 Applied Energistics。他们进入<ItemLink id="drive" />
或<ItemLink id="chest" />.

见见[字节和类型](../ae2-mechanics/bytes-and-types.md)说明其能力的字节和类型。

如果单元格空,可按左转右键单击,用手边的单元格来移动存储组件,则可以从房屋中移除存储部件。

## 具有不同类型计数的存储容量

[类型预付费用](../ae2-mechanics/bytes-and-types.md)1 型号的牢房可以持有 2x 和所有 63 型使用的 2X。

| 单元格                                     | 使用 1 类使用的细胞总容量 | 63 种使用类型细胞的总容量 |
| ---------------------------------------- | ----------------------------------------: | ------------------------------------------: |
| <ItemLink id="item_storage_cell_1k" />   |                                     8,128 |                                       4,160 |
| <ItemLink id="item_storage_cell_4k" />   |                                    32,512 |                                      16,640 |
| <ItemLink id="item_storage_cell_16k" />  |                                   130,048 |                                      66,560 |
| <ItemLink id="item_storage_cell_64k" />  |                                   520,192 |                                     266,240 |
| <ItemLink id="item_storage_cell_256k" /> |                                 2,080,768 |                                   1,064,960 |


## 分割

单元格只能过滤到只接受某些物品,类似<ItemLink id="storage_bus" />Ses 可以过滤。这是
在一个<ItemLink id="cell_workbench" />.

可从 JEI 即使你没有那东西

## 升级

存储单元格支持以下[升级](upgrade_cards.md),插入到<ItemLink id="cell_workbench" />:

*   <ItemLink id="fuzzy_card" />(流体单元格不可用)让单元格被损坏水平和/或忽略项分隔 NBT
*   <ItemLink id="inverter_card" />将过滤器从白色列表切换为黑名单
*   <ItemLink id="equal_distribution_card" />将相同数量的单元格字节面积分配到每类的单元格位数,因此,一种类型无法填充整个单元格
*   <ItemLink id="void_card" />如果单元格是满空的,则插入物品(或特定类型在
    平等分发卡的情况)防止农场倒水,小心分割!
*   可接受便携细胞<ItemLink id="energy_card" />以便增加电池的电池容量

## 颜色

便携式物品和液体电池可以与皮革盔甲相似的颜色,与染料一起制成。

# 住房

电池可以配有存储部件和住房,也可以配以存储组件的住房配方:

<Row>
  <Recipe id="network/cells/item_storage_cell_1k" />

  <Recipe id="network/cells/item_storage_cell_1k_storage" />
</Row>

住房本身的建造方式如下:

<Row>
  <RecipeFor id="item_cell_housing" />

  <RecipeFor id="fluid_cell_housing" />
</Row>

# 存储部件

存储组件是所有部件的核心 AE2 每一层次都提高能力
4x 和费用 3 上一级。

<Column>
  <Row>
    <RecipeFor id="cell_component_1k" />

    <RecipeFor id="cell_component_4k" />

    <RecipeFor id="cell_component_16k" />
  </Row>

  <Row>
    <RecipeFor id="cell_component_64k" />

    <RecipeFor id="cell_component_256k" />
  </Row>
</Column>

# 物品存储单元格

物品存储槽可容纳 63 种不同种类的物品,并且可以按所有标准容量提供。

<Column>
  <Row>
    <Recipe id="network/cells/item_storage_cell_1k_storage" />

    <Recipe id="network/cells/item_storage_cell_4k_storage" />

    <Recipe id="network/cells/item_storage_cell_16k_storage" />
  </Row>

  <Row>
    <Recipe id="network/cells/item_storage_cell_64k_storage" />

    <Recipe id="network/cells/item_storage_cell_256k_storage" />
  </Row>
</Column>

## 便携式物品存储

这些就像个小小的<ItemLink id="chest" />或像背包一样。<ItemLink id="charger" />

与标准存储电池不同,这些实际上*减少*其字字节能力增加时,其型号能力在每字段容量增加,占
字节总容量。

除了升级卡卡外,所有细胞可以接收的卡片也都接受<ItemLink id="energy_card" />升级内部电池。

<Column>
  <Row>
    <RecipeFor id="portable_item_cell_1k" />

    <RecipeFor id="portable_item_cell_4k" />

    <RecipeFor id="portable_item_cell_16k" />
  </Row>

  <Row>
    <RecipeFor id="portable_item_cell_64k" />

    <RecipeFor id="portable_item_cell_256k" />
  </Row>
</Column>

# 流流储槽

流体存储槽可容纳 5 种不同类型的液体,并且能以所有标准容量提供。

<Column>
  <Row>
    <Recipe id="network/cells/fluid_storage_cell_1k_storage" />

    <Recipe id="network/cells/fluid_storage_cell_4k_storage" />

    <Recipe id="network/cells/fluid_storage_cell_16k_storage" />
  </Row>

  <Row>
    <Recipe id="network/cells/fluid_storage_cell_64k_storage" />

    <Recipe id="network/cells/fluid_storage_cell_256k_storage" />
  </Row>
</Column>

## 便携式液体存储

这些就像个小小的<ItemLink id="chest" />或像背包一样。<ItemLink id="charger" />

与标准存储电池不同,这些实际上*减少*其字字节能力增加时,其型号能力在每字段容量增加,占
字节总容量。

除了升级卡卡外,所有细胞可以接收的卡片也都接受<ItemLink id="energy_card" />升级内部电池。

<Column>
  <Row>
    <RecipeFor id="portable_fluid_cell_1k" />

    <RecipeFor id="portable_fluid_cell_4k" />

    <RecipeFor id="portable_fluid_cell_16k" />
  </Row>

  <Row>
    <RecipeFor id="portable_fluid_cell_64k" />

    <RecipeFor id="portable_fluid_cell_256k" />
  </Row>
</Column>

# 创意物品和流体单元格

<Row>
  <ItemImage id="creative_item_cell" scale="2" />

  <ItemImage id="creative_fluid_cell" scale="2" />
</Row>

创意物品和流动电池**不提供无限存储**相反,它们作为任何来源和汇的无限源和吸收汇的作用
或流水的项,[分区](cell_workbench.md)他们。
