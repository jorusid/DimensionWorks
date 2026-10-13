---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 量子桥
  icon: quantum_ring
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:quantum_link
- ae2:quantum_ring
---

# 量子网络桥

![组成量子网络桥](../assets/diagrams/quantum_bridge_demonstration.png)

量子网络桥梁[网络网](../ae2-mechanics/me-network-connections.md)距离甚远,甚至各维之间
总共可携带 32 个频道(不论电缆如何与每张脸相连接),基本上
像无线[密集电缆](cables.md#dense-cable).

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/quantum_bridge_internal_structure_1.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/quantum_bridge_internal_structure_2.snbt" />

  <BoxAnnotation color="#33dd33" min="1 1 1" max="6 2 3">
        两个端端之间的一条想象中的电缆
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

值得注意的是,**两侧必须填满**a 包括 a<ItemLink id="spatial_anchor" />或必须使用其他块加载器
如果两边相距甚远,

# 量子环

<BlockImage id="quantum_ring" scale="8" />

其中八个街区环绕<ItemLink id="quantum_link" />将创建
量子网络桥只有 4 个<ItemLink id="quantum_ring" />相邻
排<ItemLink id="quantum_link" />将接受网络连接,
4 个角落区块无法连接到电缆。

## 用途

<RecipeFor id="quantum_ring" />

# 量子链接厅

<BlockImage id="quantum_link" scale="8" />

环绕着<ItemLink id="quantum_ring" />
将创建量子网络桥。此块块与任何电缆和登记册没有连接。
作为网络的一部分 与全桥搭建。

这个区块的库存清单只能持有一个<ItemLink id="quantum_entangled_singularity" />并且为
自动可达。

## 用途

<RecipeFor id="quantum_link" />
