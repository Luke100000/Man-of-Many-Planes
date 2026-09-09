package net.conczin.man_of_many_planes.neoforge;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.conczin.man_of_many_planes.ManOfManyPlanesClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import static immersive_aircraft.ItemColors.getDyeColor;

@EventBusSubscriber(modid = ManOfManyPlanes.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ManOfManyPlanesNeoForgeClient {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        ManOfManyPlanesClient.registerEntityRenderer();
    }

    @SubscribeEvent
    public static void initItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(getDyeColor(0xFFEF2323), ManOfManyPlanes.SCARLET_BIPLANE_ITEM.get());
        event.register(getDyeColor(0xFFFFFFFF), ManOfManyPlanes.ECONOMY_PLANE_ITEM.get());
    }
}
