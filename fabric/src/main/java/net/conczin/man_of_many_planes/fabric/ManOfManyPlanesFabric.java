package net.conczin.man_of_many_planes.fabric;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.fabricmc.api.ModInitializer;

public class ManOfManyPlanesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ManOfManyPlanes.init();
    }
}