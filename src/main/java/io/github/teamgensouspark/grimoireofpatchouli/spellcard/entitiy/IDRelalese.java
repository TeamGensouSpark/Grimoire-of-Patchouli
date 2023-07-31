package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity.DanmakuIDReleaseSubEntity;
import io.github.teamgensouspark.grimoireofpatchouli.libs.ModSubEntity;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import io.github.teamgensouspark.kekkai.example.MySpellCardEntity;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.katsstuff.teamnightclipse.danmakucore.javastuff.DanmakuCreationHelper;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class IDRelalese extends SpellcardEntity {

    public IDRelalese(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 5 == 0) {
            DanmakuCreationHelper.createCircleShot(
                    Quat.fromAxisAngle(Vector3.Forward(), 0F),
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_HEART.setSubEntity(ModSubEntity.IDRELEASE_SUBENTITYTYPE)).build(),
                    8,
                    0,
                    1d);
        }

    }

}
