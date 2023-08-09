package io.github.teamgensouspark.grimoireofpatchouli.creativetabs;

import io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GoPTabs {
    public static final CreativeTabs GOPTAB = new CreativeTabs(CreativeTabs.getNextID(), "goptab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CARD_BAG);
        }
    };
}