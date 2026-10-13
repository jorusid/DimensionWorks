---
navigation:
  parent: example-setups/example-setups-index.md
  title: 自动库存
  icon: interface
---

# 自动库存

有人可能会问:“我如何保存一定数量的各种物品,

一种解决办法是使用<ItemLink id="interface" />和<ItemLink id="crafting_card" />自动要求新物品
来自您的网络[自动自制](../ae2-mechanics/autocrafting.md)这一设置更适合维持少量的宽度
各种物品。

这个示范装置被切断了 所以不会太宽,使用 4 最合适<ItemLink id="interface" />和 4,以及 4<ItemLink id="storage_bus" />赛斯,
全部使用 8[频道](../ae2-mechanics/channels.md)经常数[电缆](../items-blocks-machines/cables.md).

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/interface_autostocking.snbt" />

<BoxAnnotation color="#dddddd" min="0 0 0" max="2 1 1">
        (1)接口: 设置以将想要的物品保留在自己身上。它们有手合成卡。
        <ItemImage id="crafting_card" scale="2" />
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 1 0" max="2 1.3 1">
        (2)存储 Busses : “ 投入/ 输出模式” 设置为“ 只提取 ”
  </BoxAnnotation>

<DiamondAnnotation pos="4 0.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* <ItemLink id="interface" />(1)设置时,通过单击想要的物品,将希望的物品保留在它们自己身上。
   或拖到上方空格 JEI 键,然后单击槽位上方的扳手图标以设定数量。<ItemLink id="crafting_card" />.
* <ItemLink id="storage_bus" />赛 数(2)设置“输入/输出模式”为“只提取”。

## 如何运作

1. 如果<ItemLink id="interface" />无法从[网络存储](../ae2-mechanics/import-export-storage.md),
   (并且它有一个<ItemLink id="crafting_card" />),它将要求网络的[自动自制](../ae2-mechanics/autocrafting.md)更多该项的飞行器。
2. <ItemLink id="storage_bus" />Ses 允许网络访问接口的内容。