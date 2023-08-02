package io.github.teamgensouspark.grimoireofpatchouli.libs;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.Consts;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.GoPSpellcardBase;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.compat.GoASpellcardBase;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.IDRelalese;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.PearlDarkCast;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class ModSpellcards {
        public static void initSpellCard() {
    };

    public static final List<Spellcard> SPELL_CARDS = new ArrayList<>();
    public static final List<Spellcard> GOA_SPELL_CARDS = new ArrayList<>();

    public static final Spellcard PEARL_DARK_CAST = new GoASpellcardBase<>("pearl_dark_cast",
            PearlDarkCast.class,
            TouhouCharacter.REIMU_HAKUREI).setendTime(80);


    public static final Spellcard ID_RELEASE = new GoPSpellcardBase<>("id_release",
            IDRelalese.class,
            TouhouCharacter.KOISHI_KOMEIJI).setendTime(180);


    @SubscribeEvent
    public static void onSpellCardRegister(RegistryEvent.Register<Spellcard> event) {
        event.getRegistry().registerAll(SPELL_CARDS.toArray(new Spellcard[0]));
        if (Loader.isModLoaded("grimoireofalice")){
                event.getRegistry().registerAll(GOA_SPELL_CARDS.toArray(new Spellcard[0]));  
        }
    }
}
