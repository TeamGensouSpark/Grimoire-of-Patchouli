package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import io.github.teamgensouspark.kekkai.color.DanCoreColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import io.github.teamgensouspark.kekkai.danmaku.KekkaiDanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class WonderGodWind extends SpellcardEntity {

    public WonderGodWind(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 10 == 0) {
            KekkaiDanmakuCreationHelper.createCircleShot(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setShot(LibShotData.SHOT_MEDIUM.setSize(1f).setMainColor(DanCoreColors.COLOR_VANILLA_BLUE))
                            .build(),
                    12, 0f,
                    0.7d);
        }

        if (time() % 30 == 0) {
            for (double d = 5; d >= 0; d--) {
                KekkaiDanmakuCreationHelper.createCircleShot(
                        DanmakuBuilder.getBuilderWithEntity(user())
                                .setShot(LibShotData.SHOT_OVAL.setMainColor(
                                        time() % 20 == 0 ? DanCoreColors.COLOR_SATURATED_GREEN
                                                : DanCoreColors.COLOR_VANILLA_BLUE)
                                        .setSize(0.8f)
                                        .setDelay((int) (12 - d)))
                                .build(),
                        20,
                        (float) d, d);
            }
        }
    }

}
