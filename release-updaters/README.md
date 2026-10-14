# 独立增量更新器

这四个脚本是独立发布资产，不会被打入 `.mrpack` 或服务端 ZIP。首次使用时复制对应脚本到客户端实例根目录或服务端根目录，然后执行：

```text
update-dimensionworks-client.sh       # macOS / Linux 客户端
update-dimensionworks-client.bat      # Windows 客户端
update-dimensionworks-server.sh       # macOS / Linux 服务端
update-dimensionworks-server.bat      # Windows 服务端
```

脚本支持 `--release vX.Y.Z`、`--package <本地完整包>`、`--url <完整包 URL>` 和 `--help`。不带参数时查询 `szx-jn/DimensionWorks` 的 GitHub Latest Release；更新器读取发行版的独立 TSV 清单，按摘要只下载或复制变化文件，并删除旧状态中已经不再属于目标版本的受管文件。

客户端保留 `saves/`、日志、崩溃报告、截图和启动器私有数据；服务端保留世界、EULA、`server.properties`、JVM 参数、白名单、封禁、用户缓存和运行日志。服务端已存在的保留文件不会被新包覆盖。状态和事务日志位于 `.dimensionworks-update/`，成功后只保留状态文件，失败时保留未完成回滚所需的备份。

Shell 更新器需要系统 `bash`、`curl` 或 `wget`、`unzip` 和 `shasum`/`sha256sum`。Batch 更新器需要 Windows PowerShell；脚本会在执行前复制自身，避免覆盖正在运行的 `.bat`。
