package net.conczin.man_of_many_planes.client;

import immersive_aircraft.client.render.entity.renderer.AircraftEntityRenderer;
import immersive_aircraft.client.render.entity.renderer.utils.ModelPartRenderHandler;
import immersive_aircraft.entity.AircraftEntity;
import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.conczin.man_of_many_planes.entity.ScarletBiplaneEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ScarletBiplaneEntityRenderer extends AircraftEntityRenderer<ScarletBiplaneEntity> {
    private static final ResourceLocation ID = ManOfManyPlanes.locate("scarlet_biplane");

    private final ModelPartRenderHandler<ScarletBiplaneEntity> model = new ModelPartRenderHandler<>();

    @Override
    protected ResourceLocation getModelId() {
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
