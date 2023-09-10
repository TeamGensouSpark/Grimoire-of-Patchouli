package io.github.teamgensouspark.grimoireofpatchouli.event;

import io.github.teamgensouspark.grimoireofpatchouli.PatchouliModInfo;
import io.github.teamgensouspark.grimoireofpatchouli.libs.vanilia.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PatchouliModInfo.MODID)
public class ModEvents {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onEntityDead(LivingDeathEvent event) {
        if (!event.isCanceled()) {
            EntityLivingBase living = event.getEntityLiving();
            if (PatchouliModInfo.RND.nextFloat() > 0.99 || !living.isNonBoss()) {
                World world = living.world;
                if (!world.isRemote) {
                    world.spawnEntity(
                            new EntityItem(world, living.posX, living.posY, living.posZ,
                                    new ItemStack(ModItems.CARD_BAG)));
                }
            }
        }
    }

    @SubscribeEvent
    public static void check_lifespan(LivingUpdateEvent event) {

        if (event.getEntityLiving() instanceof EntityArmorStand) {
            EntityArmorStand entity = (EntityArmorStand) event.getEntityLiving();
            NBTTagCompound nbt = entity.getEntityData();
            if (nbt.hasKey("_lifespan")) {
                int _lifespan = nbt.getInteger("_lifespan");
                if (_lifespan <= 0) {
                    entity.setDead();
                } else {
                    nbt.setInteger("_lifespan", _lifespan - 1);
                }
            }
        }

    }

}
