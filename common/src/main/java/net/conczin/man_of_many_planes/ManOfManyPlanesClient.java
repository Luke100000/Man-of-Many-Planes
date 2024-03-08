package net.conczin.man_of_many_planes;

import immersive_aircraft.cobalt.registration.Registration;
import net.conczin.man_of_many_planes.client.EconomyPlaneEntityRenderer;
import net.conczin.man_of_many_planes.client.ScarletBiplaneEntityRenderer;

public class ManOfManyPlanesClient {
    public static void init() {
        Registration.register(ManOfManyPlanes.SCARLET_BIPLANE_ENTITY.get(), ScarletBiplaneEntityRenderer::new);
        Registration.register(ManOfManyPlanes.ECONOMY_PLANE_ENTITY.get(), EconomyPlaneEntityRenderer::new);
    }
}
