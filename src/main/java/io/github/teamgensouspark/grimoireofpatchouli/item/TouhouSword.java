package io.github.teamgensouspark.grimoireofpatchouli.item;

import java.util.List;

import javax.annotation.Nullable;

import io.github.teamgensouspark.grimoireofpatchouli.intf.IHasTouhouCharacter;
import io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TouhouSword extends ItemSwordBase implements IHasTouhouCharacter {
    TouhouCharacter character;

    public TouhouSword(String name, TouhouCharacter character) {
        super(name, ModItems.TOUHOU_TOOLS);
        this.character = character;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, addTouhouUserTooltip(tooltip, character), flagIn);
    }

}
