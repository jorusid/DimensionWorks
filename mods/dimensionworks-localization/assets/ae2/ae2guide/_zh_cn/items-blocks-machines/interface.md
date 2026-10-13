---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 界面
  icon: interface
  position: 210
categories:
- devices
item_ids:
- ae2:interface
- ae2:cable_interface
---

# 界面

<Row gap="20">
<BlockImage id="interface" scale="8" />
<GameScene zoom="8" background="transparent">
  <ImportStructure src="../assets/blocks/cable_interface.snbt" />
</GameScene>
</Row>

接口的功能就像一个小胸部和液体罐, 填满了自己和空空到[网络存储](../ae2-mechanics/import-export-storage.md)
取决于您设置它以保存其空位的存储量。它试图在一局棋中完成, 以便它能填满
或从每个色调的最多 9 堆中空出,如果有快件管道,则快速导入或导出。

另一个有用的特征是,虽然大多数液体罐只能存储一种液体,但接口可以存储多达 9 种液体和物品。
它们基本上只是胸箱/多流水罐体,具有一些额外的功能, 你可以通过保持
他们与任何网络都断绝了联系
因此,它们在某些特殊情况下是有用的, 在那些情况下,你想存储 少量的一帮不同的东西。

## 一个接口如何在内部工作

如前所述,接口基本上是胸部/坦克,带有某些超级哑人。<ItemLink id="import_bus" />和
<ItemLink id="export_bus" />连着一束<ItemLink id="level_emitter" />.

<GameScene zoom="3" interactive={true}>
  <ImportStructure src="../assets/assemblies/interface_internals.snbt" />

  <BoxAnnotation color="#dddddd" min="1.3 0.3 1.3" max="9.7 1 1.7">
        一组级别排放器来控制要求的库存量
        <GameScene zoom="4" background="transparent">
        <ImportStructure src="../assets/blocks/level_emitter.snbt" />
        </GameScene>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1.3 4 1.3" max="9.7 4.7 1.7">
        一组级别排放器来控制要求的库存量
        <GameScene zoom="4" background="transparent">
        <ImportStructure src="../assets/blocks/level_emitter.snbt" />
        </GameScene>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1.3 1.3 1.3" max="9.7 2 1.7">
        一堆超级哑巴进口大客车 每只可以传输一堆垃圾
        <GameScene zoom="4" background="transparent">
        <ImportStructure src="../assets/blocks/import_bus.snbt" />
        </GameScene>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1.3 3 1.3" max="9.7 3.7 1.7">
        一群超级哑巴出口的总线 每只可以传输一堆垃圾
        <GameScene zoom="4" background="transparent">
        <ImportStructure src="../assets/blocks/export_bus.snbt" />
        </GameScene>
  </BoxAnnotation>

  <BoxAnnotation color="#dddddd" min="1 2 1" max="10 3 2">
        9 个单独的内部空档
  </BoxAnnotation>

  <IsometricCamera yaw="195" pitch="15" />
</GameScene>

## 特别互动

接口还具有一些与其它 AE2[设备](../ae2-mechanics/devices.md):

A<ItemLink id="storage_bus" />在一个未配置的界面上显示[网络存储](../ae2-mechanics/import-export-storage.md)
联系的网络的联网到存储总线网络,好像接口的网络 是一个大箱子存储总线被放在上面。
设置要存储在接口过滤槽中的物品将禁用此功能。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/interface_storage.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

样板供应器与[子网](../ae2-mechanics/subnetworks.md):如果接口未配置
提供商将完全跳过接口 直接按到子网[存储](../ae2-mechanics/import-export-storage.md),
跳过接口,不填满配方批量, 更重要的是,在存储空间之前不要插入下一批。

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

## 变式

接口以两种不同的变式出现:正常和平方/[下分部分](../ae2-mechanics/cable-subparts.md).这影响到哪些方面可以查阅其清单
和它们提供网络连接。

*   正常界面让事物能够从所有方面 和像多数人一样 推进、拉出并进入它们的库存 AE2 机器,动作
    就像一条线 提供网络连接到所有侧面

*   平坦接口为[电缆子部件](../ae2-mechanics/cable-subparts.md),因此可以在同一条电缆上安装多个,允许设置压缩装置。
    它们允许事物从表面上推动、拉动和进入其库存,但表面却不提供网络连接。

接口可以在正常和平坦的交接网格中互换。

## 设置

界面的上方空档确定界面设置在内部存储的设置位置。当某东西被放置在
或被拖去的,JEIREI,一个扳手似乎让你设定数量。

用液体容器右键单击(象桶或液罐一样)将液体设置为过滤器,而不是桶或罐体物品。

## 升级

接口支持以下内容[升级](upgrade_cards.md):

*   <ItemLink id="fuzzy_card" />使总线通过损坏等级和/或忽略物品过滤 NBT
*   <ItemLink id="crafting_card" />让接口将拼写请求发送到您[自动自制](../ae2-mechanics/autocrafting.md)
    系统,以获取它想要的物品。它会尽可能在提出要求之前将物品从存储中拉出
    用于设计新物品。

## 优先

可以通过单击扳手在 GUI。具有更高优先级的接口将获得其物品
在优先程度较低的人之前,

## 食食权

<Recipe id="network/blocks/interfaces_interface" />

<RecipeFor id="cable_interface" />
