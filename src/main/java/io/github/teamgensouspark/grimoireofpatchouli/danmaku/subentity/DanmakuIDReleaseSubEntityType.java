package io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity;

import io.github.teamgensouspark.grimoireofpatchouli.libs.ModSubEntity;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityTypeDefault;

public class DanmakuIDReleaseSubEntityType extends SubEntityTypeDefault{

    public DanmakuIDReleaseSubEntityType(String name) {
        super(name);

        ModSubEntity.DANMAKU_SUBENTITYTYPE.add(this);
    }

   public SubEntity instantiate() {
      return new DanmakuIDReleaseSubEntity();
   }
    
}
