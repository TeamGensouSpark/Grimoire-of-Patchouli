package io.github.teamgensouspark.grimoireofpatchouli.api.jei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.Patchouli;
import io.github.teamgensouspark.grimoireofpatchouli.api.anvil.AnvilApi;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;

@JEIPlugin
public class GoPJEIPlugin implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        Patchouli.logger.info("Start register JEI AnvilApi");
        Patchouli.logger.info(AnvilApi.getReceipes().values().toString());
        List<IRecipeWrapper> receipes = new ArrayList<>();
        AnvilApi.getReceipes().values()
                .forEach((receipe) -> receipes.add(registry.getJeiHelpers().getVanillaRecipeFactory().createAnvilRecipe(
                        receipe.display_left,
                        receipe.display_right,
                        Collections.singletonList(receipe.result))));
        registry.addRecipes(receipes, VanillaRecipeCategoryUid.ANVIL);
    }
}
