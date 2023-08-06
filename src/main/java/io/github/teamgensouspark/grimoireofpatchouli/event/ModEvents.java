package io.github.teamgensouspark.grimoireofpatchouli.event;

import io.github.teamgensouspark.grimoireofpatchouli.Consts;
import net.minecraft.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onStageInteractive(PlayerInteractEvent.RightClickBlock event){
        //Block eventblock = event.getWorld().getBlockState(null).getBlock();
    }
    
}
