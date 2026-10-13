---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 能源
  icon: energy_cell
---

# 能源

你的网络需要能量才能运行 网络有能量库[设备](../ae2-mechanics/devices.md)直接从,和
<ItemLink id="vibration_chamber" />,<ItemLink id="energy_acceptor" />(和<ItemLink id="controller" />)添加到中。您可以
右键单击网络上任何地方的网络,查看网络的能源统计<ItemLink id="network_tool" />由
如果网络控制器有,右键单击网络的控制器。这个网络范围的存储和分发意味着
没有能源传输率的限制,因此装置可以任意地抽取高量的能源,
能量接收器可以不受功能限制的速度进取,只能受能量存储的限制。

## 能源接受

<Row>
  <BlockImage id="energy_acceptor" scale="4" />

  <GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/blocks/cable_energy_acceptor.snbt" />
  </GameScene>

  <BlockImage id="controller" p:state="online" scale="4" />

  <BlockImage id="vibration_chamber" p:active="true" scale="4" />
</Row>

AE2 不使用 Forge 能源(日期 上 Forge)或可再生能源(美非组织)相反,它将其转换成
AE. 这种转换是单向的。<ItemLink id="energy_acceptor" />和
<ItemLink id="controller" />,但控制器面孔更好地用于更多[频道](../ae2-mechanics/channels.md).
也可以由下列因素产生:<ItemLink id="vibration_chamber" />,但 AE2 设计
与能产生更好的能源的其他技术模式一起使用。

所有这一切都意味着 最好考虑 AE2 设置您的基地时, 将它作为单一的大型多区块机器网络
能源分配基础设施。

换算比率 Forge 能源和技术所生能源

*   2FE= 1 阿英(Forge)
*   1 E = 2 AE(合成业)

## 能源存储

<Row>
  <BlockImage id="energy_cell" scale="4" p:fullness="4" />

  <BlockImage id="dense_energy_cell" scale="4" p:fullness="4" />

  <BlockImage id="creative_energy_cell" scale="4" />
</Row>

出于相对明显的原因,网络不能在游戏中吸收或消耗超过存储的能量。如果网络存在的话,
只能存储 800 年时间[设备](../ae2-mechanics/devices.md)能源需求,只能使用 800 年(假设存储已满)
和 a 的能源接收器只能将最多 800 个申请实体插入网络(假设存储为空).

这是造成奇异行为的一个常见原因, 一个人合成一个小网络,能源接收器,驱动器,终端和
一些装置, 并试图将堆满其清册中的可腐岩堆放到网络中。插入此 cobblall 全部同时插入
单复选单色调需要比网络存储中的能量更大的能量, 所以没有全部的 cobble 被插入, 网络
能量耗尽,因此重新启动。

**增加能源电池可以解决这个问题。**

网络的内置能源缓冲装置为每条电缆、机器或部件 25AE。

<ItemLink id="controller" />内部能源存储量很小,为 8,000 阿联酋

<ItemLink id="energy_cell" />可以存储 200 公里的可控电源,而且对于处理电流的多数使用案例来说,只要一个就足够了。
* 容易地正常使用网络。

<ItemLink id="dense_energy_cell" />可存储 1.6M 电源, 用于您想要用存储的电量运行网络时, 或者
处理大型瞬时能量抽取[空间存储](spatial-io.md)设置。

<ItemLink id="creative_energy_cell" />是一个用于测试的创意物品,提供 UNLIMITED POWAHH HH 或其它东西。
