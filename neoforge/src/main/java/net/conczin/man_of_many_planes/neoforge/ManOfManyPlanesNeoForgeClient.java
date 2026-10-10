package net.conczin.man_of_many_planes.neoforge;

import net.conczin.man_of_many_planes.ManOfManyPlanesClient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class ManOfManyPlanesNeoForgeClient {
    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ManOfManyPlanesNeoForgeClient::registerEntityRenderers);
    }

    private static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        ManOfManyPlanesClient.registerEntityRenderer();
    }
}
