package io.github.teamgensouspark.grimoireofpatchouli.libs;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.Consts;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.GoPSpellcardBase;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.PearlDarkCast;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class ModSpellcards {
        public static void initSpellCard() {
    };

    public static final List<Spellcard> SPELL_CARDS = new ArrayList<>();

    public static final Spellcard PEARL_DARK_CAST = new GoPSpellcardBase<>("pearl_dark_cast",
            PearlDarkCast.class,
            TouhouCharacter.REIMU_HAKUREI).setendTime(80);

    @SubscribeEvent
    public static void onSpellCardRegister(RegistryEvent.Register<Spellcard> event) {
        event.getRegistry().registerAll(SPELL_CARDS.toArray(new Spellcard[0]));
    }
}
