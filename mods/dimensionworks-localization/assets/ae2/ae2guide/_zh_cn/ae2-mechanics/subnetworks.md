---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 子网络
---

# 子网络

<GameScene zoom="4" interactive={true}>
<ImportStructure src="../assets/assemblies/subnet_demonstration.snbt" />

<DiamondAnnotation pos="6.5 2.5 0.5" color="#00ff00">
        物品管子网
    </DiamondAnnotation>

<DiamondAnnotation pos="5.5 2.5 0.5" color="#00ff00">
        流流管子网
    </DiamondAnnotation>

<DiamondAnnotation pos="4.5 2.5 0.5" color="#00ff00">
        已过滤破坏面板
    </DiamondAnnotation>

<DiamondAnnotation pos="3.5 2.5 0.5" color="#00ff00">
        成型面板子网
    </DiamondAnnotation>

<DiamondAnnotation pos="2.5 2.5 0.5" color="#00ff00">
        使用接口的子网存储总线用于作为本地子存储器的交互
网络可访问
    </DiamondAnnotation>

<DiamondAnnotation pos="1.5 1.5 0.5" color="#00ff00">
        将充电物品还给样板供应器
    </DiamondAnnotation>

<IsometricCamera yaw="195" pitch="30" />
</GameScene>

“子网络”是一个定义相当松散的术语,但可以说子网是支持您
主网络或做一些小任务。它们通常小到不需要控制器。它们的两个主要用途往往是:

*   限制什么[设备](../ae2-mechanics/devices.md)能够获取哪些存储(你不想要那个输入总线在“管道”子网上 进入主网
    存储, 或者它会将这些物品放入您的存储单元格, 而不是放在目的地的库存清单中).
*   保存您主网络的频道, 比如有一个样板供应器输出为连接多个存储的界面
    使用 1 个频道,而不是安装样板供应器每台机器上都有几个频道

不同颜色的电缆 与合成子网络无关 除了它们不会互相连接之外

他们可以

*   a , a)输入总线和存储总线将物品或液体从一个容器传输到另一个容器,如一个物件或液管
*   a , a)破坏面板和存储总线,所以唯一的地方破坏面板它可以把它折断的存储总线,允许您过滤飞机
*   接口和成型面板键,以便插入到接口中的任何内容都能够被推到成型面板被安置在(毁灭)世界中,
*   自动设置赛特斯石英(a) 受一缔约方管辖和控制的<ItemLink id="level_emitter" />主网络上的
*   通过专门的存储-客车对面互动,从主网络进入一个专门存储系统,以便存储农场的输出,而不会无止尽地溢出主存储
*   以等等

可用于建立子网络的<ItemLink id="quartz_fiber" />.它传输网络之间的权力,没有
连接它们,允许你用子网供电 不需要把能量接收器和电缆 放置到任何地方
