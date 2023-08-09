package io.github.teamgensouspark.grimoireofpatchouli.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    public void regCommonVaniliaIRR(Item item) {
        ResourceLocation location = item.getRegistryName();
        if (location == null) {
            return;
        }
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(location, "inventory"));
    }
}