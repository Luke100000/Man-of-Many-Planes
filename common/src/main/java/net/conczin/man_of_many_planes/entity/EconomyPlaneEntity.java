package net.conczin.man_of_many_planes.entity;

import immersive_aircraft.entity.AircraftEntity;
import immersive_aircraft.entity.AirplaneEntity;
import immersive_aircraft.entity.misc.Trail;
import net.conczin.man_of_many_planes.ManOfManyPlanes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class EconomyPlaneEntity extends AirplaneEntity {
    public EconomyPlaneEntity(EntityType<? extends AircraftEntity> entityType, Level world) {
        super(entityType, world, true);
    }

    @Override
    public Item asItem() {
        return ManOfManyPlanes.ECONOMY_PLANE_ITEM.get();
    }

    private final List<Trail> trails = List.of(new Trail(60), new Trail(60), new Trail(30), new Trail(30));

    @Override
    public List<Trail> getTrails() {
        return trails;
    }

    protected void trail(Matrix4f transform, int index, float x, float y, float z, float thickness) {
        Vector4f p0 = transformPosition(transform, x, y - thickness, z);
        Vector4f p1 = transformPosition(transform, x, y + thickness, z);

        float trailStrength = Math.max(0.0f, Math.min(1.0f, (float) (Math.sqrt(getDeltaMovement().length()) * (0.5f + (pressingInterpolatedX.getSmooth() * x) * 0.025f) - 0.25f)));
        getTrails().get(index).add(p0, p1, trailStrength);
    }

    @Override
    public void tick() {
        super.tick();

        if (level().isClientSide) {
            if (isWithinParticleRange()) {
                Matrix4f transform = getVehicleTransform();
                Matrix3f normalTransform = getVehicleNormalTransform();

                // Trails
                trail(transform, 0, -5.5f, 2.2f, -0.6f, 0.25f);
                trail(transform, 1, 5.5f, 2.2f, -0.6f, 0.25f);
                trail(transform, 2, -3.2f, 2.5f, -6.6f, 0.15f);
                trail(transform, 3, 3.2f, 2.5f, -6.6f, 0.15f);

                // Smoke
                float power = getEnginePower();
                if (power > 0.05) {
                    Vector4f p = transformPosition(transform, 0.5f * (tickCount % 2 == 0 ? -1.0f : 1.0f), 2.5f, -2.2f + 0.8f * ((tickCount / 2.0f) % 2));
                    Vector3f vel = transformVector(normalTransform, 0.2f * (tickCount % 2 == 0 ? -1.0f : 1.0f), 0.0f, 0.0f);
                    Vec3 velocity = getDeltaMovement();
                    level().addParticle(ParticleTypes.LARGE_SMOKE, p.x(), p.y(), p.z(), vel.x() + velocity.x, vel.y() + velocity.y, vel.z() + velocity.z);
                }
            } else {
                trails.get(0).add(ZERO_VEC4, ZERO_VEC4, 0.0f);
                trails.get(1).add(ZERO_VEC4, ZERO_VEC4, 0.0f);
            }
        }
    }

    @Override
    public double getZoom() {
        return 12.0;
    }
}
