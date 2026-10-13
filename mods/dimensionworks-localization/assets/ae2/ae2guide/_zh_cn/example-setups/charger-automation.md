---
navigation:
  parent: example-setups/example-setups-index.md
  title: 充电自动
  icon: charger
---

# 充电自动

请注意,由于此用途 a<ItemLink id="pattern_provider" />,它意指融入[自动自制](../ae2-mechanics/autocrafting.md)
设置。如果仅想要自动化 a<ItemLink id="charger" />独立,用子和箱子之类的东西

自动调<ItemLink id="charger" />很简单。A<ItemLink id="pattern_provider" />将原料推入充电器,然后[管道子网](pipe-subnet.md)
或其它项管道将结果推回样板供应器。

<GameScene zoom="6" interactive={true}>
  <ImportStructure src="../assets/assemblies/charger_automation.snbt" />

<BoxAnnotation color="#dddddd" min="1 0 0" max="2 1 1">
        (1)样板供应器:在其默认配置中,使用相关处理模式。同时为充电器提供电源。

        ![充电模式](../assets/diagrams/charger_pattern_small.png)
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="0 1 0" max="1 1.3 1">
        (2)输入总线:在其默认配置中。
  </BoxAnnotation>

<BoxAnnotation color="#dddddd" min="1 1 0" max="2 1.3 1">
        (3)存储总线:在其默认配置中。
  </BoxAnnotation>

<DiamondAnnotation pos="4 0.5 0.5" color="#00ff00">
        转到主网络
    </DiamondAnnotation>

  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

## 配置

* <ItemLink id="pattern_provider" />(1)处于默认配置中,且相关<ItemLink id="processing_pattern" />.
  它还规定:<ItemLink id="charger" />与[能源](../ae2-mechanics/energy.md)因为它的行为就像[电缆](../items-blocks-machines/cables.md).
  
    ![充电模式](../assets/diagrams/charger_pattern.png)

* <ItemLink id="import_bus" />(2)默认配置。
* <ItemLink id="storage_bus" />(3)默认配置。

## 如何运作

1. <ItemLink id="pattern_provider" />将元素推进<ItemLink id="charger" />.
2. 充电者负责充电器
3. <ItemLink id="import_bus" />绿色亚网上的绿色子网将充电器的结果拉出来 并试图存储在
   [网络存储](../ae2-mechanics/import-export-storage.md).
4. 绿色子网上唯一的存储库是<ItemLink id="storage_bus" />中存储所产生的物项,样板供应器返回主网络
