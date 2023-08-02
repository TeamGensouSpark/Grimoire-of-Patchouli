package io.github.teamgensouspark.grimoireofpatchouli.spellcard.compat;

import io.github.teamgensouspark.grimoireofpatchouli.libs.ModSpellcards;
import io.github.teamgensouspark.kekkai.spellcard.SpellCardBase;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;

public class GoASpellcardBase<T extends SpellcardEntity> extends SpellCardBase<T>{
        public GoASpellcardBase(String name, Class<T> spellcard, TouhouCharacter character) {
        super(name, spellcard, character);
        
        ModSpellcards.GOA_SPELL_CARDS.add(this);
    }
}
