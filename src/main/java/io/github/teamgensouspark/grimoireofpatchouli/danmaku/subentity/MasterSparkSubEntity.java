package io.github.teamgensouspark.grimoireofpatchouli.danmaku.subentity;

import java.util.List;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.ExtraDanmakuData;
import net.katsstuff.teamnightclipse.danmakucore.data.OrientedBoundingBox;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityShiftingRainbow;
import scala.collection.JavaConverters;

public class MasterSparkSubEntity extends SubEntityShiftingRainbow {
        @Override
        public DanmakuUpdate subEntityTick(DanmakuState danmaku) {

                ExtraDanmakuData ex = danmaku.extra().copy(danmaku.extra().user(), danmaku.extra().source(),
                                danmaku.shot().setDamage(danmaku.shot().damage() + 0.05f).setSize(
                                                danmaku.shot().getSizeX() + 0.03f,
                                                danmaku.shot().getSizeY() + 0.03f,
                                                danmaku.shot().getSizeZ() + 1f),
                                danmaku.extra().subEntity(), danmaku.extra().movement(),
                                danmaku.extra().rotation());

                List<OrientedBoundingBox> boxes = JavaConverters
                                .seqAsJavaListConverter(danmaku.entity().rawBoundingBoxes())
                                .asJava();
                boxes.forEach(box -> box.copy(box.aabb().expand(0.03d, 0.03d, 1d), box.pos(), box.orientation()));

                return super.subEntityTick(danmaku.copy(
                                danmaku.entity().setRawBoundingBoxes(
                                                JavaConverters.asScalaIteratorConverter(boxes.iterator()).asScala()
                                                                .toSeq()),
                                ex, danmaku.tracking()));
        }
}
