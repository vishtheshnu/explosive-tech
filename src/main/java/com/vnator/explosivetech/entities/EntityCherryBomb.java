package com.vnator.explosivetech.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityCherryBomb extends EntityThrownExplosive {
	public EntityCherryBomb(World world){
		super(world);
	}

	public EntityCherryBomb(World world, EntityLivingBase entity) {
		super(world, entity, 1, 49, 1.5f);
	}


}
