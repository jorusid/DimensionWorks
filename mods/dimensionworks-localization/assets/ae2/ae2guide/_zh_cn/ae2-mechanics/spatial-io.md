---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 空间 IO
  icon: spatial_storage_cell_2
---

# 空间 IO

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/spatial_storage_1x1x1.snbt" />

  <BoxAnnotation color="#33dd33" min="1 1 1" max="2 2 2">
        要移动的音量
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />

</GameScene>

空间 IO 是一种在您世界中 切取和粘贴物理空间量的方法。它可以用来移动<ItemLink id="flawless_budding_quartz" />,
在基地有一个房间, 你可以交换不同的内部 用于不同的目的,甚至移动
终点入口!

它的工作方式*互换*在空间存储尺寸中,以相同大小的体积, 发送任何内容的定音量
高金刚石阵列中 与空间存储维度有关 以及高铁阵容的维量

这意味着,如果您有在维之间穿行的方式(空间 IO*能够*用来合成传送器,
但这样做非常复杂,有点古怪,超出了指南的范围),您可以使用它们,就像定制的压缩机或口袋
维度。

# 多个街区设置

空间 IO 需要各组成部分的具体安排才能运作,并界定要切割和粘贴的数量。

所有组成部分必须都相同[网络网](me-network-connections.md)功能,而您只能有一个
空间 IO 网络上设置。因此, a[子网络](subnetworks.md)建议。

## 空间 IO 港港端

<BlockImage id="spatial_io_port" p:powered="true" scale="4" />

<ItemLink id="spatial_io_port" />控制空间 IO 它显示多区块设置的统计, 并保持
排[空间单元格](../items-blocks-machines/spatial_cells.md)

它显示
- 存储和最大[能源](energy.md)网络中
- 执行操作所需的能量。它可以非常大, 并且可以瞬时使用, 所以确保您有足够的
  [能量电池](../items-blocks-machines/energy_cells.md)握住所有东西
- 平隆阵列的效率
- 定义音量的大小

执行空间 IO 空间存储元件输入时空空格 IO 连接红石脉冲
届时,它将*互换*时空存储维度中的音量。这意味着,如果您发送了一些
空间存储尺寸的一组区块,*然后在赛马座上再放一组区块*把手机放回输入槽
触发 IO 第二组区块将消失,第一组板块会重新出现。

**注意,任何实体 包括你在内 都会被随身携带 如果你没有办法逃出去 你会被困
在一个黑暗的、无特色的盒子里**用它来恶作剧你的朋友!

## 兆兆元

<BlockImage id="spatial_pylon" p:powered_on="true" scale="4" />

<ItemLink id="spatial_pylon" />空间中的主要部分 IO 设置, 并定义要受影响的数量。

体积由各方向 1 个区块中订约的塔形外端的捆绑盒界定。

规则是:
- 3x3 x3 最小尺寸(定义 1x1x 1 音量)
- 所有空间赛塔都必须在外边的框框内
- 所有空间塔必须在同一网络上
- 所有赛塔必须至少两个街区长

例如, 说您想要定义 3x3 x3 卷。根据规则 2, 所有塔必须位于 5x5 x5 贝壳内
只要它们包含在 1 块宽
5x5X5 贝壳。

<GameScene zoom="4" interactive={true}>
<ImportStructure src="../assets/assemblies/spatial_storage_3x3x3_pylon_demonstration.snbt" />

<BoxAnnotation color="#33dd33" min="1 1 1" max="4 4 4">
        要移动的音量
  </BoxAnnotation>

<BoxAnnotation color="#3333ff" min="5 5 0" max="0 0 5">
  </BoxAnnotation>

<IsometricCamera yaw="195" pitch="30" />
</GameScene>

更合理的设置是:

<GameScene zoom="4" interactive={true}>
<ImportStructure src="../assets/assemblies/better_spatial_storage_3x3x3.snbt" />

<BoxAnnotation color="#33dd33" min="1 1 1" max="4 4 4">
        要移动的音量
  </BoxAnnotation>

<BoxAnnotation color="#3333ff" min="5 5 0" max="0 0 5">
  </BoxAnnotation>

<IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 效率

平隆阵列的效率取决于您填充的贝壳数量。
效率非常低,可能需要*数十亿*AE. 申请实体的提名

## 单元格尺寸

一次 a[空间单元格](../items-blocks-machines/spatial_cells.md)已经使用过, 并获得一组永久定义的 XYZ 维值(eg, 3x4x2)
并且与空间存储层面的空间量相联系。**无法安置、改造、或重新保存
它已被使用。**如果您想要使用不同的维度, 请创建新单元格。 

单元格名称中的这些不是相同的尺寸, 163 的单元格可以具有任何尺寸*最高至*16x16x16

请注意, 此音量具有方向性, 无法旋转。2x2x3 音号与 3x 2X2 的音卷不同, 即使它们是
大小相同。

如果单元格的 XYZ 尺寸与定义的音量不匹配(可见于 IO 端口), 显示 IO 端口将无法运行。