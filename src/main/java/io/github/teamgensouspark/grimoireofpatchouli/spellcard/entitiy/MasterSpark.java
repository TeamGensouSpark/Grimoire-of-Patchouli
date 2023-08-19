package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import java.util.Collections;

import io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku.ModSubEntity;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class MasterSpark extends SpellcardEntity {

    public MasterSpark(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() == 1) {
            DanmakuCore.spawnDanmaku(Collections.singletonList(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setMovementData(1.05d)
                            .setShot(LibShotData.SHOT_LASER.setDamage(20f).setSubEntity(ModSubEntity.MASTER_SPARK_SUBENTITYTYPE)
                                    .setEnd(200))
                            .build()
                            .asEntity()));
        }
    }

}
