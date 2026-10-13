---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 充电器
  icon: charger
  position: 310
categories:
- machines
item_ids:
- ae2:charger
---

# 电源

<BlockImage id="charger" scale="8" />

电电筒提供充电的方法
支持的辅助工具,以及<ItemLink id="certus_quartz_crystal" />.

电力可以通过上上或下提供,也可以通过 AE2's[电缆](cables.md)或其它变式电源电缆。它可以
接受 AE2 电源(英英阿英)或 Forge 能源(FE)。物品可以插入或从任何侧面删除。只有结果可以
被删除, 因此不需要过滤器来阻止删除赛特斯代替充电的晶体赛特斯。可以与 a 旋转
<ItemLink id="certus_quartz_wrench" />以便利自动化。

可用于创建<ItemLink id="charged_certus_quartz_crystal" />
调自<ItemLink id="certus_quartz_crystal" />,和<ItemLink id="meteorite_compass" />调自<ItemLink id="minecraft:compass" />.

手动给它动力,放<ItemLink id="crank" />在顶部或底部单击右键单击,直到物品被充电。

它还作为《公约》的 AE2 村长

## 简单自动化

举例来说,旋转性让半自动充电器像这样:

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/charger_hopper.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 用途

<RecipeFor id="charger" />
