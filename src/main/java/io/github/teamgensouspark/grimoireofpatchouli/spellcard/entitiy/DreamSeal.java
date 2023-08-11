package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import java.util.List;
import java.util.Random;

import io.github.teamgensouspark.grimoireofpatchouli.libs.danmaku.ModSubEntity;
import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.color.DanCoreColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import scala.Option;

public class DreamSeal extends SpellcardEntity {

	private Iterator<Integer> colors;
	private Random random = new Random();

	public DreamSeal(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
		super(spellcard, cardEntity, target);
		List<Integer> colors_list = Arrays.asList(DanCoreColors.COLOR_SATURATED_BLUE,
				DanCoreColors.COLOR_SATURATED_GREEN, DanCoreColors.COLOR_SATURATED_RED,
				DanCoreColors.COLOR_SATURATED_YELLOW, DanCoreColors.COLOR_VANILLA_WHITE, AtomColors.ATOM_COLOR_RED,
				AtomColors.ATOM_COLOR_CYAN, AtomColors.ATOM_COLOR_GREEN, AtomColors.ATOM_COLOR_YELLOW);
		Collections.shuffle(colors_list);
		this.colors = colors_list.iterator();
	}

	@Override
	public void onSpellcardUpdate() {
		if (time() == 1) {
			user().setNoGravity(true);
		}

		if (time() == 59) {
			user().setNoGravity(false);
		}

		if (time() % 4 == 0) {
			if (colors.hasNext()) {
				ShotData shotData = LibShotData.SHOT_MEDIUM.setMainColor(colors.next()).setDelay(random.nextInt(4))
						.setSize(random.nextFloat() + 1.3f).setDamage(8)
						.setSubEntity(ModSubEntity.DREAM_SEAL_SUBENTITYTYPE);
				NBTTagCompound nbt = user().getEntityData();
				nbt.setInteger("target_id", target().get().getEntityId());
				DanmakuCore.spawnDanmaku(Collections.singletonList(
						DanmakuBuilder.getBuilderWithEntity(user())
								.setShot(shotData)
								.setMovementData(1.2d)
								.setPos(new Vector3(user().getPositionVector()).offset(Vector3.randomDirection(),
										random.nextDouble() + 1.2d))
								.setDirection(Vector3.directionToEntity(user(), target().get()))
								.build()
								.asEntity()));
			}
		}
	}

}
