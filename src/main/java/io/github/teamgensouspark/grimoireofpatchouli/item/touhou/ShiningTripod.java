package io.github.teamgensouspark.grimoireofpatchouli.item.touhou;

import java.util.Collections;

import io.github.teamgensouspark.grimoireofpatchouli.item.TouhouItem;
import io.github.teamgensouspark.kekkai.character.TouhouExCharacter;
import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ShiningTripod extends TouhouItem {

    public ShiningTripod(String name) {
        super(name, TouhouExCharacter.MEGUMU_IIZUNAMARU);
        
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        DanmakuCore.spawnDanmaku(Collections.singletonList(DanmakuBuilder.getBuilderWithEntity(playerIn)
                .setShot(LibShotData.SHOT_LASER.setMainColor(AtomColors.ATOM_COLORS_HELPER.randomColor())).build()
                .asEntity()));
        playerIn.getCooldownTracker().setCooldown(this, 10);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
