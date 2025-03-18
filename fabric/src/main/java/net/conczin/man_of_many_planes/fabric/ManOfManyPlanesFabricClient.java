package net.conczin.man_of_many_planes.fabric;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.conczin.man_of_many_planes.ManOfManyPlanesClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

import static immersive_aircraft.ItemColors.getDyeColor;

public class ManOfManyPlanesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ManOfManyPlanesClient.registerEntityRenderer();

        ColorProviderRegistry.ITEM.register(getDyeColor(0xFFEF2323), ManOfManyPlanes.SCARLET_BIPLANE_ITEM.get());
        ColorProviderRegistry.ITEM.register(getDyeColor(0xFFFFFFFF), ManOfManyPlanes.ECONOMY_PLANE_ITEM.get());
    }
}
