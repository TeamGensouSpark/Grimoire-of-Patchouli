package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import io.github.teamgensouspark.grimoireofpatchouli.libs.ModSubEntity;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.LibColor;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.katsstuff.teamnightclipse.danmakucore.javastuff.DanmakuCreationHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing.Axis;
import java.awt.Color;
import scala.Option;

public class IDRelalese extends SpellcardEntity {

    public IDRelalese(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 5 == 0) {
            DanmakuCreationHelper.createCircleShot(
                    Quat.fromAxisAngle(Axis.Z, 0d),
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_HEART.setMainColor(new Color(255,102,102).getRGB())
                                    .setSubEntity(ModSubEntity.IDRELEASE_SUBENTITYTYPE))
                            .build(),
                    11,
                    0f,
                    1d);
        }

    }

}
