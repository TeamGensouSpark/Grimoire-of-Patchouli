package io.github.teamgensouspark.grimoireofpatchouli.item;

import java.util.List;

import javax.annotation.Nullable;

import io.github.teamgensouspark.kekkai.utils.KekkaiI18n;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TouhouItem extends ItemBase {
    TouhouCharacter character;

    public TouhouItem(String name, TouhouCharacter character) {
        super(name);
        this.character = character;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(String.format("%s%s", I18n.format("gop.tooltip.user"), KekkaiI18n.getTouhouCharName(character)));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
