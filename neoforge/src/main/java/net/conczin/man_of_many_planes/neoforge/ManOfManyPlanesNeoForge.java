package net.conczin.man_of_many_planes.neoforge;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(ManOfManyPlanes.MOD_ID)
public class ManOfManyPlanesNeoForge {
    public ManOfManyPlanesNeoForge(IEventBus modEventBus) {
        ManOfManyPlanes.init();

        if (FMLEnvironment.getDist() == Dist.CLIENT) {
            ManOfManyPlanesNeoForgeClient.register(modEventBus);
        }
    }
}
