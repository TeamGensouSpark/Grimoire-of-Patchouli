package io.github.teamgensouspark.grimoireofpatchouli.libs;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.Consts;
import io.github.teamgensouspark.grimoireofpatchouli.danmaku.form.GoPFormTexturedBase;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.Form;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class ModForms {
    public static void initForms() {
    };

    public static final List<Form> DANMAKU_FORMS = new ArrayList<>();

    public static Form FormHakureiOrb = new GoPFormTexturedBase("hakureiorb", 1.0d, 1.0d,
            new ResourceLocation(Consts.MODID, "textures/items/spellcard/pearl_dark_cast.png"));

    @SubscribeEvent
    public static void onFormRegister(RegistryEvent.Register<Form> event) {
        event.getRegistry().registerAll(DANMAKU_FORMS.toArray(new Form[0]));
    }
}
