package net.conczin.man_of_many_planes.neoforge;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(ManOfManyPlanes.MOD_ID)
@EventBusSubscriber(modid = ManOfManyPlanes.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ManOfManyPlanesNeoForge {
    private static boolean registered = false;

    @SubscribeEvent
    public static void onRegistryEvent(RegisterEvent event) {
        if (!registered) {
            registered = true;
            ManOfManyPlanes.init();
        }
    }
}