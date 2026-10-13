---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 声道
  icon: controller
---

# 声道

应用能源 2's[ME 网络](me-network-connections.md)需要
支持的通道[设备](../ae2-mechanics/devices.md)使用网络存储或其他网络
。想想您所有设备都用 USB 电缆等频道。一个计算机只有这么多的 US B 端口, 只能支持
大部分机器、全路障装置和标准电缆只能通过
最多 8 个频道。你可以把全屏装置和标准电缆当作 8 条“通道电线”的捆包。然而,[密集电缆](../items-blocks-machines/cables.md#dense-cable)能够支持
至 32 频道。唯一能够传输 32 的其他装置是<ItemLink id="me_p2p_tunnel" />
和[量子网络桥](../items-blocks-machines/quantum_bridge.md)。每次一个装置使用一个频道, 想象一下从
这显然意味着"电线" 无法在线下更远的地方使用

<GameScene zoom="7" interactive={true}>
  <ImportStructure src="../assets/assemblies/channel_demonstration_1.snbt" />

  <LineAnnotation color="#33ff33" from="1 .4 .7" to="2.4 .4 .7" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="1 .6 .7" to="2.4 .6 .7" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="1 .4 .6" to="2.6 .4 .6" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="1 .6 .6" to="2.6 .6 .6" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="1 .6 .6" to="2.6 .6 .6" alwaysOnTop={true}/>

  <LineAnnotation color="#33ff33" from="2.4 .6 .7" to="2.4 .6 1.5" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="2.4 .4 .7" to="2.4 .4 1.5" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="2.6 .6 .6" to="2.6 .6 1.5" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="2.6 .4 .6" to="2.6 .4 1.5" alwaysOnTop={true}/>

  <LineAnnotation color="#33ff33" from="2.1 .6 1.5" to="2.4 .6 1.5" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="2.6 .4 1.5" to="2.9 .4 1.5" alwaysOnTop={true}/>

  <LineAnnotation color="#33ff33" from="2.6 .6 1.5" to="2.6 .9 1.5" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="2.4 .1 1.5" to="2.4 .4 1.5" alwaysOnTop={true}/>

  <LineAnnotation color="#33ff33" from="1 .6 .4" to="3.5 .6 .4" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="1 .4 .4" to="3.5 .4 .4" alwaysOnTop={true}/>

  <LineAnnotation color="#33ff33" from="3.5 .6 .4" to="3.5 .9 .4" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="3.5 .1 .4" to="3.5 .4 .4" alwaysOnTop={true}/>

  <LineAnnotation color="#33ff33" from="1 .6 .3" to="1.5 .6 .3" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="1 .4 .3" to="1.5 .4 .3" alwaysOnTop={true}/>

  <LineAnnotation color="#33ff33" from="1.5 .6 .3" to="1.5 .9 .3" alwaysOnTop={true}/>
  <LineAnnotation color="#33ff33" from="1.5 .1 .3" to="1.5 .4 .3" alwaysOnTop={true}/>

  <LineAnnotation color="#ff3333" from="3.5 .5 .5" to="5.5 .5 .5" alwaysOnTop={true}>
  电缆里的所有 8 个频道都被使用过 所以车道上没有  
  </LineAnnotation>

  <LineAnnotation color="#993333" from="1 .5 .5" to="1.25 .5 .5" alwaysOnTop={true}/>
  <LineAnnotation color="#993333" from="1.5 .5 .5" to="1.75 .5 .5" alwaysOnTop={true}/>
  <LineAnnotation color="#993333" from="2 .5 .5" to="2.25 .5 .5" alwaysOnTop={true}/>
  <LineAnnotation color="#993333" from="2.5 .5 .5" to="2.75 .5 .5" alwaysOnTop={true}/>
  <LineAnnotation color="#993333" from="3 .5 .5" to="3.25 .5 .5" alwaysOnTop={true}/>

  <DiamondAnnotation pos="3.6 0.5 0.5" color="#ff0000">
        电缆里的所有 8 个频道都被使用过 所以车道上没有
    </DiamondAnnotation>

  <IsometricCamera yaw="15" pitch="30" />
</GameScene>

一种容易了解如何使用和通过网络途径的渠道的方法是使用[智能电缆](../items-blocks-machines/cables.md)中显示频道的路径和使用。

通道每反向的节点, 将消耗 1⁄128 ae/t 的 1 y 128 ae / t, 这意味着
添加 a<ItemLink id="controller" />a a
网络 8 设备, 超过 96 节点, 您的电源使用实际上可能
因为它改变了分配渠道的方式,从而降低了电力消耗。

值得注意的是,**更衣人没有做 与 CE CECOLOR**,所有电缆颜色都使电缆无法连接。

## 频道运行

使用<ItemLink id="controller" />,
它们首先走最短的路线,通过邻近的机器到最近的[普通有线](../items-blocks-machines/cables.md)
(玻璃、蒙面玻璃或智能玻璃)。然后他们走最短的路线穿过普通电缆,到最近的[密集电缆](../items-blocks-machines/cables.md)
(密度或密度智能)。然后他们走最短的路径 通过密密电缆到<ItemLink id="controller" />.
如果最短的路径已经达到极限,有些[设备](devices.md)可能得不到所需的渠道,使用
彩色电缆,有线锚和隧道 对你有利 以确保你的频道走你想要的道路

例如,在这种情况下,有些驱动器得不到频道,因为尽管电缆容量足够,但
频道尝试走最短的路, 超载一些电缆, 而留下其他空的。

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/channel_path_length_issue.snbt" />

  <LineAnnotation color="#33ff33" from="3 .5 1.4" to="0.4 0.5 1.4" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="0.4 .5 1.4" to="0.4 0.5 3.6" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="0.4 0.5 3.6" to="1.4 0.5 3.6" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="1.4 0.5 3.6" to="1.4 0.5 5" alwaysOnTop={true} thickness="0.05"/>

  <LineAnnotation color="#33ff33" from="3 0.5 3.6" to="1.6 0.5 3.6" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="1.6 0.5 3.6" to="1.6 0.5 5" alwaysOnTop={true} thickness="0.05"/>

  <LineAnnotation color="#ff3333" from="3 .5 1.6" to="0.6 .5 1.6" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#ff3333" from="0.6 .5 1.6" to="0.6 .5 3.4" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#ff3333" from="0.6 .5 3.4" to="1.4 .5 3.4" alwaysOnTop={true} thickness="0.05"/>

  <LineAnnotation color="#ff3333" from="3 .5 3.4" to="1.6 .5 3.4" alwaysOnTop={true} thickness="0.05"/>

  <BoxAnnotation color="#dddddd" min="1.2 0.2 3.2" max="1.8 0.8 3.8" alwaysOnTop={true} thickness="0.05">
        超过 8 个频道试图通过这里,所以有些被切断。
  </BoxAnnotation>

  <IsometricCamera yaw="90" pitch="90" />

</GameScene>

可以通过更仔细地限制路径通道可以采取的途径来解决这个问题。网络应该像树一样。(或类似树状).
应尽量减少循环和模棱两可的通道。

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/channel_path_length_issue_fix.snbt" />

  <LineAnnotation color="#33ff33" from="3 .5 1.4" to="0.4 0.5 1.4" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="0.4 .5 1.4" to="0.4 0.5 5.6" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="0.4 0.5 5.6" to="1 0.5 5.6" alwaysOnTop={true} thickness="0.05"/>

  <LineAnnotation color="#33ff33" from="3 0.5 3.6" to="1.6 0.5 3.6" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="1.6 0.5 3.6" to="1.6 0.5 5" alwaysOnTop={true} thickness="0.05"/>

  <IsometricCamera yaw="90" pitch="90" />

</GameScene>

## 特设网络网

没有网络的网络<ItemLink id="controller" />
被视为 Ad-Hoc, 可用设备支持多达 8 个频道。
一旦超过 8 个装置 网络频道使用装置将关闭
您可以删除设备,也可以添加<ItemLink id="controller" />.

与控制网络不同[智能电缆](../items-blocks-machines/cables.md)在特设网络上显示数字的
而不是通过该具体电缆流通的频道数量。

在使用特设网络时,每个装置将
使用 1 个频道网络宽广,这与<ItemLink id="controller" />基于
最短路线。

## 设计的设计

如前文所述[频道路由](channels.md#channel-routing),它最好用树状结构来设计你的网络, 用密电缆从控制器中分流,固定电缆。
密密的、密布的,[设备](../ae2-mechanics/devices.md)常规电缆上 8 或 8 小组。

以下是一个不采取行动的例子:

沿着通道的路径,

1. 我们被困在 8 个频道 因为驱动器就像正常的电缆
然而,既然我们在这里没有使用智能电缆 我们看不到有多少频道在使用。
2. 驱动器要有一个频道
还剩 7 个频道
3. 两个频道到终点站
还有 5 个频道
4. 继续右侧, 接口取另一个频道。
剩下 4 个频道。
5. 1 个频道到样板供应器.
还有 3 个频道
6. 继续右转,1 个频道到输入总线.
只剩两个频道了
7. 样板供应器喂养组装配者晶簇只得到两个渠道,因此其中两个样板供应器得不到渠道。

最终错误在于堵塞频道, 而不是想如何分配频道。

<GameScene zoom="4" interactive={true}>
  <ImportStructure src="../assets/assemblies/bad_network_structure.snbt" />

<LineAnnotation color="#33ff33" from="6.5 .5 1.5" to="6 .5 1.5" alwaysOnTop={true} thickness="0.4">
  32 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="6 .5 1.5" to="5.5 .5 1.5" alwaysOnTop={true} thickness="0.2">
  8 个渠道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="5.5 .5 1.5" to="5.5 1.5 1.5" alwaysOnTop={true} thickness="0.1">
  2 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="5.5 .5 1.5" to="5.5 .3 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="5.5 1.5 1.5" to="5.5 2.5 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="5.5 2.5 1.5" to="5.5 2.5 1.1" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="5.5 .5 1.5" to="4.5 .5 1.5" alwaysOnTop={true} thickness="0.158">
  5 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="4.5 .5 1.5" to="4.5 .3 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="4.5 .5 1.5" to="4.5 1.5 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="4.5 .5 1.5" to="3.5 .5 1.5" alwaysOnTop={true} thickness="0.122">
  3 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="3.5 .5 1.5" to="3.5 2.5 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="3.5 2.5 1.5" to="3.7 2.5 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="3.5 .5 1.5" to="1.5 .5 1.5" alwaysOnTop={true} thickness="0.1">
  2 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="1.5 0.5 1.5" to="1.5 0.3 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="1.5 0.5 1.5" to="0.5 0.5 1.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#33ff33" from="0.5 0.5 1.5" to="0.5 0.5 0.5" alwaysOnTop={true} thickness="0.071">
  1 个频道
</LineAnnotation>

<LineAnnotation color="#ff3333" from="0.5 1.5 1.5" to="0.5 1.3 1.5" alwaysOnTop={true} thickness="0.071">
  无频道
</LineAnnotation>

<LineAnnotation color="#ff3333" from="1.5 1.5 0.5" to="1.5 1.3 0.5" alwaysOnTop={true} thickness="0.071">
  无频道
</LineAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

---

以下是一个良好结构的例子:

<GameScene zoom="2.5" interactive={true}>
  <ImportStructure src="../assets/assemblies/treelike_network_structure.snbt" />

    <BoxAnnotation color="#dddddd" min="6.9 0 4.9" max="9.1 4 7.1" thickness="0.05">
        注意模式样板供应器分为 8 类,8 组。
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="5 4 4" max="8 5 5" thickness="0.05">
        两条正常的电缆 连接了所有频道 意味着你需要一个密闭的电报
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="5 0 13" max="8 1 14" thickness="0.05">
        使用不同的电缆颜色防止相邻电缆连接。
    </BoxAnnotation>


  <IsometricCamera yaw="315" pitch="30" />
</GameScene>

## 频道模式

AE2 10.0.0 用于 Minecraft 1.18 提出新的备选方案,以改变 AE2 频道在你的世界里的行为。
常规部分有一个新的配置选项(`channels`)控制此选项和新游戏
操作器命令,操作员可以从游戏中更改模式和配置。命令是`/ae2 channelmode <mode>`
修改和修改`/ae2 channelmode`以显示当前模式。当模式在游戏中被更改时,所有现有网格都将
重新启动并立即使用新模式。

这恢复并改进了现有备选方案,Minecraft 1.12 和提出更好的备选办法
球员们只是想要 更低调的游戏 但是不想让机械师完全消失

下表列出了配置文件和命令中可用的模式。

| 设置布设    | 说明                                                                                                                                                                                                                               |
| ---------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `default`  | 整个网站所描述的有线和特设网络频道能力的标准模式                                                                                                                           |
| `x2`       | 所有频道能力翻一番(16 条正常电缆,64 条密集电缆 特别热电网支持 16 个频道)                                                                                                                           |
| `x3`       | 所有频道能力增加两倍(正常有线 24 条,密集有电缆 92 条 临时网支持 24 个频道)                                                                                                                           |
| `x4`       | 所有频道能力翻四番(正常电缆 32 条,密集电缆 128 条 临时网络支持 32 个频道)                                                                                                                       |
| `infinite` | 取消所有频道限制。主计长仍然减少电网的电力消耗*明显*。智能电缆只会切换完全关闭的(没有传送频道)完全开着(1 个或 1 个以上通道). |