package io.github.teamgensouspark.grimoireofpatchouli.libs;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.Consts;
import io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity.DanmakuIDReleaseSubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class ModSubEntity {
    public static void initSubEntity() {
    };

    public static final List<SubEntityType> DANMAKU_SUBENTITYTYPE = new ArrayList<>();

    public static final SubEntityType IDRELEASE_SUBENTITYTYPE = new DanmakuIDReleaseSubEntityType(
            "idrelease_subentitytype");

    @SubscribeEvent
    public static void onSubEntityRegister(RegistryEvent.Register<SubEntityType> event) {
        event.getRegistry().registerAll(DANMAKU_SUBENTITYTYPE.toArray(new SubEntityType[0]));
    }
}
