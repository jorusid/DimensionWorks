// DimensionWorks basic mineral propagation.
// A finite raw-mineral sample starts each line; renewable stone/carbon/clay inputs
// provide the carrier material. Every recipe consumes the sample and returns two
// samples, allowing the line to sustain itself while paying a continuous material cost.
const BASIC_MINERAL_RECIPES = 'dimensionworks_cave_factory:self_propagation/basic_minerals/'

function mineralRecipe(recipe, path) {
  return recipe.id(BASIC_MINERAL_RECIPES + path)
}

function expandMineralIngredients(inputs) {
  const expanded = []
  inputs.forEach(entry => {
    const match = typeof entry === 'string' ? /^(\d+)x (.+)$/.exec(entry) : null
    if (match) {
      for (let i = 0; i < Number(match[1]); i++) expanded.push(match[2])
    } else {
      expanded.push(entry)
    }
  })
  return expanded
}

ServerEvents.recipes(event => {
  const compacting = (output, inputs) =>
    event.recipes.create.compacting(output, expandMineralIngredients(inputs))

  // Common metals: stone-derived carriers plus mineral-specific additives.
  mineralRecipe(compacting('2x minecraft:raw_iron', [
    'minecraft:raw_iron',
    '2x minecraft:cobblestone',
    'minecraft:gravel'
  ]), 'iron/seeded_growth')

  mineralRecipe(compacting('2x minecraft:raw_copper', [
    'minecraft:raw_copper',
    '2x minecraft:gravel',
    'minecraft:calcite'
  ]), 'copper/seeded_growth')

  mineralRecipe(compacting('2x minecraft:raw_gold', [
    'minecraft:raw_gold',
    '2x minecraft:netherrack',
    'minecraft:quartz'
  ]), 'gold/seeded_growth')

  // Non-metallic minerals use renewable carriers, but have distinct costs.
  mineralRecipe(compacting('2x minecraft:coal', [
    'minecraft:coal',
    '2x minecraft:charcoal',
    'minecraft:gravel'
  ]), 'coal/seeded_growth')

  mineralRecipe(compacting('2x minecraft:redstone', [
    'minecraft:redstone',
    'minecraft:clay_ball',
    'minecraft:iron_nugget',
    'minecraft:flint'
  ]), 'redstone/seeded_growth')

  mineralRecipe(compacting('2x minecraft:lapis_lazuli', [
    'minecraft:lapis_lazuli',
    'minecraft:clay_ball',
    'minecraft:bone_meal',
    'minecraft:gravel'
  ]), 'lapis/seeded_growth')

  mineralRecipe(compacting('2x minecraft:quartz', [
    'minecraft:quartz',
    '2x minecraft:netherrack',
    'minecraft:soul_sand'
  ]), 'quartz/seeded_growth')
})
