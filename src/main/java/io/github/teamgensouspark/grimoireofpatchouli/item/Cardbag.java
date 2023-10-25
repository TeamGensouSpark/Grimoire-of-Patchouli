package io.github.teamgensouspark.grimoireofpatchouli.item;

import io.github.teamgensouspark.kekkai.utils.KekkaiRegistry;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.item.ItemSpellcard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Cardbag extends ItemBase {
    public Cardbag(String name) {
        super(name);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.addItemStackToInventory(ItemSpellcard
                .createStack(KekkaiRegistry.getRandomObject(Spellcard.class)));
        if (!playerIn.isCreative()) {
            playerIn.getHeldItem(handIn).shrink(1);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
