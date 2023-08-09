package io.github.teamgensouspark.grimoireofpatchouli.utils;

import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class Registries {
    public static final IForgeRegistry<Spellcard> SPELLCARDS;
    static {
        SPELLCARDS = GameRegistry.findRegistry(Spellcard.class);
    }
}
