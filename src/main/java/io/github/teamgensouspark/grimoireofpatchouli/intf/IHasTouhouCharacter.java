package io.github.teamgensouspark.grimoireofpatchouli.intf;

import java.util.List;

import io.github.teamgensouspark.kekkai.utils.KekkaiI18n;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.minecraft.client.resources.I18n;

public interface IHasTouhouCharacter {
    default List<String> addTouhouUserTooltip(List<String> tooltip, TouhouCharacter character) {
        tooltip.add(String.format("%s%s", I18n.format("gop.tooltip.user"), KekkaiI18n.getTouhouCharName(character)));
        return tooltip;
    }
}
