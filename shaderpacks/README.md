# 光影来源

本目录不保存光影 ZIP。`manifest/shaderpacks.json` 固定记录官方来源、文件 ID 或版本 ID、大小和双哈希，`scripts/package_mrpack.py` 会把它们写入 `.mrpack` 的下载索引，启动器安装整合包时直接从原始发布位置获取。

| 本地名称 | 原始来源 |
| --- | --- |
| `ComplementaryUnbound_r5.9.3.zip` | [Modrinth: Complementary Shaders - Unbound r5.9.3](https://modrinth.com/shader/complementary-unbound/version/r5.9.3) |
| `photon_v1.3b.zip` | [Modrinth: Photon Shaders v1.3b](https://modrinth.com/shader/photon-shader/version/v1.3b) |
| `Sildur's Vibrant Shaders v1.51 Extreme-VL.zip` | [CurseForge: Sildur's Vibrant shaders v1.51 Extreme-VL](https://www.curseforge.com/minecraft/shaders/sildurs-vibrant-shaders/files/4688989) |
| `Chocapic13 V6 (Unzip it!).zip` | [CurseForge: Chocapic13' Shaders V6](https://www.curseforge.com/minecraft/shaders/chocapic13-shaders/files/2906904) |

Chocapic13 V6 官方文件本身是一个总包，内含 `High`、`Low`、`Lite`、`Medium`、`Ultra`、`Extreme` 六个预设。整合包保持原发布形态下载，安装后在游戏内先解压该文件，再选择需要的预设；此前仓库中的 High/Low 文件与总包内同名成员逐字节一致。
