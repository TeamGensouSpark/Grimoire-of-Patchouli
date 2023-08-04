package io.github.teamgensouspark.grimoireofpatchouli.spellcard.entitiy;

import java.util.List;

import io.github.teamgensouspark.grimoireofpatchouli.libs.ModSubEntity;
import io.github.teamgensouspark.kekkai.color.DanCoreColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class DreamSeal extends SpellcardEntity {
	private Iterator<Integer> colors = Arrays.asList(DanCoreColors.COLOR_SATURATED_BLUE,
			DanCoreColors.COLOR_SATURATED_GREEN, DanCoreColors.COLOR_SATURATED_RED,
			DanCoreColors.COLOR_SATURATED_YELLOW, DanCoreColors.COLOR_VANILLA_WHITE).iterator();

	public DreamSeal(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
		super(spellcard, cardEntity, target);
	}

	@Override
	public void onSpellcardUpdate() {
		if (time() % 4 == 0) {
			if (colors.hasNext()) {
				DanmakuCore.spawnDanmaku(Collections.singletonList(
						DanmakuBuilder.getBuilderWithEntity(user())
								.setShot(LibShotData.SHOT_MEDIUM.setMainColor(colors.next()).setDelay(4)
										.setSize(1.8f).setSubEntity(ModSubEntity.DREAM_SEAL))
								.setPos(new Vector3(user().getPositionVector()).offset(Vector3.randomDirection(), 2))
								.setDirection(Vector3.directionToEntity(user(), target().get()))
								.build()
								.asEntity()));
			}
		}
	}

}
