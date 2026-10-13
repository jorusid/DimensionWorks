---
navigation:
  parent: example-setups/example-setups-index.md
  title: Dumper 单元格或填充器
  icon: io_port
---

# Dumper 单元格或填充器

有人可能会问:“我如何迅速将一个牢房空入一个胸箱或抽屉阵列或背包,或者从同一个牢房填充一个反面的单元格?”

答案是使用<ItemLink id="io_port" />和一些子网格 限制它可以放置物品的地方, 或者从中拉出物品。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/cell_dumper_filler.snbt" />

<BoxAnnotation color="#dddddd" min="1 1 0" max="2 2 1">
        (1)IO 端口:可设置为“将数据传送到网络”或“向存储元件使用箭头按钮
        在中间 GUI 有三张加速卡
        <ItemImage id="speed_card" scale="2" />
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 0.7 0" max="1 1 1">
        (2)存储总线:在其默认配置中。
  </BoxAnnotation>

<BoxAnnotation color="#33dd33" min="0 1 0" max="1 2 1">
        将您想要填充或空的东西放在这里。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="2 0.35 0.35" max="2.3 0.65 0.65">
        Quartz Fiber:只要能源是另一个网络,就有必要。
  </BoxAnnotation>

<DiamondAnnotation pos="3 0.5 0.5" color="#00ff00">
        某种能源,如其他网络,或能源接收器.
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* <ItemLink id="io_port" />(1)可设置为“将数据传送到网络”或“向存储元件使用箭头按钮
  在中间 GUI。它有 3 张加速卡,以达到最大速度。
* <ItemLink id="storage_bus" />(2)默认配置。

## 如何运作

### 在“ 传输到网络” 模式下

1. <ItemLink id="io_port" />试图将插入的内容倾弃[存储元件](../items-blocks-machines/storage_cells.md).
    与[网络存储](../ae2-mechanics/import-export-storage.md).
2. 子网上唯一的存储器是<ItemLink id="storage_bus" />存储物品或液体或其他物品,
    你把它放在门前。
* <ItemLink id="energy_cell" />提供足够大的缓冲[能源](../ae2-mechanics/energy.md)网络的功能
    无法从每次调换这么多项的电源抽出。

### 在 " 转让给存储元件" 模式

1. <ItemLink id="io_port" />试图将[网络的存储](../ae2-mechanics/import-export-storage.md)
   插入[存储元件](../items-blocks-machines/storage_cells.md).
2. 子网上唯一的存储器是<ItemLink id="storage_bus" />,它将物品或液体等从任何物体中拉出来
   你把它放在门前。
* <ItemLink id="energy_cell" />提供足够大的缓冲[能源](../ae2-mechanics/energy.md)网络的功能
  无法从每次调换这么多项的电源抽出。