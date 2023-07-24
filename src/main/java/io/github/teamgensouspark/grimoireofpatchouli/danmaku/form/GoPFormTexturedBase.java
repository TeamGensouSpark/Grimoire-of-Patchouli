package io.github.teamgensouspark.grimoireofpatchouli.danmaku.form;

import io.github.teamgensouspark.grimoireofpatchouli.libs.ModForms;
import net.katsstuff.teamnightclipse.danmakucore.impl.form.FormTexturedStatic;
import net.minecraft.util.ResourceLocation;

public class GoPFormTexturedBase extends FormTexturedStatic{

    public GoPFormTexturedBase(String name, double width, double length, ResourceLocation texture) {
        super(name, width, length, texture);
        ModForms.DANMAKU_FORMS.add(this);
    }
    
}
