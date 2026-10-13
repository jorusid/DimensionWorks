---
navigation:
  parent: example-setups/example-setups-index.md
  title: 物品/五 "Pipe"子网
  icon: storage_bus
---

# 物品/五 "Pipe"子网

一种简单的方法,用 AE2[设备](../ae2-mechanics/devices.md)有用,嗯,任何东西 你会使用一个物品或液管。
这包括将船只的结果归还<ItemLink id="pattern_provider" />.

实现这一点一般有两种不同的方法:

## 输入总线->存储总线

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/import_storage_pipe.snbt" />

<BoxAnnotation color="#dddddd" min="3.7 0 0" max="4 1 1">
        (1)输入总线:可以过滤。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 0 0" max="1.3 1 1">
        (2)存储总线:可以过滤。这个(和您想要成为目的地的其他存储总车)
        必须是唯一存储在网络上的存储。
  </BoxAnnotation>

<DiamondAnnotation pos="4.5 0.5 0.5" color="#00ff00">
        来源
    </DiamondAnnotation>

<DiamondAnnotation pos="0.5 0.5 0.5" color="#00ff00">
        目的地
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

<ItemLink id="import_bus" />(1)进口这些物品或液体,并试图将这些物品存储在[网络存储](../ae2-mechanics/import-export-storage.md).
由于网络上唯一的存储库是<ItemLink id="storage_bus" />(2)(这就是为什么这是子网而不是主网络的原因)、物品或流体
将能源列入目的地清单,从而传输。<ItemLink id="quartz_fiber" />.
两者输入总线和存储总线可被过滤, 但设置将会传输所有可以访问的, 如果没有应用过滤器, 则会传送。
这一设施还涉及多家进口客车和多辆存储客车上。

## 存储总线->输出总线

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/storage_export_pipe.snbt" />

<BoxAnnotation color="#dddddd" min="3.7 0 0" max="4 1 1">
        (1)存储总线:可以过滤。这个(和您想要成为源代码的其他存储总线)
        必须是唯一存储在网络上的存储。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 0 0" max="1.3 1 1">
        (2)输出总线:必须过滤。
  </BoxAnnotation>

<DiamondAnnotation pos="4.5 0.5 0.5" color="#00ff00">
        来源
    </DiamondAnnotation>

<DiamondAnnotation pos="0.5 0.5 0.5" color="#00ff00">
        目的地
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

<ItemLink id="export_bus" />试图将物品从[网络存储](../ae2-mechanics/import-export-storage.md).
由于网络上唯一的存储库是<ItemLink id="storage_bus" />(这就是为什么这是子网而不是主网络的原因)、物品或流体
从源清单中提取出,从而传输。<ItemLink id="quartz_fiber" />.
由于导出总编必须过滤以运行功能,此设置只有在过滤输出总线.
这一设施还涉及多家储货总线和多辆出口总线。

## 无效设置(输入总线->输出总线)

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/import_export_pipe.snbt" />

<BoxAnnotation color="#dd3333" min="3.7 0 0" max="4 1 1">
        输入总线:因为网络没有存储,所以没有进口的场所。
  </BoxAnnotation>

<BoxAnnotation color="#dd3333" min="1 0 0" max="1.3 1 1">
        (2)输出总线:因为网络没有存储,所以没有可用于出口的物品。
  </BoxAnnotation>

<DiamondAnnotation pos="4.5 0.5 0.5" color="#ff0000">
        来源
    </DiamondAnnotation>

<DiamondAnnotation pos="0.5 0.5 0.5" color="#ff0000">
        目的地
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

装设,只进口输出总线无法工作。输入总线试图从源清单中提取
,然后将物品或液体存储在网络存储中。输出总线将试图从网络存储中提取并安装
目的地清单中的物品或流体。然而,自从这个网络以来**没有存储**, 显示输入总线无法导入
和输出总线不能出口,所以什么也不会发生

## 通过一面输入和输出

说有一台机器可以接收输入 并且将输出拉到 1 张脸(像一个<ItemLink id="charger" />)
您可以将两个管道子网方法组合在一起, 推进原料并拉出结果:

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/import_storage_export_pipe.snbt" />

<BoxAnnotation color="#dddddd" min="4 1 1" max="5 1.3 2">
        (1)输入总线:可以过滤。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="2 1 1" max="3 1.3 2">
        (2)存储总线:可以过滤。这个(和您想要推动和拉动的物品的其他存储总车)
        必须是唯一存储在网络上的存储。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="2 0 1" max="3 1 2">
        (3)你想推向和拉出的东西: 在这个案例中,一个充电者。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 1 1" max="1 1.3 2">
        (4)输出总线:必须过滤。
  </BoxAnnotation>

<DiamondAnnotation pos="4.5 0.5 1.5" color="#00ff00">
        来源
    </DiamondAnnotation>

<DiamondAnnotation pos="0.5 0.5 1.5" color="#00ff00">
        目的地
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 接口

原来有[设备](../ae2-mechanics/devices.md)除了进口客车和出口将物项推入
将物品从[网络存储](../ae2-mechanics/import-export-storage.md)!
与此相关的是<ItemLink id="interface" />。如果插入一个物品,显示接口没有设置存储,该接口将
将它推至网络存储, 我们可以使用它类似输入总线->存储总线设置一个接口到
某些物品将从网络存储中提取,类似于存储总线->输出总线管道界面可以设置为
存储一些东西,而不是存储其他东西 允许你远程推进和拉 通过存储总车, 如果你出于某种原因想这样做。

<GameScene zoom="6" background="transparent">
<ImportStructure src="../assets/assemblies/interface_pipes.snbt" />

<BoxAnnotation color="#dddddd" min="3.7 0 0" max="4 1 1">
        界面
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 0 0" max="1.3 1 1">
        存储总线
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="3.7 0 2" max="4 1 3">
        存储总线
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 1 2" max="1 1.3 3">
        存储总线
  </BoxAnnotation>

<IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 一对多和一(多至多)

当然,不用用一个<ItemLink id="import_bus" />或<ItemLink id="export_bus" />或<ItemLink id="storage_bus" />

<GameScene zoom="3" background="transparent">
<ImportStructure src="../assets/assemblies/many_to_many_pipe.snbt" />

<IsometricCamera yaw="185" pitch="30" />
</GameScene>

## 向多个地方提供

从所有这一切中,我们可以找到一种方法,从一个中发送成份<ItemLink id="pattern_provider" />与许多不同
位置,像一系列机器, 或者几个不同的面孔 一个机器。

我们不希望进口 - > 存储管道或存储 -> 出口管道,因为<ItemLink id="pattern_provider" />从未
实际上包含原料。相反, 样板供应器*推进*相邻库存清单的原料, 所以我们需要一些 
可进口物品的相邻库存。

这听起来像...<ItemLink id="interface" />!
确保服务提供方处于方向或平平的子分区模式和/或接口处于平坦的分部分模式, 使两个用户不形成网络
连接。

<GameScene zoom="6" background="transparent">
<ImportStructure src="../assets/assemblies/provider_interface_storage.snbt" />

<BoxAnnotation color="#dddddd" min="2.7 0 1" max="3 1 2">
        界面(必须是平平的,而不是满满的)
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 0 0" max="1.3 1 4">
        存储库
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 0 0" max="1 1 4">
        您想要提供模式提供的位置(多台机器, 或 1 台计算机的多面)
  </BoxAnnotation>

<IsometricCamera yaw="185" pitch="30" />
</GameScene>