---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: ME 存储总线
  icon: storage_bus
  position: 220
categories:
- devices
item_ids:
- ae2:storage_bus
---

# 存储总线

<GameScene zoom="8" background="transparent">
<ImportStructure src="../assets/blocks/storage_bus.snbt" />
</GameScene>

曾经想过*保留*而不是用理智的东西取代你的箱子怪物?存储总线!

存储总线将它所触及的目录转换为[网络存储](../ae2-mechanics/import-export-storage.md).
这样做的方式是,允许网络查看清单的内容,推动和从清单中提取
(a) 清单,以便履行[设备](../ae2-mechanics/devices.md)从网络存储中推来拉去。

应付应欠款应付 AE2 新兴机械学理论,[设备](../ae2-mechanics/devices.md),你没有
必要*拥有*使用存储总线用于*存储*. 通过使用[子网络](../ae2-mechanics/subnetworks.md)
转换一个存储总线(或几小件存储总客车)排*仅*在网络的存存储储中,您可以使用它作为源或目的地
用于传输物品。(见见["管道子网"](../example-setups/pipe-subnet.md))

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

## 过滤

默认情况下, 总线将存储全部。插入到过滤器槽中的物品将作为空白列表, 只有
允许存储这些具体物品。

物品和液体可以拖进从 JEI 即使你没有那东西

用液体容器右键单击(象桶或液罐一样)将液体设置为过滤器,而不是桶或罐体物品。

## 优先

可以通过单击扳手在 GUI.
输入网络的物品将在最优先存储时开始
在两个仓库中,两个储藏室享有同样的优先权,
如果其中有一个已经包含此物品,他们宁可存放该物品而不愿存储任何物品。
。任何过滤过的存储将被视为已经包含此物品。
当与其他存储器处于相同的优先级组时。从存储中移除的物品将
优先级别最低的存储器,从存储中移除。优先系统是指插入和删除物品。
从网络存储中取出,将填充更优先的存储,并清空更次要的贮存。

## 设置

*   总线可以分割(已过滤)与目前库存的相邻库存
*   网络可以被禁止或允许查看总线无法提取的相邻盘点中的物品
    (例如,a 存储总线无法从一个<ItemLink id="inscriber" />)
*   公交车既可以过滤插入和提取,也可以直接插入
*   总线可双向、只插入或只提取

## 升级

存储总线支持以下支持[升级](upgrade_cards.md):

*   <ItemLink id="capacity_card" />增加过滤空格的数量
*   <ItemLink id="fuzzy_card" />使总线通过损坏等级和/或忽略物品过滤 NBT
*   <ItemLink id="inverter_card" />将过滤器从白色列表切换为黑名单
*   <ItemLink id="void_card" />如果所附的库存是完整的,则插入的物品无效, 可用于阻止农场备份。请注意分割此项 !

## 用途

<RecipeFor id="storage_bus" />
