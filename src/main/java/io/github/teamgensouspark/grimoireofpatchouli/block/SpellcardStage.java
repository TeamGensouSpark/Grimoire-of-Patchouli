package io.github.teamgensouspark.grimoireofpatchouli.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import io.github.teamgensouspark.kekkai.utils.ScalaJ;
import net.katsstuff.teamnightclipse.danmakucore.item.ItemSpellcard;
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.TouhouHelper;

public class SpellcardStage extends BlockBase {

    public SpellcardStage(String name) {
        super(Material.ROCK, name);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemheld = playerIn.getHeldItem(hand);
        if (itemheld.getItem() instanceof ItemSpellcard) {
            if (!playerIn.isCreative()) {
                itemheld.shrink(1);
            }
            if (!playerIn.world.isRemote) {
                EntityArmorStand tmp = new EntityArmorStand(worldIn);
                tmp.getEntityData().setInteger("_lifespan", ItemSpellcard.getSpellcard(itemheld).endTime());
                tmp.setInvisible(true);
                tmp.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                worldIn.spawnEntity(tmp);
                TouhouHelper.declareSpellcard(tmp, ScalaJ.option(playerIn), ItemSpellcard.getSpellcard(itemheld),
                        false, false);
            }
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}
