package io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;

public class DanmakuIDReleaseSubEntity extends SubEntityDefault {

    @Override
    public DanmakuUpdate subEntityTick(DanmakuState danmakuState) {
        Vector3 newDirection = danmakuState.direction();
        if (danmakuState.ticksExisted() < 20) {
            newDirection = new Vector3(newDirection.toVec3d().rotateYaw(0.05f));
        }
        return super.subEntityTick(
                danmakuState.copy(danmakuState.entity().setDirection(newDirection), danmakuState.extra(),
                        danmakuState.tracking()));
    }
}
