package io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class ModEntities {

    @SubscribeEvent
    public static void onEntityEntryRegister(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().registerAll();
    }
}
