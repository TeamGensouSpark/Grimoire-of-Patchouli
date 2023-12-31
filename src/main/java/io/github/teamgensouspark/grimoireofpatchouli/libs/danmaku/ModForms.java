package io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.Form;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class ModForms {
    public static void initForms() {
    };

    public static final List<Form> DANMAKU_FORMS = new ArrayList<>();

    @SubscribeEvent
    public static void onFormRegister(RegistryEvent.Register<Form> event) {
        event.getRegistry().registerAll(DANMAKU_FORMS.toArray(new Form[0]));
    }
}
