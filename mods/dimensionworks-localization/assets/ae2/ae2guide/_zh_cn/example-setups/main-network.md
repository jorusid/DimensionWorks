---
navigation:
  parent: example-setups/example-setups-index.md
  title: 示例“ 主网络”
  icon: controller
---

# 示例“ 主网络”

许多其它设置都引用了“主网络”。您也可以问一下这些是如何的[设备](../ae2-mechanics/devices.md)来来
将两者合并成一个功能系统。下面举个例子:

<GameScene zoom="2.5" interactive={true}>
  <ImportStructure src="../assets/assemblies/treelike_network_structure.snbt" />

    <BoxAnnotation color="#dddddd" min="3.9 0 1.9" max="9.1 5 7.1" thickness="0.05">
        大量模式样板供应器和装配者为合成、石块切割和铁匠模式提供了大量空间。
        核对板模式允许样板供应器同时使用多个装配器,同时保持压缩。
        8 人小组使得频道无法走错路。
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="3.9 0 9.9" max="5.1 3 12.1" thickness="0.05">
        一些机器,用管道子网 将输出输入到样板供应器。
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="-0.1 0 8.9" max="1.1 3 13.1" thickness="0.05">
      一些终端和各种工具的 DOODADDs。(你可能想要一个合成终端,而不是常规终端_和_合成终端)
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="-0.1 0 -0.1" max="2.1 3 8.1" thickness="0.05">
      一组编织的 CPU。少数几个存储量较大,有些存储数量较少。
      您可能想要在实际设置中有更多的共同处理器, 但对于这个场景来说,这将有点大。
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="5.9 0 13.9" max="7.1 1 15.1" thickness="0.05">
      你的控制器应该在你的基地中间 可能比这个大点
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="11.9 0 7.9" max="13.1 4 13.1" thickness="0.05">
        各种存储方法,包括驱动器或存储总车,8 人组通知所有。
    </BoxAnnotation>

    <BoxAnnotation color="#dddddd" min="10.9 0 0.9" max="13.1 2 7.1" thickness="0.05">
        各种存储方法,包括驱动器或存储总车,8 人组通知所有。
    </BoxAnnotation>

  <IsometricCamera yaw="315" pitch="30" />
</GameScene>
