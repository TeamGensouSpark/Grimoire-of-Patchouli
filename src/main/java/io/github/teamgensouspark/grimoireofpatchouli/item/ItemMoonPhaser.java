package io.github.teamgensouspark.grimoireofpatchouli.item;

import arekkuusu.grimoireofalice.api.recipes.MoonPhase;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemMoonPhaser extends ItemBase {

    public ItemMoonPhaser(String name) {
        super(name, true);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote && !worldIn.isDaytime()) {
            TextComponentString text = new TextComponentString(
                    I18n.format(
                            String.format("moonphase.%s.name", MoonPhase.values()[worldIn.getMoonPhase()].toString())));
            playerIn.sendMessage(text);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
