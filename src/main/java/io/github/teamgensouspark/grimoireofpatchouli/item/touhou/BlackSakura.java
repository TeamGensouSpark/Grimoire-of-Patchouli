package io.github.teamgensouspark.grimoireofpatchouli.item.touhou;

import io.github.teamgensouspark.grimoireofpatchouli.item.TouhouSword;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

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

}
