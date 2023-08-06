package io.github.teamgensouspark.grimoireofpatchouli.danmaku.form;

import io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku.ModForms;
import net.katsstuff.teamnightclipse.danmakucore.danmodel.FormDanModel;
import net.minecraft.util.ResourceLocation;

public class GoPFormDanModelBase extends FormDanModel{
    public GoPFormDanModelBase(String name, ResourceLocation resource) {
        super(name, resource);

        ModForms.DANMAKU_FORMS.add(this);
    }
    
}
