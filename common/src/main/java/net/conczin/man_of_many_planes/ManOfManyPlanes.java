package net.conczin.man_of_many_planes;

import immersive_aircraft.Items;
import immersive_aircraft.cobalt.registration.Registration;
import immersive_aircraft.entity.AirshipEntity;
import immersive_aircraft.item.AircraftItem;
import net.conczin.man_of_many_planes.entity.EconomyPlaneEntity;
import net.conczin.man_of_many_planes.entity.ScarletBiplaneEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static immersive_aircraft.Items.baseProps;

public class ManOfManyPlanes {
    public static final String MOD_ID = "man_of_many_planes";

    public static Supplier<Item> SCARLET_BIPLANE_ITEM;
    public static Supplier<Item> ECONOMY_PLANE_ITEM;

    public static Supplier<EntityType<ScarletBiplaneEntity>> SCARLET_BIPLANE_ENTITY;
    public static Supplier<EntityType<EconomyPlaneEntity>> ECONOMY_PLANE_ENTITY;

    public static void init() {
        // Register items
        SCARLET_BIPLANE_ITEM = register("scarlet_biplane", () -> new AircraftItem(baseProps().stacksTo(1), world -> new AirshipEntity(SCARLET_BIPLANE_ENTITY.get(), world)));
        ECONOMY_PLANE_ITEM = register("economy_plane", () -> new AircraftItem(baseProps().stacksTo(1), world -> new AirshipEntity(ECONOMY_PLANE_ENTITY.get(), world)));

        // Register entities
        SCARLET_BIPLANE_ENTITY = register("scarlet_biplane", EntityType.Builder
                .of(ScarletBiplaneEntity::new, MobCategory.MISC)
                .sized(2.25f, 3.5f)
                .clientTrackingRange(12)
                .fireImmune()
        );

        ECONOMY_PLANE_ENTITY = register("economy_plane", EntityType.Builder
                .of(EconomyPlaneEntity::new, MobCategory.MISC)
                .sized(2.5f, 4.0f)
                .clientTrackingRange(12)
                .fireImmune()
        );
    }

    static Supplier<Item> register(String name, Supplier<Item> item) {
        Supplier<Item> register = Registration.register(BuiltInRegistries.ITEM, ManOfManyPlanes.locate(name), item);
        Items.items.add(register);
        return register;
    }

    static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        ResourceLocation id = ManOfManyPlanes.locate(name);
        return Registration.register(BuiltInRegistries.ENTITY_TYPE, id, () -> builder.build(id.toString()));
    }

    public static ResourceLocation locate(String name) {
        return new ResourceLocation(ManOfManyPlanes.MOD_ID, name);
    }
}
