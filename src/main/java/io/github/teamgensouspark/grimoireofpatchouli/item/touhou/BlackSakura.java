package io.github.teamgensouspark.grimoireofpatchouli.item.touhou;

import org.lwjgl.input.Keyboard;

import io.github.teamgensouspark.grimoireofpatchouli.item.TouhouSword;
import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import io.github.teamgensouspark.kekkai.danmaku.KekkaiDanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibSubEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BlackSakura extends TouhouSword {

    public BlackSakura(String name) {
        super(name, TouhouCharacter.YOUMU_KONPAKU);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
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
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            KekkaiDanmakuCreationHelper.createWideShot(DanmakuBuilder.getBuilderWithEntity(playerIn)
                    .setShot(LibShotData.SHOT_FIRE.setMainColor(AtomColors.ATOM_COLOR_WHITE)
                            .setSubEntity(LibSubEntities.FIRE).setDamage(4))
                    .setMovementData(1.4)
                    .build(), 5, 40f, 10f, 1.3d);
            playerIn.getCooldownTracker().setCooldown(this, 180);
        } else {
            ItemStack stack = playerIn.getHeldItem(handIn);
            playerIn.setActiveHand(handIn);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entityLiving, int timeLeft) {
        if (entityLiving instanceof EntityPlayer && ((EntityPlayer) entityLiving).onGround) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            int timeUsed = getMaxItemUseDuration(stack) - timeLeft;
            if (timeUsed > 30) {
                timeUsed = 30;
            }
            double speed = timeUsed * 0.3;
            player.motionX = -Math.sin(Math.toRadians(player.rotationYaw)) * speed;
            player.motionZ = Math.cos(Math.toRadians(player.rotationYaw)) * speed;
            if (!player.capabilities.isCreativeMode) {
                player.addExhaustion(1.5F);
            }
        }
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 7000;
    }
}
