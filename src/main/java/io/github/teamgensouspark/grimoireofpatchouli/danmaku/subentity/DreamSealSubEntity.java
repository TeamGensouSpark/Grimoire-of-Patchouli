package io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.RayTraceResult;

public class DreamSealSubEntity extends SubEntityDefault {
    @Override
    public DanmakuUpdate impactBlock(DanmakuState danmaku, RayTraceResult raytrace) {
        return super.impactBlock(danmaku, raytrace).addCallback(() -> {
            danmaku.world().createExplosion(null, danmaku.pos().x(), danmaku.pos().y(), danmaku.pos().z(), 1, false);
        });
    }
    @Override
    public DanmakuUpdate impactEntity(DanmakuState danmaku, RayTraceResult raytrace) {
        return super.impactEntity(danmaku,raytrace).addCallback(
            () -> {
                
            }
        );
     }
}
