---
navigation:
  parent: items-blocks-machines/items-blocks-machines-index.md
  title: 监视器
  icon: storage_monitor
  position: 210
categories:
- devices
item_ids:
- ae2:storage_monitor
- ae2:conversion_monitor
---

# 监视器

<GameScene zoom="8" background="transparent">
<ImportStructure src="../assets/assemblies/monitors.snbt" />
<IsometricCamera yaw="195" pitch="30" />
</GameScene>

监视器允许可视化和与单个物品或流体类型互动,而没有打开 GUI.

显示器将继承[电缆](cables.md)它们是挂在天上的。

如果显示器在下层或天花板上,您可以使用<ItemLink id="certus_quartz_wrench" />.

他们是[电缆子部件](../ae2-mechanics/cable-subparts.md).

# 存储监视器

将显示物品或液体及其数量。把它们放在农场旁边或其它东西...

do do do*否*需要 a[频道](../ae2-mechanics/channels.md).

密钥集 :

*   用右键单击一物品或用液体容器双击两拳,将显示器设定到该物品/液体上。
*   右键单击空手来清除显示器。
*   用空手点击右- 右键键锁定监视器。

## 用途

<RecipeFor id="storage_monitor" />

# 转换监视器

转换监视器与存储监视仪相似, 但允许您插入或提取其配置的项。

如果配置的物品是[自动自制](../ae2-mechanics/autocrafting.md)没有任何动物存储在仓库中,而且可以取
反之,物品将打开 UI,以指定要绘制的金额。

*do do do*需要 a[频道](../ae2-mechanics/channels.md).

附加按键集 :

*   左键单击以提取配置的物品堆叠, 如果没有在存储中, 则请求该物品的手合成。
*   用右键单击任何物品以插入该物品。
*   右键单击空手键插入从您的目录中配置的全部物品。

## 用途

<RecipeFor id="conversion_monitor" />
