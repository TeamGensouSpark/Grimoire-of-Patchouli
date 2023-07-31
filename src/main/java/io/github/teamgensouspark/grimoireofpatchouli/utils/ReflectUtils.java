package io.github.teamgensouspark.grimoireofpatchouli.utils;

import java.lang.reflect.Method;

import arekkuusu.grimoireofalice.common.entity.EntityHakureiOrb;
import io.github.teamgensouspark.grimoireofpatchouli.Patchouli;
import net.minecraft.entity.EntityLivingBase;

public class ReflectUtils {
    public static EntityHakureiOrb getCustomOrb(EntityLivingBase entity, float size) {
        EntityHakureiOrb orb = new EntityHakureiOrb(entity.world, entity);
        try {
            Method setSize = EntityHakureiOrb.class.getDeclaredMethod("setSize",float.class);
            setSize.setAccessible(true);
            setSize.invoke(orb, size);
            return orb;
        } catch (Exception e) {
            Patchouli.logger.info(e.toString());
            return orb;
        }
    }
}
