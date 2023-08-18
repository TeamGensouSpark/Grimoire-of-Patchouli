package io.github.teamgensouspark.grimoireofpatchouli;

import org.apache.logging.log4j.Logger;

import io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku.ModForms;
import io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku.ModSpellcards;
import io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku.ModSubEntity;
import io.github.teamgensouspark.grimoireofpatchouli.proxy.CommonProxy;
import io.github.teamgensouspark.kekkai.utils.ModResource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PatchouliModInfo.MODID, name = PatchouliModInfo.NAME, version = PatchouliModInfo.VERSION, dependencies = "required-after:mirror@[0.4.0,);required-after:danmakucore;required-after:kekkai")
public class Patchouli {
    public static Logger logger;
    public static ModResource patchouli_res = new ModResource(PatchouliModInfo.MODID);
    @SidedProxy(clientSide = "io.github.teamgensouspark.grimoireofpatchouli.proxy.ClientProxy", serverSide = "io.github.teamgensouspark.grimoireofpatchouli.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        ModForms.initForms();
        ModSubEntity.initSubEntity();
        ModSpellcards.initSpellCard();
    }
}
