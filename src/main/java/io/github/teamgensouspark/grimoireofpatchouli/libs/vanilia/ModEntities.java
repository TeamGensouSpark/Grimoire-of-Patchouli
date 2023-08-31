package io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import io.github.teamgensouspark.grimoireofpatchouli.entity.EntitySpellcardTemp;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class ModEntities {
    private static int id = 1;
    public static final EntityEntry ENTITY_SPELLCARDTEMP = EntityEntryBuilder.create().name("EntitySpellcardTemp")
            .entity(EntitySpellcardTemp.class)
            .id(new ResourceLocation(PatchouliModInfo.MODID, "entityspellcardtemp"), id++)
            .build();

    @SubscribeEvent
    public static void onEntityEntryRegister(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().registerAll(
                ENTITY_SPELLCARDTEMP);
    }
}
