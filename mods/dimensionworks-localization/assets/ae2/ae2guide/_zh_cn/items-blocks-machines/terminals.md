---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 终端码头
  icon: crafting_terminal
  position: 210
categories:
- devices
item_ids:
- ae2:terminal
- ae2:crafting_terminal
- ae2:pattern_encoding_terminal
- ae2:pattern_access_terminal
---

# 终端码头

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/terminals.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

期间<ItemLink id="pattern_provider" />,<ItemLink id="import_bus" />赛斯,<ItemLink id="storage_bus" />和诸如此类的
一种主要方法是:AE2 终端站是主要方法,AE2
网络与*您 您 的 您*。有若干不同功能的变体。

终端将继承[电缆](cables.md)它们是挂在天上的。

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

## 终端安置

由于终端往往是第一个[下分部分](../ae2-mechanics/cable-subparts.md)某人可能会找到,
通常会弄错了,然后倒置终端。这里的例子说明了应该做什么和不该做什么:

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/assemblies/terminal_placement.snbt" />
  <IsometricCamera yaw="195" pitch="30" />

  <LineAnnotation color="#ff3333" from="2.5 .5 .5" to="4.5 2.5 .5" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#ff3333" from="2.5 2.5 .5" to="4.5 .5 .5" alwaysOnTop={true} thickness="0.05"/>

  <LineAnnotation color="#33ff33" from="-.5 2.5 .5" to="1 .5 .5" alwaysOnTop={true} thickness="0.05"/>
  <LineAnnotation color="#33ff33" from="1 .5 .5" to="1.5 1 .5" alwaysOnTop={true} thickness="0.05"/>
</GameScene>

你还有一个终端和能源接收器,但除了现在的终端是正确的方式 绕圈和实际上
连接到网络, 并且都适合在一个较小的空间。

<a name="terminal-ui"></a>

# 终端

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/blocks/terminal.snbt" />
  <IsometricCamera yaw="180" />
</GameScene>

您的基本终端, 允许您查看并访问您的[网络的存储](../ae2-mechanics/import-export-storage.md)
并请求您提供[自动自制](../ae2-mechanics/autocrafting.md)设置。

## UI 界面

基本终端 UI 有几部分

中心部分允许访问您的网络存储。您可以把东西放进去, 并拿出来。有多个
鼠标/ 按键快捷键 :

*   左键单击键抓一个堆叠,右拳抓半堆。
*   如果物品或液体或其他物质能够[自动自制](../ae2-mechanics/autocrafting.md),
    任何你注定要"挑块"的东西(通常单击中键)设置一个 UU 界面以指定要绘制的量。您也可以输入公式,例如`3*64/2`,
    或型号`=32`只计算存储到 32 个所需的物品数量。
*   控股传输将冻结放在那里的显示物品,当数量变化或新物品进入系统时,阻止它们进行重组。
*   用桶或其他液体容器右敲一拳或以其他液体集装箱将液体放入,用左键单击一滴液体装入码头
    空液体容器将取出液体。

左侧区域设置按钮以:

*   依名称、模式和数量等不同属性排序
*   视图存储、可手动或两者兼有
*   视图项、流体或两者
*   更改排序顺序
*   打开详细的终端设置窗口
*   更改终端界面的高度

右边有可供<ItemLink id="view_cell" />

中心区域右上方(锤子按钮)升起[自动自制](../ae2-mechanics/autocrafting.md)状态状况状态
UI , 允许您看到您的汽车的进度和每种[合成 CPU](crafting_cpu_multiblock.md)正在做。

## 用途

<RecipeFor id="terminal" />

<a name="crafting-terminal-ui"></a>

# 合成终端

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/blocks/crafting_terminal.snbt" />
  <IsometricCamera yaw="180" />
</GameScene>

合成终端类似于常规终端, 具有所有相同的设置和区段, 但加上一个自动生成格格
重新填充自[网络存储](../ae2-mechanics/import-export-storage.md)。在按下输出时要小心 !

您应该将终端升级为合成终端尽快。

## UI 界面

合成终端与正常终端具有相同的 UI,但中间加了一个编织网格。

另有两个按钮,用于将编织的网格空入网络存储或您的库存。

## 用途

<RecipeFor id="crafting_terminal" />

<a name="pattern-encoding-terminal-ui"></a>

# 样板编码终端

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/blocks/pattern_encoding_terminal.snbt" />
  <IsometricCamera yaw="180" />
</GameScene>

样板编码终端类似于常规终端,具有所有相同的设置和区段,但加
[样式](patterns.md)编码界面。它看起来类似于合成终端暗号,但这个编织的电网实际上没有
手合成。

除了一个合成终端.

## UI 界面

合成终端与正常终端站具有相同的 UI ,并添加[样式](patterns.md)编码界面。

模式编码接口有几个部分:

要插入的空格<ItemLink id="blank_pattern" />.

用于编码图案的箭头

编码模式的空格。设置一个已经在此空档编码的样式, 以便编辑它, 然后单击“ 编译” 箭头。

替换要编码的图案类型的权利上的 4 选项卡

*   手工合成
*   处理
*   史密斯
*   石块切割

中心用户界面的变化取决于要编码的图案类型:

*   绘图模式 :
    *   左单击或拖放 JEI/ REI 构成配方的原料。右键单击可移除原料。
    *   启用基基初始化使诸如从任何木板类型中绘制棍棒之类的东西得以使用。这只应该使用
        绝对必要的时候
    *   使用流体替代系统可以使用存储的液体代替液桶。
    *   也可以直接编码一个模式,从 JEIREI 食谱屏幕

*   在处理模式中 :
    * 左键或右键单击或拖放 JEI 说明该食谱的投入和产出的原料。
    * 用液体容器右键单击(象桶或液罐一样)将液体作为原料,而不是桶或罐体物品。
    * 持有堆叠时,左键单击键将整个堆堆放位置设置,右键点击右键单击将一个项放置。
        删除整个堆栈,右键单击以将堆叠减少 1。无论您是否有义务选择块(通常单击中键)
        让您指定物品或液体的确切数量。
    * 输出槽有一个主输出和空间, 可供您想要知道的 自动合成算法。
    * 输入和输出槽滚动, 这样您就可以拥有 81 种不同原料和 26 种次级输出
    * 也可以直接编码一个模式,从 JEIREI 食谱屏幕

*   铁匠和石块切割模式 UI 分别与铁工桌和石头切割器类似。

## 用途

<RecipeFor id="pattern_encoding_terminal" />

<a name="pattern-access-terminal-ui"></a>

# 样板管理终端

<GameScene zoom="6" background="transparent">
  <ImportStructure src="../assets/blocks/pattern_access_terminal.snbt" />
  <IsometricCamera yaw="180" />
</GameScene>

样板管理终端解决一个具体问题:<ItemLink id="pattern_provider" />
和<ItemLink id="molecular_assembler" />,您无法实际访问样板供应器插入新模式。此外,
也许你很懒懒,不想走过基地 插入[样式](patterns.md)。样板管理终端
允许访问网络上的所有模式样板供应器。

## UI 界面

此终端对所有其他终端有不同的 UI。

它为终端高度设置了设置, 并显示哪些模式样板供应器。

终端中的每行对应一个特定样板供应器.

终端中样板供应器的样式设置器按它们连接到哪个区块或您给它们取了什么名字进行分类(或在一个宫殿里,或
具有 a 和<ItemLink id="name_press" />).

## 用途

<RecipeFor id="pattern_access_terminal" />
