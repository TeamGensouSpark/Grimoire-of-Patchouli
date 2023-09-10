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

public class IDRelease extends SpellcardEntity {

    public IDRelease(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 3 == 0) {
            DanmakuCreationHelper.createCircleShot(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_HEART.setMainColor(AtomColors.ATOM_COLOR_RED))
                            .build(),
                    11,
                    time(),
                    1d);
            

            DanmakuCreationHelper.createCircleShot(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_HEART.setMainColor(AtomColors.ATOM_COLOR_RED))
                            .build(),
                    11,
                    -time(),
                    1d);
        }

    }

}
