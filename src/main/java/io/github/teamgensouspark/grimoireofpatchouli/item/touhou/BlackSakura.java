package io.github.teamgensouspark.grimoireofpatchouli.item.touhou;

import io.github.teamgensouspark.grimoireofpatchouli.item.TouhouSword;
import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import io.github.teamgensouspark.kekkai.danmaku.KekkaiDanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibSubEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BlackSakura extends TouhouSword {

    public BlackSakura(String name) {
        super(name, TouhouCharacter.YOUMU_KONPAKU);
    }

    @Override
    public float getAttackDamage() {
        return 9.9f;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof EntityMob) {
            EntityMob mob = (EntityMob) entity;
            if (mob.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
                mob.setFire(3);
                mob.setHealth(mob.getHealth() * 0.95f);
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        KekkaiDanmakuCreationHelper.createWideShot(DanmakuBuilder.getBuilderWithEntity(playerIn)
                .setShot(LibShotData.SHOT_FIRE.setMainColor(AtomColors.ATOM_COLOR_WHITE)
                        .setSubEntity(LibSubEntities.FIRE).setDamage(4))
                .build(), 5, 40f, 10f, 1.3d);
        playerIn.getCooldownTracker().setCooldown(this, 200);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
