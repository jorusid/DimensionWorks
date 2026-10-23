StartupEvents.registry('item', event => {
  event.create('mineral_residue')
    .displayName(Text.translate('item.kubejs.mineral_residue'))
    .tooltip(Text.translate('item.kubejs.mineral_residue.tooltip'))
    .maxStackSize(64)
    .texture('kubejs:item/mineral_residue')
})
