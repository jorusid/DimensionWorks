---
navigation:
  parent: example-setups/example-setups-index.md
  title: 本地专用存储
  icon: drive
---

# 本地专用存储

使用[界面的特殊行为](../items-blocks-machines/interface.md#special-interactions), a
[子网络](../ae2-mechanics/subnetworks.md)能够向主网络显示其存储内容, 无法
查看主网络的存储, 仅取用 1[频道](../ae2-mechanics/channels.md).

这对于某些农场的当地存储很有用,这样这些物品就不会流入你的主要存储库。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/local_storage.snbt" />

<BoxAnnotation color="#dddddd" min="4 0 0" max="5 2 1">
        (1)某些进口物品的方法(在此情况下的界面)
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="3 0 0" max="4 1 1">
        (2)驱动器: 里面有一些细胞。细胞应该过滤到任何农场输出的。
        这些牢房可以有平等分配卡和溢流销毁卡。
        <Row><ItemImage id="item_storage_cell_4k" scale="2" /><ItemImage id="equal_distribution_card" scale="2" /><ItemImage id="void_card" scale="2" /></Row>
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="3 1 0" max="4 2 0.3">
        (3)合成终端:在子网上可以看到驱动器的内容,但不能看到主网络存储的内容。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="2 0 0" max="2.3 1 1">
        (4)接口 # 2 : 默认配置中。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1.7 0 0" max="2 1 1">
        (5)存储总线: 设定的优先级高于主存储,可以过滤到农场产出中。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 1 0" max="2 2 0.3">
        合成终端:既可以看到主网络存储的内容,也可以看到主网存储内容。*和*子网络。
  </BoxAnnotation>

<DiamondAnnotation pos="0 0.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* 第一个<ItemLink id="interface" />(1)简单接受您拥有的农场的物品,然后将其推入子网。
* <ItemLink id="drive" />(2)有一些[单元格](../items-blocks-machines/storage_cells.md)。细胞应该是
  [元件工作台](../items-blocks-machines/cell_workbench.md)不论农业产出如何。
  细胞可以拥有<ItemLink id="equal_distribution_card" />和<ItemLink id="void_card" />.
* 第二次<ItemLink id="interface" />(4)默认配置。
* <ItemLink id="storage_bus" />拥有[优先](../ae2-mechanics/import-export-storage.md#storage-priority)集集成套
  它可以过滤到农场产出的任何地方。

## 如何运作

* <ItemLink id="interface" />在子网上显示<ItemLink id="storage_bus" />在主网络上
排<ItemLink id="drive" />。这意味着存储总线能够直接将物品从驱动器中拉出,并将物品推到驱动盘中的单元格中。
* 存储总线设置为高[优先](../ae2-mechanics/import-export-storage.md#storage-priority)以便物品优先
  放在子网里 而不是放在主仓库里
* 重要的是,如果子网中的单元格填充,物品不会溢入主网络。如果农场是一种类型
如果它退缩了,<ItemLink id="void_card" />可用以删除多余的物品。 
* 如果农业产出了多个物品,<ItemLink id="equal_distribution_card" />能够停止一个物品填充全部单元格
并且不允许存放其他物品。