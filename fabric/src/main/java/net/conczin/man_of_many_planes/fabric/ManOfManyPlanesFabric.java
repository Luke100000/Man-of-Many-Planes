package net.conczin.man_of_many_planes.fabric;

import immersive_aircraft.fabric.CommonFabric;
import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.fabricmc.api.ModInitializer;

public class ManOfManyPlanesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // Force loading the Immersive Aircraft class to have networking and registration loaded
        new CommonFabric();
        ManOfManyPlanes.init();
    }
}