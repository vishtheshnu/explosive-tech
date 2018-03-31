package com.vnator.explosivetech.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EntityMiningStick extends EntityThrowable {

	private static final int MINING_RADIUS = 3;
	private static final int MAX_HARDNESS = 49;

	private boolean isExploding = false;
	private BlockPos explosionLocation;
	private int explosionStage = 0;

	public EntityMiningStick(World world) {
		super(world);
	}

	public EntityMiningStick(World world, EntityLivingBase entity){
		super(world, entity);
	}

	public EntityMiningStick(World world, double x, double y, double z){
		super(world, x, y, z);
	}

	@Override
	public void onUpdate(){
		super.onUpdate();
		if(world.isRemote)
			return;
		if(isExploding){
			if(explosionStage > MINING_RADIUS) {
				AxisAlignedBB box = new AxisAlignedBB(explosionLocation.getX()-MINING_RADIUS-1,
						explosionLocation.getY()-MINING_RADIUS-1, explosionLocation.getZ()-MINING_RADIUS-1,
						explosionLocation.getX()+MINING_RADIUS+1, explosionLocation.getY()+MINING_RADIUS+1,
						explosionLocation.getZ()+MINING_RADIUS+1);
				List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, box);
				for(EntityItem i : items){
					i.setPosition(explosionLocation.getX(), explosionLocation.getY(), explosionLocation.getZ());
				}
				setDead();
				return;
			}

			for(int x = -explosionStage; x <= explosionStage; x++) {
				for (int y = -explosionStage; y <= explosionStage; y++) {
					for (int z = -explosionStage; z <= explosionStage; z++) {
						//Only break corners of this stage
						if(Math.abs(x) != explosionStage && Math.abs(y) != explosionStage && Math.abs(z) != explosionStage)
							continue;

						BlockPos target = new BlockPos(explosionLocation.getX()+x, explosionLocation.getY()+y, explosionLocation.getZ()+z);
						float hardness = world.getBlockState(target).getBlockHardness(world, target);
						if (hardness >= 0 && hardness <= MAX_HARDNESS) {
							System.out.println("block hardness = "+world.getBlockState(target).getBlockHardness(world, target));
							world.destroyBlock(target, true);
						}
					}
				}
			}
			explosionStage++;
		}
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if(world.isRemote)
			return;

		isExploding = true;
		if(explosionLocation == null)
			explosionLocation = result.getBlockPos();
		Vec3d loc = result.hitVec;
		world.createExplosion(null, loc.x, loc.y, loc.z, 0, true);
		/*
		world.createExplosion(null, loc.x, loc.y, loc.z, 0, true);
		BlockPos corner = result.getBlockPos();
		corner = new BlockPos(corner.getX()-MINING_RADIUS, corner.getY()-MINING_RADIUS, corner.getZ()-MINING_RADIUS);
		for(int x = 0; x < 2*MINING_RADIUS+1; x++) {
			for (int y = 0; y < 2*MINING_RADIUS+1; y++) {
				for (int z = 0; z < 2*MINING_RADIUS+1; z++) {
					BlockPos target = new BlockPos(corner.getX()+x, corner.getY()+y, corner.getZ()+z);

					//world.getBlockState(target).getBlock();
					if (world.getBlockState(target).getBlockHardness(world, target) <= MAX_HARDNESS)
						world.destroyBlock(target, true);
				}
			}
		}
		AxisAlignedBB box = new AxisAlignedBB(corner.getX()-MINING_RADIUS-1, corner.getY()-MINING_RADIUS-1, corner.getZ()-MINING_RADIUS-1,
				corner.getX()+MINING_RADIUS+1, corner.getY()+MINING_RADIUS+1, corner.getZ()+MINING_RADIUS+1);
		//box.expand(MINING_RADIUS+1, MINING_RADIUS+1, MINING_RADIUS+1);
		//box.expand(-MINING_RADIUS-1, -MINING_RADIUS-1, -MINING_RADIUS-1);
		List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, box);
		for(EntityItem i : items){
			System.out.println("Mined Item: "+i.toString());
			i.setPosition(corner.getX(), corner.getY(), corner.getZ());
			System.out.println("Mined Item update: "+i.toString());
		}
		setDead();
		*/
	}
}
