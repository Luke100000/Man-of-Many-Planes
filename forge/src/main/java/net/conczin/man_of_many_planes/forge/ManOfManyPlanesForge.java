package net.conczin.man_of_many_planes.forge;

import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ManOfManyPlanes.MOD_ID)
public class ManOfManyPlanesForge {
    public ManOfManyPlanesForge() {
        ManOfManyPlanes.init();
    }
}