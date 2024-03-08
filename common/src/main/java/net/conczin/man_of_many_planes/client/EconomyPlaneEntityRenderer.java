package net.conczin.man_of_many_planes.client;

import immersive_aircraft.client.render.entity.renderer.AircraftEntityRenderer;
import immersive_aircraft.client.render.entity.renderer.utils.BBModelRenderer;
import immersive_aircraft.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_aircraft.entity.AircraftEntity;
import immersive_aircraft.resources.bbmodel.BBBone;
import immersive_aircraft.resources.bbmodel.BBObject;
import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.conczin.man_of_many_planes.entity.EconomyPlaneEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.Random;

public class EconomyPlaneEntityRenderer extends AircraftEntityRenderer<EconomyPlaneEntity> {
    private static final ResourceLocation ID = ManOfManyPlanes.locate("economy_plane");

    private final Random random = new Random();

    private final ModelPartRenderHandler<EconomyPlaneEntity> model = new ModelPartRenderHandler<EconomyPlaneEntity>()
            .add("engine_block",
                    (entity, yaw, tickDelta, matrixStack) -> {
                        double p = entity.enginePower.getSmooth() / 32.0;
                        matrixStack.translate((random.nextDouble() - 0.5) * p, (random.nextDouble() - 0.5) * p, (random.nextDouble() - 0.5) * p);
                    })
            .add("belt",
                    (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) -> {
                        if (object instanceof BBBone bone) {
                            int frame = (int) entity.engineRotation.getSmooth(time % 1.0f);
                            BBObject belt = bone.children.get(Math.floorMod(frame, bone.children.size()));
                            BBModelRenderer.renderObject(model, belt, matrixStack, vertexConsumerProvider, light, time, entity, null, 1.0f, 1.0f, 1.0f, 1.0f);
                        }
                    }
            );

    @Override
    protected ResourceLocation getModelId() {
        return ID;
    }

    public EconomyPlaneEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected ModelPartRenderHandler<EconomyPlaneEntity> getModel(AircraftEntity entity) {
        return model;
    }
}
