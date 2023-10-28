package io.github.teamgensouspark.grimoireofpatchouli.recepies;

import arekkuusu.grimoireofalice.common.item.ModItems;
import io.github.teamgensouspark.grimoireofpatchouli.api.anvil.AnvilApi;
import io.github.teamgensouspark.grimoireofpatchouli.api.anvil.AnvilReceipe;
import io.github.teamgensouspark.grimoireofpatchouli.utils.ModCompat;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModAnvilReceipes {
    public static void init() {
        ItemStack BLACK_SAKURA = new ItemStack(
                io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems.BLACK_SAKURA);
        BLACK_SAKURA.addEnchantment(Enchantments.SMITE, 10);
        if (ModCompat.GOA.isLoaded()) {
            AnvilApi.regReceipe("black_sakura",
                    new AnvilReceipe().setCost(30).setShape(false)
                            .setLeft((stack) -> stack.getItem() == ModItems.HAKUROUKEN)
                            .setRight((stack) -> stack.getItem() == ModItems.ROUKANKEN).setResult(BLACK_SAKURA));
        } else {
            AnvilApi.regReceipe("black_sakura",
                    new AnvilReceipe().setCost(30).setShape(false)
                            .setLeft((stack) -> stack.getItem() == Items.DIAMOND_SWORD)
                            .setRight((stack) -> stack.getItem() == Items.NETHER_STAR).setResult(BLACK_SAKURA));
        }
    }
}
