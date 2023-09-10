package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.DanmakuCreationHelper;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class MilkyWay extends SpellcardEntity {

    public MilkyWay(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 8 == 0) {
            DanmakuCreationHelper.createCircleShot(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_STAR.setMainColor(AtomColors.ATOM_COLOR_RED))
                            .build(),
                    11,
                    time() % 20,
                    1d);
        }
        if (time() % 6 == 0) {
            DanmakuCreationHelper.createCircleShot(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_STAR.setMainColor(AtomColors.ATOM_COLOR_GREEN)
                                    .scaleSize(0.3f))
                            .build(),
                    8,
                    time() % 10,
                    1d);
        }
        if (time() % 12 == 0) {
            DanmakuCreationHelper.createCircleShot(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_STAR.setMainColor(AtomColors.ATOM_COLOR_CYAN))
                            .build(),
                    11,
                    time() % 20,
                    1d);
        }
    }

}
