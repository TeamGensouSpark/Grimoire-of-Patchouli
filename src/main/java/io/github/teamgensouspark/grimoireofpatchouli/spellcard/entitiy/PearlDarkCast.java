package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import io.github.teamgensouspark.kekkai.example.MySpellCardEntity;
import io.github.teamgensouspark.utils.ReflectUtils;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class PearlDarkCast extends SpellcardEntity {

    public PearlDarkCast(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        int cardtimeis = time();
        if (cardtimeis == 10 || cardtimeis == 30 || cardtimeis == 60) {
            if (!world().isRemote) {
                world().spawnEntity(ReflectUtils.getCustomOrb(user(),4f));
            }
        }
    }

}
