package io.github.teamgensouspark.grimoireofpatchouli.item;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import io.github.teamgensouspark.grimoireofpatchouli.creativetabs.GoPTabs;
import io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBase extends Item {
    String name, tootipKey;

    public ItemBase(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(GoPTabs.GOPTAB);

        this.name = name;
        this.tootipKey = String.format("item.%s.tooltip", name);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (I18n.hasKey(tootipKey)) {
            tooltip.addAll(Arrays.asList(I18n.format(tootipKey).split("/n")));
        }

        if (I18n.hasKey(tootipKey.concat(".more")) && !Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.addAll(Arrays.asList(I18n.format("gop.tooltip.showmore").split("/n")));
        }

        if (I18n.hasKey(tootipKey.concat(".more")) && Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.clear();
            tooltip.addAll(Arrays.asList(I18n.format(tootipKey.concat(".more")).split("/n")));
        }
    }

}
