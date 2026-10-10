package net.conczin.man_of_many_planes;

import immersive_aircraft.Items;
import immersive_aircraft.cobalt.registration.Registration;
import immersive_aircraft.item.DyeableAircraftItem;
import net.conczin.man_of_many_planes.entity.EconomyPlaneEntity;
import net.conczin.man_of_many_planes.entity.ScarletBiplaneEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;

import java.util.function.Function;
import java.util.function.Supplier;

public class ManOfManyPlanes {
    public static final String MOD_ID = "man_of_many_planes";

    public static Supplier<Item> SCARLET_BIPLANE_ITEM;
    public static Supplier<Item> ECONOMY_PLANE_ITEM;

    public static Supplier<EntityType<ScarletBiplaneEntity>> SCARLET_BIPLANE_ENTITY;
    public static Supplier<EntityType<EconomyPlaneEntity>> ECONOMY_PLANE_ENTITY;

    public static void init() {
        // Register items
        SCARLET_BIPLANE_ITEM = register("scarlet_biplane", name -> new DyeableAircraftItem(baseProps(name).stacksTo(1), world -> new ScarletBiplaneEntity(SCARLET_BIPLANE_ENTITY.get(), world)));
        ECONOMY_PLANE_ITEM = register("economy_plane", name -> new DyeableAircraftItem(baseProps(name).stacksTo(1), world -> new EconomyPlaneEntity(ECONOMY_PLANE_ENTITY.get(), world)));

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

    static Supplier<Item> register(String name, Function<String, Item> factory) {
        Identifier id = ManOfManyPlanes.locate(name);
        Supplier<Item> register = Registration.register(BuiltInRegistries.ITEM, id, () -> factory.apply(name));
        Items.items.add(register);
        return register;
    }

    static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        Identifier id = ManOfManyPlanes.locate(name);
        ResourceKey<EntityType<?>> key = ResourceKey.create(BuiltInRegistries.ENTITY_TYPE.key(), id);
        return Registration.register(BuiltInRegistries.ENTITY_TYPE, id, () -> builder.build(key));
    }

    static Item.Properties baseProps(String name) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ManOfManyPlanes.locate(name)));
    }

    public static Identifier locate(String name) {
        return Identifier.fromNamespaceAndPath(ManOfManyPlanes.MOD_ID, name);
    }
}
