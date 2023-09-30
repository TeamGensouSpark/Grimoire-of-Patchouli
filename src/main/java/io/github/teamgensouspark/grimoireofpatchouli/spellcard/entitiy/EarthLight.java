package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import io.github.teamgensouspark.kekkai.danmaku.KekkaiDanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing.Axis;
import scala.Option;

public class EarthLight extends SpellcardEntity {

    public EarthLight(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    int rndSigned() {
        return PatchouliModInfo.RND.nextInt(2) == 1 ? -1 : 1;
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 2 == 0) {
            KekkaiDanmakuCreationHelper.createCircleShot(
                    DanmakuBuilder.getBuilderWithEntity(user())
                            .setPos(new Vector3(user()).add(rndSigned() * PatchouliModInfo.RND.nextDouble() * 25, 0,
                                    rndSigned() * PatchouliModInfo.RND.nextDouble() * 25))
                            .setShot(LibShotData.SHOT_LASER.setMainColor(AtomColors.ATOM_COLOR_CYAN))
                            .setDirection(Vector3.Up().rotate(PatchouliModInfo.RND.nextDouble() * 6, Axis.X))
                            .setMovementData(0)
                            .build(),
                    1,
                    1.0f, 1.0d);
        }
    }

}
