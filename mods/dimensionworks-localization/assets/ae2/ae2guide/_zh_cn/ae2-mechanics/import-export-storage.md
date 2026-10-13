---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 进出口和存储
---

# 进出口和存储

**贵国的 ME 系统与世界的关系**

人权中一个重要的概念 AE2 网络存储的概念。它是存储网络内容的地方,
通常[存储单元格](../items-blocks-machines/storage_cells.md)或任何清单 a<ItemLink id="storage_bus" />
大部分 AE2[设备](../ae2-mechanics/devices.md)以某种方式与它互动。

例如,

*   <ItemLink id="import_bus" />将东西推入网络存储
*   <ItemLink id="export_bus" />Ses 从网络存储中提取东西
*   <ItemLink id="interface" />从网络存储中拉出并推至网络存储
*   [终端码头](../items-blocks-machines/terminals.md)当插入或取取物品时, 既拉到网络存储, 又拉出网络存储, 或者重新填充绘图槽
*   <ItemLink id="storage_bus" />它们不会真正推动或拉动存储, 他们推到或从连接的库存中拉出来
    以便用作网络存储(所以其他设备真的会按下或拉离*三、它们*)

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/import_export_storage.snbt" />

  <BoxAnnotation color="#dddddd" min="8 1 1" max="9 1.3 2">
        Busses 从他们指向网络存储的库存中进口物品
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="8 2 1" max="9 3 1.3">
        输入网络时, 从您的库存中将某个东西插入终端数
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="7 0 1" max="8 1 2">
        如果该空档没有配置存储任何物品,或有更多的,则将从其内部库存清单中输入接口。
        此槽中的物品, 而不是配置后要存储的配置, 这样事情就可以被推到它们中插入到网络
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="6 0 1" max="7 1 2">
        样板供应器将从内部回程时位库存中进口,以便把事情推到其中,插入网络
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="4 1 1" max="5 2 2">
        驱动盘提供插入单元格作为网络存储
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="3 1 1" max="4 1.3 2">
        Busses 使用他们指的网络存储清单
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1 1 1" max="2 1.3 2">
        Busses 出口公司从网络存储 出口到他们指的库存
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1 2 1" max="2 3 1.3">
        从终端里拉出东西 算作是出口网络
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="0 1 1" max="1 2 2">
        接口将输出到内部库存,如果该槽配置为存储某物,
        以便从网络中提取东西
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

在设计自动化时,必须铭记推动和从网络存储中提取的推动行动/活动
以及后勤安排。

## 优先存储

优先级可以通过单击某些图形用户界面右上角的扳手来设定。
输入网络的物品将从最优先存储时开始,
第一目的地,如果两个存储库具有同样的优先权,
如果其中有一个已经包含此物品,他们宁可存放该物品而不愿存储任何物品。
。任何列出的白名单上的单元格都将被视为已经包含此物品
当与其他存储器处于相同的优先级组时。从存储中移除的物品将
优先级别最低的存储器,从存储中移除。优先系统是指插入和删除物品。
从网络存储中取出,将填充更优先的存储,并清空更次要的贮存。
