---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 级别发射
  icon: level_emitter
  position: 220
categories:
- devices
item_ids:
- ae2:level_emitter
- ae2:energy_level_emitter
---

# 级别 Einspir 状态

<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/blocks/level_emitter.snbt" />
</GameScene>

级 Einirit 发送一个红石信号, 视某物项的数量而定
[网络存储](../ae2-mechanics/import-export-storage.md).

还有一个版本,根据[能源](../ae2-mechanics/energy.md)存储的
在你的网络。

物品和液体可以拖进槽中,从 JEI 即使你没有那东西

用液体容器右键单击(象桶或液罐一样)将液体设置为过滤器,而不是桶或罐体物品。

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

与其他不同[设备](../ae2-mechanics/devices.md)、级别排放源*不 不*需要 a[频道](../ae2-mechanics/channels.md).

## 设置

*   关卡 Enister 可以设置为“ 大于/ 等于” 模式或“ 小于”
*   当 a<ItemLink id="crafting_card" />插入时,它可以设置为“在物品正在编织时微红石”或
    "半红石到船体"

## 升级

级别排放源支持以下[升级](upgrade_cards.md):

*   <ItemLink id="fuzzy_card" />使发射者通过损坏级别和/或忽略物品过滤 NBT
*   <ItemLink id="crafting_card" />启用绘图功能

## 手合成功能

如果 a<ItemLink id="crafting_card" />插入时,排放程序将被切换为绘图模式。

这样可以有两个选项 :

第一个选项,“当物品在编织时,微红岩” 使发射者发出红石信号,而你的[自动自制](../ae2-mechanics/autocrafting.md)
正在通过<ItemLink id="pattern_provider" />。这对仅打开特定的
在实际使用时安装了电源饥饿自动化装置。

第二种选择,“微红石来合成物品”,对于诸如无限农场等特定用途案例极为有用。
自动设置, 只能产生输出, 而不能产生古兰酸输出。
此设置创建虚拟[样式](patterns.md)用于[自动自制](../ae2-mechanics/autocrafting.md)用于任何物品
位于排放者过滤槽中。
(对于正确功能,同一物品的实际模式**不应存在**在您<ItemLink id="pattern_provider" />)

这个"模式"没有定义,甚至没有关心原料。
上面写着"如果你从这层排放物中 释放出红石 ME 系统将在
通常用于激活和拆除不需要投入原料的无限农场,
或激活一个处理循环食谱的系统(标准自动隐藏无法理解)例如,“1 个可碎石 = 2 块可裂石”
如果你有一台机器 复制了可塑石

## 用途

<RecipeFor id="level_emitter" />

<RecipeFor id="energy_level_emitter" />
