package io.github.teamgensouspark.grimoireofpatchouli.danmaku;

import io.github.teamgensouspark.grimoireofpatchouli.libs.ModSubEntity;
import io.github.teamgensouspark.kekkai.danmaku.subentity.SubEntityBase;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;

public class GoPSubEntityType<T extends SubEntity> extends SubEntityBase<T> {

    public GoPSubEntityType(String name, Class<T> subentity) {
        super(name, subentity);

        ModSubEntity.DANMAKU_SUBENTITYTYPE.add(this);
    }

}
