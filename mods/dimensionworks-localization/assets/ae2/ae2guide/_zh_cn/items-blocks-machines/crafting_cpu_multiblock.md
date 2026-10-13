---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 手工合成 CPU 多个区块(存储、协同处理、监测、单元)
  icon: 1k_crafting_storage
  position: 210
categories:
- devices
item_ids:
- ae2:1k_crafting_storage
- ae2:4k_crafting_storage
- ae2:16k_crafting_storage
- ae2:64k_crafting_storage
- ae2:256k_crafting_storage
- ae2:crafting_accelerator
- ae2:crafting_monitor
- ae2:crafting_unit
---

# 术术 CPU

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/crafting_cpus.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

<Row>
  <BlockImage id="1k_crafting_storage" scale="4" />

  <BlockImage id="crafting_accelerator" scale="4" />

  <BlockImage id="crafting_monitor" scale="4" />

  <BlockImage id="crafting_unit" scale="4" />
</Row>

手合成的 CPU 管理手写要求/工作,它们存储中间原料,同时用多步制来合成工作。
这些工作正在进行中,影响到大工作的规模和完成的速度。[自动自制](../ae2-mechanics/autocrafting.md)
以获取更多细节。

每个合成 CPU 处理 1 个请求或工作, 所以如果您想要同时请求计算处理器和 256 块平滑石, 您需要 2。CPU 多个区块。

他们可以处理球员的要求,自动化(导出总车和接口)或者两者兼而有之

右键单击一键可生成一个手动状态界面, 以便您检查手写工作的进展。CPU 正在处理中。

## 设置

*   CPU 可以设定可以接受来自球员的要求, 仅仅是自动化(类似<ItemLink id="export_bus" />以
    <ItemLink id="crafting_card" />)或者两者兼而有之

## 建筑

手合成式 CPU 是多块块,必须是坚实的长方形棱柱,没有缝隙。它们由若干组成部分组成。

每个 CPU 必须至少包含 1 合成存储块块(和最低限度的可行和最低 CPU 事实上,只有一公里合成存储).

# 手工合成股

<BlockImage id="crafting_unit" scale="4" />

(任择)手合成单位只需填充一个 CPU 使它成为坚固的矩形棱柱 如果你没有足够的
它们也是其他组成部分的基本原料。

<RecipeFor id="crafting_unit" />

# 合成存储

<Row>
  <BlockImage id="1k_crafting_storage" scale="4" />

  <BlockImage id="4k_crafting_storage" scale="4" />

  <BlockImage id="16k_crafting_storage" scale="4" />

  <BlockImage id="64k_crafting_storage" scale="4" />

  <BlockImage id="256k_crafting_storage" scale="4" />
</Row>

(所需)所有标准细胞大小都有手工存储库(1k, 4k, 16k, 64k, 256k)它们存储原料和
合成品中含有的中间原料,因此需要较大的或更多的存储库,以达到以下条件:CPU 处理手合成工作
含有更多原料。

<Column>
  <Row>
    <RecipeFor id="1k_crafting_storage" />

    <RecipeFor id="4k_crafting_storage" />

    <RecipeFor id="16k_crafting_storage" />
  </Row>

  <Row>
    <RecipeFor id="64k_crafting_storage" />

    <RecipeFor id="256k_crafting_storage" />
  </Row>
</Column>

# 联合处理股

<BlockImage id="crafting_accelerator" scale="4" />

(任择)手合成共同处理器使系统从<ItemLink id="pattern_provider" />更经常
这使得它们能够跟上机器的快速进程。样板供应器周围环绕着
<ItemLink id="molecular_assembler" />能够比单个装配器能更快地推动原料,从而
在周围组装工之间分配原料批次。

<RecipeFor id="crafting_accelerator" />

# 手工合成监测器

<BlockImage id="crafting_monitor" scale="4" />

(任择)设计显示器显示工作 CPU 正在处理中。
屏幕的颜色可以使用<ItemLink id="color_applicator" />.

<RecipeFor id="crafting_monitor" />
