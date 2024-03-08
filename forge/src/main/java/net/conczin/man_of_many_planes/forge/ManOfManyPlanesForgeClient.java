package net.conczin.man_of_many_planes.forge;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.conczin.man_of_many_planes.ManOfManyPlanesClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ManOfManyPlanes.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ManOfManyPlanesForgeClient {
    @SubscribeEvent
    public static void setup(EntityRenderersEvent.RegisterRenderers event) {
        ManOfManyPlanesClient.init();
    }
}
