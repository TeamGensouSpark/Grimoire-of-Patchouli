package io.github.teamgensouspark.grimoireofpatchouli.utils;

import net.minecraftforge.fml.common.Loader;

public class ModCompat {
    private String modid;
    public static final ModCompat GOA = new ModCompat("grimoireofalice");

    public ModCompat(String modid) {
        this.modid = modid;
    }

    public String getModid() {
        return modid;
    }

    public boolean isLoaded() {
        return Loader.isModLoaded(modid);
    }

    public void loadedThen(Runnable F) {
        if (isLoaded()) {
            F.run();
        }
    }

}
