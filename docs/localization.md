# 简体中文本地化

DimensionWorks 使用客户端专用资源 Mod `dimensionworks_localization` 补全第三方 Mod 的简体中文内容。

## 定位

汉化只覆盖当前锁定 Jar 版本中缺失的部分，不替换第三方已经提供的中文。第一阶段的范围固定为 52 个命名空间的 2,333 个语言键，以及 AE2、ExtendedAE 和车万女仆共 206 个手册页面。

服务端专用 LuckPerms、Mod 元数据、硬编码英文和无法通过资源覆盖替换的文本不在范围内。所有覆盖内容均为本仓库原创译文，第三方英文源和手册内容遵循各自许可证，不修改第三方源码。

## 资源规则

语言键放在 `mods/dimensionworks-localization/assets/<命名空间>/lang/zh_cn.json`。GuideME 使用 `_zh_cn/` 页面覆盖；Patchouli 使用 `zh_cn/` 页面覆盖。源英文为空的键保留为空值，第三方已有中文的键不得重复打包。

术语规则要求保留 `AE2`、`ME`、`FE`、`RF`、`SU`、`RPM`、`mB`、`NBT`、`GUI`、`JEI`、`EMI`、`HUD` 等缩写，周围普通词正常翻译，例如 `ME Drive` 译为 `ME 驱动器`。占位符、颜色代码、换行和 Markdown 结构必须与英文源一致。

当前 `0.1.0` 的手册译文由机器翻译与术语后处理生成，已通过结构和覆盖校验，仍需后续逐页人工审校。

## 验证与更新

在仓库根目录运行：

```sh
python3 scripts/check_localization.py
```

校验器读取 DimensionWorks 本地实例中全部第三方 Jar，检查语言键和 GuideME/Patchouli 页面覆盖率，并拒绝无源键、重复键、占位符变化、缺页、未知覆盖和已经过期的冗余覆盖。仓库打包预检 `scripts/pack_hook.py` 会自动执行该检查。

翻译基线跟随本地实例的固定 Jar 版本。升级来源 Mod 后，先运行校验器查看新增键、删除键和已被第三方补齐的条目，再更新资源并完成构建。
