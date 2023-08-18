package io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import io.github.teamgensouspark.grimoireofpatchouli.Patchouli;
import io.github.teamgensouspark.grimoireofpatchouli.item.Cardbag;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item CARD_BAG = new Cardbag("card_bag");

    @SubscribeEvent
    public static void onItemModelReg(ModelRegistryEvent event) {
        ITEMS.forEach(item -> Patchouli.proxy.regCommonVaniliaIRR(item));
    }

    @SubscribeEvent
    public static void onItemReg(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
    }
}
