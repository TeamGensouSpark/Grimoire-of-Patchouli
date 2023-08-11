package io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.Consts;
import io.github.teamgensouspark.grimoireofpatchouli.danmaku.GoPSubEntityType;
import io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity.DreamSealSubEntity;
import io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity.IDReleaseSubEntity;
import io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity.MasterSparkSubEntity;
import io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy.MasterSpark;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class ModSubEntity {
    public static void initSubEntity() {
    };

    public static final List<SubEntityType> DANMAKU_SUBENTITYTYPE = new ArrayList<>();

    public static final SubEntityType IDRELEASE_SUBENTITYTYPE = new GoPSubEntityType<>(
            "idrelease_subentity", IDReleaseSubEntity.class);
    public static final SubEntityType DREAM_SEAL_SUBENTITYTYPE = new GoPSubEntityType<>(
            "dreamseal_subentity", DreamSealSubEntity.class);
    public static final SubEntityType MASTER_SPARK_SUBENTITYTYPE = new GoPSubEntityType<>(
            "master_spark_subentity", MasterSparkSubEntity.class);

    @SubscribeEvent
    public static void onSubEntityRegister(RegistryEvent.Register<SubEntityType> event) {
        event.getRegistry().registerAll(DANMAKU_SUBENTITYTYPE.toArray(new SubEntityType[0]));
    }
}
