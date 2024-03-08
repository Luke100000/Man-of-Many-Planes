package net.conczin.man_of_many_planes.fabric;

import net.conczin.man_of_many_planes.ManOfManyPlanesClient;
import net.fabricmc.api.ClientModInitializer;

public class ManOfManyPlanesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ManOfManyPlanesClient.init();
    }
}
