package io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.GoPSpellcardBase;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.compat.GoASpellcardBase;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.DreamSeal;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.EarthLight;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.IDRelease;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.MasterSpark;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.MilkyWay;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.PearlDarkCast;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.WaveAndParticle;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.WonderGodWind;
import io.github.teamgensouspark.grimoireofpatchouli.utils.ModCompat;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class ModSpellcards {
    public static void initSpellCard() {
    };

    public static final List<Spellcard> SPELL_CARDS = new ArrayList<>();
    public static final List<Spellcard> GOA_SPELL_CARDS = new ArrayList<>();
    // GoA compat
    public static final Spellcard PEARL_DARK_CAST = new GoASpellcardBase<PearlDarkCast>("pearl_dark_cast",
            PearlDarkCast.class,
            TouhouCharacter.REIMU_HAKUREI).setendTime(80);
    // Native Spellcard
    public static final Spellcard ID_RELEASE = new GoPSpellcardBase<IDRelease>("id_release",
            IDRelease.class,
            TouhouCharacter.KOISHI_KOMEIJI).setendTime(180);

    public static final Spellcard DREAM_SEAL = new GoPSpellcardBase<DreamSeal>("dream_seal", DreamSeal.class,
            TouhouCharacter.REIMU_HAKUREI).setendTime(60);

    public static final Spellcard MILKY_WAY = new GoPSpellcardBase<MilkyWay>("milky_way", MilkyWay.class,
            TouhouCharacter.MARISA_KIRISAME).setendTime(180);

    public static final Spellcard MASTER_SPARK = new GoPSpellcardBase<MasterSpark>("master_spark", MasterSpark.class,
            TouhouCharacter.MARISA_KIRISAME).setendTime(200);
    public static final Spellcard WAVE_PARTICLE = new GoPSpellcardBase<WaveAndParticle>("wave_particle",
            WaveAndParticle.class, TouhouCharacter.YUKARI_YAKUMO).setendTime(400);

    public static final Spellcard WONDER_GODWIND = new GoPSpellcardBase<WonderGodWind>("wonder_godwind",
            WonderGodWind.class, TouhouCharacter.SANAE_KOCHIYA).setendTime(200);
    public static final Spellcard EARTH_LIGHT = new GoPSpellcardBase<EarthLight>("earth_light",
            EarthLight.class, TouhouCharacter.MARISA_KIRISAME).setendTime(200);

    @SubscribeEvent
    public static void onSpellCardRegister(RegistryEvent.Register<Spellcard> event) {
        event.getRegistry().registerAll(SPELL_CARDS.toArray(new Spellcard[0]));
        ModCompat.GOA.loadedThen(() -> event.getRegistry().registerAll(GOA_SPELL_CARDS.toArray(new Spellcard[0])));
    }
}
