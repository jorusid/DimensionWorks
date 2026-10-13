---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 空间锁定器
  icon: spatial_anchor
  position: 110
categories:
- network infrastructure
item_ids:
- ae2:spatial_anchor
---

# 空间锚

<BlockImage id="spatial_anchor" p:powered="true" scale="8"/>

A 音 AAE2 需要将任何[设备](../ae2-mechanics/devices.md)能够发挥作用,如果其中一部分被装入,
它可能功能不正确。空间锁定器解决了这个问题。它强制装入其网络占用的部分。
一条横跨大块边界的线线足以装载新块。

它会传播它的“装载”[量架桥](quantum_bridge.md),但并非交叉的多维,所以如果你
拥有通往绳子的量子桥, 你需要在你的基地的网络上有一个空间锚, 在你的底部的网上, 和在她的网上的。

默认情况下, 它也会启用其已装入块中的随机勾, 可以在 ae2 配置中关闭。

轮轮用<ItemLink id="certus_quartz_wrench" />如果你出于某种原因想这么做

## 设置

*   空间锚能提供进入全球环境的通道,以查看可读取或可查看 FE.
*   可显示正在装入的块的全息图。

## 能源

空间锚将使用[能源](../ae2-mechanics/energy.md)根据这个方程:

e = 80 +(x\*(x+1))/2

x 是装入的块数

## 用途

<RecipeFor id="spatial_anchor" />
