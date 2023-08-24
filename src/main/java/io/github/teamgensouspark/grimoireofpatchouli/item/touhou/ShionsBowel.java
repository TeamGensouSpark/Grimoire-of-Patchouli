package io.github.teamgensouspark.grimoireofpatchouli.item.touhou;

import io.github.teamgensouspark.grimoireofpatchouli.item.TouhouItem;
import io.github.teamgensouspark.kekkai.character.TouhouExCharacter;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ShionsBowel extends TouhouItem {

    public ShionsBowel(String name) {
        super(name, TouhouExCharacter.SHION_YORIGAMI);
    }

    @SuppressWarnings("all")
    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target,
            EnumHand hand) {
        if (target instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager) target;
            World world = villager.world;
            if (villager.getProfession() != 5) {
                if (!world.isRemote) {
                    EntityItem item = new EntityItem(world, villager.posX, villager.posY, villager.posZ);
                    item.setItem(new ItemStack(Items.EMERALD));
                    world.spawnEntity(item);
                    EntityVillager newvillager = new EntityVillager(world, 5);
                    newvillager.copyLocationAndAnglesFrom(villager);
                    newvillager.setGrowingAge(villager.getGrowingAge());
                    world.removeEntity(villager);
                    world.spawnEntity(newvillager);
                    playerIn.getCooldownTracker().setCooldown(this, 30);
                }
            }
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }

}
