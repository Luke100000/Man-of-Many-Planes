package net.conczin.man_of_many_planes.client;

import immersive_aircraft.client.render.entity.renderer.AircraftEntityRenderer;
import immersive_aircraft.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_aircraft.entity.AircraftEntity;
import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.conczin.man_of_many_planes.entity.ScarletBiplaneEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public class ScarletBiplaneEntityRenderer extends AircraftEntityRenderer<ScarletBiplaneEntity> {
    private static final Identifier ID = ManOfManyPlanes.locate("scarlet_biplane");

    private final ModelPartRenderHandler<ScarletBiplaneEntity> model = new ModelPartRenderHandler<ScarletBiplaneEntity>()
            .add("dyed_body", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, false, false))
            .add("dyed_body_highlights", (model, object, vertexConsumerProvider, entity, matrixStack, light, time, modelPartRenderer) ->
                    renderDyed(model, object, vertexConsumerProvider, entity, matrixStack, light, time, true, false));

    @Override
    protected Identifier getModelId() {
        return ID;
    }

    public ScarletBiplaneEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected ModelPartRenderHandler<ScarletBiplaneEntity> getModel(AircraftEntity entity) {
        return model;
    }
}
