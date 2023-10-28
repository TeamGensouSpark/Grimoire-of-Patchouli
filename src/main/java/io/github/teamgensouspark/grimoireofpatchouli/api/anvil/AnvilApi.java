package io.github.teamgensouspark.grimoireofpatchouli.api.anvil;

import java.util.HashMap;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class AnvilApi {
    private static HashMap<String, AnvilReceipe> RECEPIES = new HashMap<>();

    public static void regReceipe(String name, AnvilReceipe receipe) {
        AnvilApi.RECEPIES.put(name, receipe);
    }

    public static void unregReceipe(String name) {
        AnvilApi.RECEPIES.remove(name);
    }

    public static boolean hasRecepie(String name) {
        return AnvilApi.RECEPIES.containsKey(name);
    }

    @SubscribeEvent
    public static void _InternalListener(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        for (AnvilReceipe R : AnvilApi.RECEPIES.values()) {
            if (R.matchThen(left, right, () -> R.apply(event))) {
                break;
            }
        }
    }

}
