package io.github.teamgensouspark.grimoireofpatchouli.item;

import io.github.teamgensouspark.grimoireofpatchouli.creativetabs.GoPTabs;
import io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(GoPTabs.GOPTAB);

        ModItems.ITEMS.add(this);
    }
}
