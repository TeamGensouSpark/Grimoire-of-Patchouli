package io.github.teamgensouspark.grimoireofpatchouli.item;

import java.util.Random;

import io.github.teamgensouspark.grimoireofpatchouli.utils.Registries;
import net.katsstuff.teamnightclipse.danmakucore.item.ItemSpellcard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Cardbag extends ItemBase {
    protected static Object[] keys = null;
    protected static final Random rnd = new Random();

    public Cardbag(String name) {
        super(name);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (keys == null) {
            keys = Registries.SPELLCARDS.getKeys().toArray();
        }
        playerIn.addItemStackToInventory(ItemSpellcard
                .createStack(Registries.SPELLCARDS.getValue((ResourceLocation) keys[rnd.nextInt(keys.length)])));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
