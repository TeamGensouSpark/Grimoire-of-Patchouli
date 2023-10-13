package io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import io.github.teamgensouspark.grimoireofpatchouli.Patchouli;
import io.github.teamgensouspark.grimoireofpatchouli.item.*;
import io.github.teamgensouspark.grimoireofpatchouli.item.touhou.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class ModItems {
    public static final ToolMaterial TOUHOU_TOOLS = EnumHelper.addToolMaterial("touhou_tools", 9, -1, 1, 10, 0);

    public static final List<Item> ITEMS = new ArrayList<>();
    public static final List<Item> GOA_ITEMS = new ArrayList<>();

    public static final Item CARD_BAG = new Cardbag("card_bag");
    public static final Item SHIONS_BOWL = new ShionsBowel("shions_bowl");
    public static final Item SHINING_TRIPOD = new ShiningTripod("shining_tripod");
    public static final ItemSword BLACK_SAKURA = new BlackSakura("black_sakura");
    public static final Item MOON_PHASER = new ItemMoonPhaser("moon_phaser");

    @SubscribeEvent
    public static void onItemModelReg(ModelRegistryEvent event) {
        ITEMS.forEach(item -> Patchouli.proxy.regCommonVaniliaIRR(item));
        if (Loader.isModLoaded("grimoireofalice")) {
            GOA_ITEMS.forEach(item -> Patchouli.proxy.regCommonVaniliaIRR(item));
        }
    }

    @SubscribeEvent
    public static void onItemReg(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
        if (Loader.isModLoaded("grimoireofalice")) {
            event.getRegistry().registerAll(GOA_ITEMS.toArray(new Item[0]));
        }
    }
}
