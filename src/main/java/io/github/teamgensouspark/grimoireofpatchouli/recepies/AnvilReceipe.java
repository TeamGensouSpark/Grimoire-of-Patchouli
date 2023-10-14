package io.github.teamgensouspark.grimoireofpatchouli.recepies;

import arekkuusu.grimoireofalice.common.item.ModItems;
import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import io.github.teamgensouspark.grimoireofpatchouli.utils.ModCompat;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class AnvilReceipe {
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        if (ModCompat.GOA.isLoaded()) {
            if (event.getLeft().getItem() == ModItems.HAKUROUKEN && event.getRight().getItem() == ModItems.ROUKANKEN) {
                ItemStack output = new ItemStack(
                        io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems.BLACK_SAKURA);
                output.addEnchantment(Enchantments.SMITE, 10);
                event.setOutput(output);
                event.setCost(30);

            }
        } else {
            if (event.getLeft().getItem() == Items.DIAMOND_SWORD && event.getRight().getItem() == Items.NETHER_STAR) {
                ItemStack output = new ItemStack(
                        io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems.BLACK_SAKURA);
                output.addEnchantment(Enchantments.SMITE, 10);
                event.setOutput(output);
                event.setCost(30);

            }
        }
    }
}
