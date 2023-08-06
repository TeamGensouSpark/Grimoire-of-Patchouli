package io.github.teamgensouspark.grimoireofpatchouli.spellcard;

import io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku.ModSpellcards;
import io.github.teamgensouspark.kekkai.spellcard.SpellCardBase;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;

public class GoPSpellcardBase<T extends SpellcardEntity> extends SpellCardBase<T>{

    public GoPSpellcardBase(String name, Class<T> spellcard, TouhouCharacter character) {
        super(name, spellcard, character);
        
        ModSpellcards.SPELL_CARDS.add(this);
    }
    
}
