package net.conczin.man_of_many_planes.forge;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@SuppressWarnings("unused")
@Mod(ManOfManyPlanes.MOD_ID)
@Mod.EventBusSubscriber(modid = ManOfManyPlanes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ManOfManyPlanesForge {
    private static boolean registered = false;

    @SubscribeEvent
    public static void onRegistryEvent(RegisterEvent event) {
        if (!registered) {
            registered = true;
            ManOfManyPlanes.init();
        }
    }
}