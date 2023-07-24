package io.github.teamgensouspark.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import arekkuusu.grimoireofalice.common.entity.EntityHakureiOrb;
import io.github.teamgensouspark.grimoireofpatchouli.Patchouli;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class ReflectUtils {
    public static EntityHakureiOrb getCustomOrb(EntityLivingBase entity, float size) {
        try {
            Constructor<EntityHakureiOrb> constructor = EntityHakureiOrb.class.getDeclaredConstructor(World.class,
                    EntityLivingBase.class);
            constructor.setAccessible(true);
            EntityHakureiOrb orb = constructor.newInstance(entity.world, entity);
            Method setSize = EntityHakureiOrb.class.getDeclaredMethod("setSize",float.class);
            setSize.setAccessible(true);
            setSize.invoke(orb, size);
            return orb;
        } catch (Exception e) {
            Patchouli.logger.info(e.toString());
            return new EntityHakureiOrb(entity.world, entity);
        }
    }
}
