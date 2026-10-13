---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 升级卡片
  icon: speed_card
  position: 410
categories:
- tools
item_ids:
- ae2:basic_card
- ae2:advanced_card
- ae2:redstone_card
- ae2:capacity_card
- ae2:void_card
- ae2:fuzzy_card
- ae2:speed_card
- ae2:inverter_card
- ae2:crafting_card
- ae2:equal_distribution_card
- ae2:energy_card
---

# 升级卡片

<Row>
  <ItemImage id="redstone_card" scale="2" />

  <ItemImage id="capacity_card" scale="2" />

  <ItemImage id="void_card" scale="2" />

  <ItemImage id="fuzzy_card" scale="2" />

  <ItemImage id="speed_card" scale="2" />

  <ItemImage id="inverter_card" scale="2" />

  <ItemImage id="crafting_card" scale="2" />

  <ItemImage id="equal_distribution_card" scale="2" />

  <ItemImage id="energy_card" scale="2" />
</Row>

升级卡片改变行为 AE2[设备](../ae2-mechanics/devices.md)和机器, 加快速度,改善他们的
过滤能力,使红石控制功能等

## 贺卡部件

<Row>
  <ItemImage id="basic_card" scale="2" />

  <ItemImage id="advanced_card" scale="2" />
</Row>

卡片配有基本或高级卡卡或先进卡基

<Row>
  <RecipeFor id="basic_card" />

  <RecipeFor id="advanced_card" />
</Row>

## 复结牌

<ItemImage id="redstone_card" scale="2" />

红石卡卡,添加红岩控制,在设备中添加切换按钮 GUI 在各种红石条件之间互换。

<RecipeFor id="redstone_card" />

## 身份证卡

<ItemImage id="capacity_card" scale="2" />

能力卡可增加进口、出口和存储总线和编队飞机的过滤槽。

<RecipeFor id="capacity_card" />

## 过量销毁卡

<ItemImage id="void_card" scale="2" />

销毁卡可适用于[存储单元格](storage_cells.md)a 中<ItemLink id="cell_workbench" />
如果单元格满载,则将删除输入的物品。(保证[分区](cell_workbench.md)你的细胞!)与平等分发卡相结合,
如果单元格中该特定项的一节是满的,则该项将无效,即使其他项的部分是空的。

<RecipeFor id="void_card" />

## 模糊卡卡

<ItemImage id="fuzzy_card" scale="2" />

模糊卡卡使带有过滤器的设备和工具按损坏级别和/或忽略物品过滤 NBT,允许导出
所有的铁斧,无论破坏程度和魔法如何,或只是出口受损的钻石剑,而不是完全修复的金刚石剑。

下面的例子说明了 Fazzy Damage 如何比较模式,左侧是如何工作的。
bus 配置,顶部是比较物品。

| 25%                    | 10%损坏皮卡塞 | 30%损坏 皮卡克斯 | 80% 损坏 皮卡塞 | 全面修理皮卡塞 |
| ---------------------- | ------------------- | ------------------- | ------------------- | ------------------- |
| 几乎破碎的皮卡克斯  | ✅                   | \*\*\*\*            | \*\*\*\*            | \*\*\*\*            |
| 完全修理的皮卡塞 | \*\*\*\*            | ✅                   | ✅                   | ✅                   |

| 50%                    | 10%损坏皮卡塞 | 30%损坏 皮卡克斯 | 80% 损坏 皮卡塞 | 全面修理皮卡塞 |
| ---------------------- | ------------------- | ------------------- | ------------------- | ------------------- |
| 几乎破碎的皮卡克斯  | ✅                   | ✅                   | \*\*\*\*            | \*\*\*\*            |
| 完全修理的皮卡塞 | \*\*\*\*            | \*\*\*\*            | ✅                   | ✅                   |

| 75%                    | 10%损坏皮卡塞 | 30%损坏 皮卡克斯 | 80% 损坏 皮卡塞 | 全面修理皮卡塞 |
| ---------------------- | ------------------- | ------------------- | ------------------- | ------------------- |
| 几乎破碎的皮卡克斯  | ✅                   | ✅                   | \*\*\*\*            | \*\*\*\*            |
| 完全修理的皮卡塞 | \*\*\*\*            |                                          | ✅                   | ✅                   |

| 99%                    | 10%损坏皮卡塞 | 30%损坏 皮卡克斯 | 80% 损坏 皮卡塞 | 全面修理皮卡塞 |
| ---------------------- | ------------------- | ------------------- | ------------------- | ------------------- |
| 几乎破碎的皮卡克斯  | ✅                   | ✅                   | ✅                   | \*\*\*\*            |
| 完全修理的皮卡塞 | \*\*\*\*            | \*\*\*\*            | \*\*\*\*            | ✅                   |

| 忽略                 | 10%损坏皮卡塞 | 30%损坏 皮卡克斯 | 80% 损坏 皮卡塞 | 全面修理皮卡塞 |
| ---------------------- | ------------------- | ------------------- | ------------------- | ------------------- |
| 几乎破碎的皮卡克斯  | ✅                   | ✅                   | ✅                   | **✅**               |
| 完全修理的皮卡塞 | **✅**               | **✅**               | **✅**               | ✅                   |

<RecipeFor id="fuzzy_card" />

## 加速卡卡

<ItemImage id="speed_card" scale="2" />

加速卡卡能让东西跑得更快, 使进出口总车每次操作能移动更多的物品,
装配工的工作速度更快。

<RecipeFor id="speed_card" />

## 反换卡

<ItemImage id="inverter_card" scale="2" />

从白色列表到黑名单的设备和工具中的反向卡互换过滤器。

<RecipeFor id="inverter_card" />

## 手合成卡

<ItemImage id="crafting_card" scale="2" />

手合成卡让设备发送手艺请求[自动自制](../ae2-mechanics/autocrafting.md)
系统来获得它想要的东西。

<RecipeFor id="crafting_card" />

## 平等分配卡

<ItemImage id="equal_distribution_card" scale="2" />

平等分发卡可以适用于[存储单元格](storage_cells.md)a 中<ItemLink id="cell_workbench" />和
根据卡片大小将单元格拆分成等大小的区块[元件工作台](cell_workbench.md)to. 这样可以防止一种物项类型完全
填充电池。

<RecipeFor id="equal_distribution_card" />

## 能源卡

<ItemImage id="energy_card" scale="2" />

在便携式终端等某些工具上,能源卡卡可增加能源存储量,并合成<ItemLink id="vibration_chamber" />
更有效率。

<RecipeFor id="energy_card" />
