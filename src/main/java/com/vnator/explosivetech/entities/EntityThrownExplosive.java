package com.vnator.explosivetech.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrownExplosive extends EntityThrowable {
	public EntityThrownExplosive(World world) {
		super(world);
	}

	public EntityThrownExplosive(World world, EntityLivingBase entity){
		super(world, entity);
	}

	public EntityThrownExplosive(World world, double x, double y, double z){
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
	}
}
