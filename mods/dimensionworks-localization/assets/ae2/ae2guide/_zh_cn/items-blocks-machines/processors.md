---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 处理器
  icon: logic_processor
  position: 010
categories:
- misc ingredients blocks
item_ids:
- ae2:logic_processor
- ae2:calculation_processor
- ae2:engineering_processor
- ae2:printed_silicon
- ae2:printed_logic_processor
- ae2:printed_calculation_processor
- ae2:printed_engineering_processor
- ae2:silicon
---

# 处理器

<Row>
  <ItemImage id="logic_processor" scale="4" />

  <ItemImage id="calculation_processor" scale="4" />

  <ItemImage id="engineering_processor" scale="4" />
</Row>

处理器是主要原料之一 AE2[设备](../ae2-mechanics/devices.md)和机器,它们也是你最早的
有三种处理器,用黄金制成,<ItemLink id="certus_quartz_crystal" />,
钻石和钻石分别使用[压印模板](presses.md)中<ItemLink id="inscriber" />,在多步
进程(通常通过一系列登记人和过滤管道实现).

## 生产步骤

<Column gap="5">
  1.  收集/合成所需原料:硅、红石、金、<ItemLink id="certus_quartz_crystal" />钻石

  <RecipeFor id="silicon" />

  <br />

  2.  按要求的印刷电路部件

  <Row>
    <RecipeFor id="printed_silicon" />

    <RecipeFor id="printed_logic_processor" />
  </Row>

  <Row>
    <RecipeFor id="printed_calculation_processor" />

    <RecipeFor id="printed_engineering_processor" />
  </Row>

  <br />

  3.  最后文件最后大会

  <Row>
    <RecipeFor id="logic_processor" />

    <RecipeFor id="calculation_processor" />
  </Row>

  <RecipeFor id="engineering_processor" />
</Column>
