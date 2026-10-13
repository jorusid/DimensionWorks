---
navigation:
    parent: epp_intro/epp_intro-index.md
    title: 组组矩阵
    icon: expatternprovider:assembler_matrix_frame
categories:
- extended devices
item_ids:
- expatternprovider:assembler_matrix_frame
- expatternprovider:assembler_matrix_wall
- expatternprovider:assembler_matrix_glass
- expatternprovider:assembler_matrix_pattern
- expatternprovider:assembler_matrix_crafter
- expatternprovider:assembler_matrix_speed
---

# 组组矩阵

<Row>
<BlockImage id="expatternprovider:assembler_matrix_frame" p:formed="true" p:powered="true" scale="5"></BlockImage>
<BlockImage id="expatternprovider:assembler_matrix_wall" scale="5"></BlockImage>
<BlockImage id="expatternprovider:assembler_matrix_glass" scale="5"></BlockImage>
</Row>
<Row>
<BlockImage id="expatternprovider:assembler_matrix_pattern" scale="5"></BlockImage>
<BlockImage id="expatternprovider:assembler_matrix_crafter" scale="5"></BlockImage>
<BlockImage id="expatternprovider:assembler_matrix_speed" scale="5"></BlockImage>
</Row>

组组母体是一个多块结构。<ItemLink id="ae2:molecular_assembler" />和<ItemLink id="ae2:pattern_provider" />.
它可以同时做很多手艺工作(足够<ItemLink id="ae2:crafting_accelerator" />在您 ME 网络网)并为你们保存通道。

## 结构

<GameScene zoom="3" background="transparent" interactive={true}>
  <ImportStructure src="../structure/assembler_matrix.snbt"></ImportStructure>
</GameScene>

它是长方形棱镜,边缘长度在 3 至 7 之间。 
- 边缘由组装矩阵框架组成。
- 由装配板壁/玻璃组成的面孔。
- 内部结构由组装母体型式/软形/外形核心组成。

有效的组装母体必须包含至少一个模式核心和手动核心。 
它必须完全填满,不能空洞。
当组装母体的形成和动力正确时,组装母体框架上的线条会变得蓝色。

## 组组矩阵核心

有三个不同的组装母体核心。

- 组组矩阵模式核心

组装母体只从其模式核心中取出模式。每个模式的核心都为组装母体提供 36 个模式位置。

- 工件核心

组装母体将指派其手合成核心为接收的手工工作。每个手工业核心可以同时运行 8 个手艺工作。

- 组组母体速度核心

就是这样<ItemLink id="ae2:speed_card" />用于组装母体。5 个速度核心使组装母体能够全速运行。
安装超过 5 个速度核心不会增加速度加速

## GUI

右键单击已形成且在线的组装矩阵将打开它 GUI.

![GUI](../pic/assembler_matrix.png)

您可以在其中设置或搜索模式, 并查看它正在运行的多少手合成工作。
