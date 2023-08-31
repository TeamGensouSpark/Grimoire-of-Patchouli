package io.github.teamgensouspark.grimoireofpatchouli.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntitySpellcardTemp extends EntityLiving {
    Integer life;

    public EntitySpellcardTemp(World worldIn) {
        super(worldIn);
        this.life = 100;
        setNoAI(true);
    }

    public EntitySpellcardTemp setLife(Integer life){
        this.life = life;
        return this;
    }

    @Override
    public void onUpdate() {
        this.life -= 1;
        if (life <= 0) {
            setDead();
        }
        super.onUpdate();
    }
}
