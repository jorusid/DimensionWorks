---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: P2P 隧道
  icon: me_p2p_tunnel
  position: 210
categories:
- devices
item_ids:
- ae2:me_p2p_tunnel
- ae2:redstone_p2p_tunnel
- ae2:item_p2p_tunnel
- ae2:fluid_p2p_tunnel
- ae2:fe_p2p_tunnel
- ae2:light_p2p_tunnel
---

# 点对点隧道

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/p2p_tunnels.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

P2P 隧道是移动物品、液体、红石信号、电、光等东西的一种方式[频道](../ae2-mechanics/channels.md)
围绕一个网络周围的网络,而没有直接与网络直接互动。P2P 每个隧道
它们基本上就像直接连接的门户
范围为两个块面。它们不是双向的,有定义的投入和产出。

![门户网站门户](../assets/assemblies/p2p_portal.png)

例如,物品面对的直升机 P2P 将表现为它与桶直接相连,物品会流动。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/p2p_hopper_barrel.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

然而,两个桶相邻的两桶不会相互之间传输物品。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/p2p_barrel_barrel.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

还有其他的变体,如红石 P2P.

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/p2p_redstone.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 类型 P2P 隧道和隧道建设

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/p2p_tunnels.snbt" />
  <IsometricCamera yaw="180" pitch="90" />
</GameScene>

有许多类型的 P2P 隧道。MEP2P 其它的则通过右键单击其他
P2P 含有某些物品的隧道:
- MEP2P 以右键单击方式选择[电缆](../items-blocks-machines/cables.md).
- 重石 P2P 通过右键点击选定隧道,其中含有各种红石部件。
- 物品 物品 物品 物品 目 物品 P2P 通过右键点击用胸部或直升机选择隧道。
- 流流体 P2P 通过右键点击桶或瓶子选定隧道。
- 能源 P2P 通过右键点击选定隧道,几乎用任何含有能量的物品。
- 照明灯 P2P 以电灯或发光石单击右键选定隧道

有些隧道有怪异的种类 比如说 MEP2P 隧道的通道无法通过其他通道 MEP2P 隧道,和
能源 P2P 间接征收 2.5%的税 FE 他们因增加自身而流动,
[能源](../ae2-mechanics/energy.md)绘图。

## 使用最多的 P2P

最常见的使用案例 P2P 隧道使用 MEP2P 缩缩隧道的密度[频道](../ae2-mechanics/channels.md)运输。
使用单一的密度电缆,而不是一堆密闭电缆来绕着许多渠道。

例如,8 个 MEP2P 输入 256 个频道(8*32)从主网络的<ItemLink id="controller" />8 和 8MEP2P 产出 
在其它位置输出它们。P2P 隧道输入或输出需要一个频道。因此我们可以运行许多频道 
透过薄电缆 P2P 隧道在一条专用的[子网络](../ae2-mechanics/subnetworks.md),我们不是
甚至在使用主网络的任何频道来这样做!P2P 隧道可以直接放置
a 对着一个控制器,a[密密密度智能电缆](../items-blocks-machines/cables.md#smart-cable)可以在中间放置,以便更容易地视觉化频道。

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/p2p_compact_channels.snbt" />

  <BoxAnnotation color="#dddddd" min="1.3 1.3 6.3" max="2 2.7 6.7">
        Quartz Fiber 在主网络和 p2p 子网络之间共享能源。
  </BoxAnnotation>

  <IsometricCamera yaw="225" pitch="30" />
</GameScene>

举另一个例子(包括其使用[量子桥](quantum_bridge.md))看见这张 MS 画图,我不介意
触摸上:

![P2P 和量子桥梁](../assets/diagrams/p2p_quantum_network.png)

## 内嵌嵌套

但是,你不能用它通过单一的电缆发送无穷无尽的频道。MEP2P 隧道不会
通过另一个 MEP2P 隧道,所以您不能连成巢套。观察外层 MEP2P 隧道
红电缆上的红线电缆离线。请注意,这只适用于 MEP2P 隧道,其他 P2P 隧道类型可以穿过 MEP2P 隧道
正如红石所见 P2P 隧道运作良好。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/p2p_nesting.snbt" />
  <IsometricCamera yaw="225" pitch="30" />
</GameScene>

## 链接

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/p2p_linking_frequency.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

A 结尾 P2P 使用<ItemLink id="memory_card" />。将显示频率
作为隧道后方的 2x2 颜色阵列。
- 单击 Shift- right 键以生成新的 P2P 连接频率。
- 单击右键粘贴设置、升级卡片或连接频率。

右转点击的隧道将是输入,右键点击的是输出。您可以有多个输出,
中为 MEP2P 隧道,输入中的通道 将在输出之间分割, 这样您无法重复通道。

## 用途

<RecipeFor id="me_p2p_tunnel" />