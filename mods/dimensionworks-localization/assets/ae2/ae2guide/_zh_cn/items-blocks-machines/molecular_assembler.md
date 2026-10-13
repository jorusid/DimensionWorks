---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 分子装配室
  icon: molecular_assembler
  position: 310
categories:
- machines
item_ids:
- ae2:molecular_assembler
---

# 分子装配室

<BlockImage id="molecular_assembler" scale="8" />

分子装配室将物品输入它,并进行相邻物品定义的操作<ItemLink id="pattern_provider" />,
插入<ItemLink id="crafting_pattern" />,<ItemLink id="smithing_table_pattern" />,或<ItemLink id="stonecutting_pattern" />,
然后将结果推到相邻的清点中。

该组装器有一个设计图案, 指定 1 橡木日志= 4 棵橡树木板食谱。当橡树木被装入上层时,
装配工匠把橡木板吐到下头

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/standalone_assembler.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 和主要用途分子装配室

然而,它们的主要用途与<ItemLink id="pattern_provider" />模式样板供应器在这种情况下有特殊行为
并会将有关模式的信息和原料连同原料发送给相邻的装配组装组。
手合成类相邻库存清单(从而进入了缔约方的返回位置样板供应器),一个装配器样板供应器
是自动生成图案所需的全部。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/assembler_tower.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 升级

分子装配室支持以下支持[升级](upgrade_cards.md):

*   <ItemLink id="speed_card" />

## 用途

<RecipeFor id="molecular_assembler" />

## 注注注 注 注附注注说明注注释注,注附注 注说明,附注的附注说明 注,说明附注注释 注的注

Optifine 打破了“ 推向邻近库存库” 功能, 所以大多数装配组装的装置都不会工作。