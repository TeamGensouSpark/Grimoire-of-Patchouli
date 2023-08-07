package io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity;

import java.util.Random;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;

public class DreamSealSubEntity extends SubEntityDefault {
    private Random random = new Random();

    public DanmakuUpdate subEntityTick(DanmakuState danmaku) {
        if (danmaku.ticksExisted() % 5 == 0) {
            danmaku.world().spawnParticle(EnumParticleTypes.REDSTONE, danmaku.pos().x(), danmaku.pos().y(),
                    danmaku.pos().z(), 0d, 0d, 0d);
        }
        Vector3 newDirection = danmaku.direction();
        try {
            Entity entity = danmaku.world().getEntityByID(danmaku.user().get().getEntityData().getInteger("target_id"));
            newDirection = (Vector3) Vector3.directionToPos(danmaku.pos(), Vector3.fromEntityCenter(entity));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return super.subEntityTick(
                danmaku.copy(danmaku.entity().setDirection(newDirection), danmaku.extra(), danmaku.tracking()));
    }

    @Override
    public DanmakuUpdate impactBlock(DanmakuState danmaku, RayTraceResult raytrace) {
        return super.impactBlock(danmaku, raytrace).addCallback(() -> {
            danmaku.world().createExplosion(null, danmaku.pos().x(), danmaku.pos().y(), danmaku.pos().z(),
                    1 + random.nextFloat(), false);
        });
    }

    @Override
    public DanmakuUpdate impactEntity(DanmakuState danmaku, RayTraceResult raytrace) {
        return super.impactEntity(danmaku, raytrace).addCallback(
                () -> {
                    try {
                        EntityLivingBase livingBase = (EntityLivingBase) raytrace.entityHit;
                        livingBase.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 160));
                        livingBase.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 160, 2));
                        livingBase.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 160, 2));
                    } catch (Exception e) {
                    }
                });
    }
}
