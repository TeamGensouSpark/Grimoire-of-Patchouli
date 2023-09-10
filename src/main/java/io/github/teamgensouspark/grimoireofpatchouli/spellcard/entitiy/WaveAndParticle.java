package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import io.github.teamgensouspark.kekkai.danmaku.KekkaiDanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class WaveAndParticle extends SpellcardEntity {

    public WaveAndParticle(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        KekkaiDanmakuCreationHelper.createCircleShot(
                DanmakuBuilder.getBuilderWithEntity(user())
                        .setShot(LibShotData.SHOT_RICE.setMainColor(AtomColors.ATOM_COLOR_PURPLE)).build(),
                9, (float) (Math.PI / 180 *
                        time() * ((float) time() / 5)),
                0d);
    }

}
