---
navigation:
  parent: example-setups/example-setups-index.md
  title: 处理器自动化
  icon: inscriber
---

# 处理器生产自动化

自动化有很多种方式[处理器](../items-blocks-machines/processors.md)这是其中之一。

这种总布局可以使用任何种类的物流管道、管道或管道,或管管或任何模式称之为它的任何设备来进行。
只要你能过滤它。

![进程 FL 光图图](../assets/diagrams/processor_flow_diagram.png)

这里详细介绍如何只用 AE2,使用[“管道”子网](pipe-subnet.md).

请注意,由于此用途 a<ItemLink id="pattern_provider" />,它意指融入[自动自制](../ae2-mechanics/autocrafting.md)
设置。如果您只想独立自动化处理器,替换样板供应器直接把原料放进上桶里

这碰巧是反向兼容的
上一个 AE2 因为即使<ItemLink id="inscriber" />,管道子网仍然插入和插入
从正面抽取出来。

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/processor_automation.snbt" />

  <BoxAnnotation color="#dddddd" min="5 1 0" max="6 2 1" thickness=".05">
        (1)样板供应器:在默认配置中,使用相关处理模式。

        <Row>
            ![逻辑模式](../assets/diagrams/logic_pattern_small.png)
            ![计算模式](../assets/diagrams/calculation_pattern_small.png)
            ![工程模式](../assets/diagrams/engineering_pattern_small.png)
        </Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4.7 2 0" max="5 3 1" thickness=".05">
        (2)存储总线# 1: 默认配置。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 1 0" max="4.3 2 1" thickness=".05">
        (3)输出总线#1: 过滤到硅, 有两张加速卡
        <Row><ItemImage id="silicon" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 4 0" max="4.3 3 1" thickness=".05">
        (4)输出总线# 2 : 过滤到 Gold Ingot, 有两个加速卡
        <Row><ItemImage id="minecraft:gold_ingot" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 5 0" max="4.3 4 1" thickness=".05">
        (5)输出总线# 3: 过滤到赛特斯石英水晶,有两张加速卡
        <Row><ItemImage id="certus_quartz_crystal" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 6 0" max="4.3 5 1" thickness=".05">
        (6)输出总线# 4: 过滤到钻石, 有两张加速卡
        <Row><ItemImage id="minecraft:diamond" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.3 3 0" max="2 2 1" thickness=".05">
        (7)输出总线# 5: 过滤到红石灰尘, 有两张加速卡
        <Row><ItemImage id="minecraft:redstone" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 1 0" max="3 2 1" thickness=".05">
        (8)压印器# 1: 在默认配置中, 有硅新闻和 4 张加速卡
        <Row><ItemImage id="silicon_press" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 3 0" max="3 4 1" thickness=".05">
        (9)压印器# 2 2: 在默认配置中, 有逻辑新闻和 4 加速卡
        <Row><ItemImage id="logic_processor_press" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 4 0" max="3 5 1" thickness=".05">
        (10)压印器# 3: 在默认配置中。拥有计算新闻和 4 张加速卡
        <Row><ItemImage id="calculation_processor_press" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 5 0" max="3 6 1" thickness=".05">
        (11)压印器# 4: 在默认配置中, 有工程新闻和 4 个加速卡
        <Row><ItemImage id="engineering_processor_press" scale="2" /><ItemImage id="speed_card" scale="2" /></Row>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2 2 0" max="1 3 1" thickness=".05">
        (12)压印器# 5: 在默认配置中, 有 4 张加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.7 2 0" max="3 1 1" thickness=".05">
        (13)输入总线# 1: 在默认配置中, 有两个加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.7 4 0" max="3 3 1" thickness=".05">
        (14)输入总线# 2 : 在默认配置中, 有 2 个加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.7 5 0" max="3 4 1" thickness=".05">
        (15)输入总线# 3: 在默认配置中, 有 2 张加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2.7 6 0" max="3 5 1" thickness=".05">
        (16)输入总线# 4: 在默认配置中, 有 2 张加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2 3 0" max="1 3.3 1" thickness=".05">
        (17)存储总线# 2: 默认配置。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="2 1.7 0" max="1 2 1" thickness=".05">
        (18)存储总线# 3: 在默认配置中。
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1 2 0" max="0.7 3 1" thickness=".05">
        (19)输入总线# 5: 在默认配置中, 有 2 张加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="5 0.7 0" max="6 1 1" thickness=".05">
        (20)存储总线# 4: 在默认配置中。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="3.3 2.7 0.3" max="3.7 3 0.7" thickness=".05">
        Quartz Fiber 授权所有 3 个压印器,因为压印器的行为像电缆一样,从而传输能量
  </BoxAnnotation>

<DiamondAnnotation pos="7 1.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="185" pitch="5" />
</GameScene>

## 配置

* <ItemLink id="pattern_provider" />(1)处于默认配置中,且相关<ItemLink id="processing_pattern" />.

  ![逻辑模式](../assets/diagrams/logic_pattern.png)
  ![计算模式](../assets/diagrams/calculation_pattern.png)
  ![工程模式](../assets/diagrams/engineering_pattern.png)

* <ItemLink id="storage_bus" />赛 数(2, 17, 18, 20)是在默认配置中。
* <ItemLink id="export_bus" />赛 数(3-7)被过滤到相关原料中。<ItemLink id="speed_card" />.
    <Row>
      <ItemImage id="silicon" scale="2" />
      <ItemImage id="minecraft:gold_ingot" scale="2" />
      <ItemImage id="certus_quartz_crystal" scale="2" />
      <ItemImage id="minecraft:diamond" scale="2" />
      <ItemImage id="minecraft:redstone" scale="2" />
    </Row>
* <ItemLink id="import_bus" />赛 数(13-16, 19)是在默认配置中。他们有 2 个<ItemLink id="speed_card" />.
* <ItemLink id="inscriber" />的默认配置。它们具有相关的[压印模板](../items-blocks-machines/presses.md),
   和 4,以及 4<ItemLink id="speed_card" />.
   <Row>
     <ItemImage id="silicon_press" scale="2" />
     <ItemImage id="logic_processor_press" scale="2" />
     <ItemImage id="calculation_processor_press" scale="2" />
     <ItemImage id="engineering_processor_press" scale="2" />
   </Row>

## 如何运作

1. <ItemLink id="pattern_provider" />将原料推入桶内
2. 第一个[管道子网](pipe-subnet.md)(橙色)拉出硅、红石粉尘和相关处理器原料
   (黄金 Ingot,赛特斯石英水晶或钻石)放在相关材料中<ItemLink id="inscriber" />.
3. 前四个<ItemLink id="inscriber" />创建<ItemLink id="printed_silicon" />和<ItemLink id="printed_logic_processor" />,
   <ItemLink id="printed_calculation_processor" />,或<ItemLink id="printed_engineering_processor" />.
4. 第二和第三次[管道子网](pipe-subnet.md)s(绿绿色)将前四轮中的打印电路从前四次中取出<ItemLink id="inscriber" />
    并使他们第五次被集合在最后的集合中,<ItemLink id="inscriber" />.
5. 第五次<ItemLink id="inscriber" />集合[处理器](../items-blocks-machines/processors.md).
6. 第四次[管道子网](pipe-subnet.md)(紫紫)将颗粒放入样板供应器返回主网络