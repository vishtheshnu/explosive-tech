package com.vnator.explosivetech.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class EntityThrownExplosive extends EntityThrowable {

	private int MINING_RADIUS;
	private int MAX_HARDNESS;
	private float VELOCITY;

	private boolean isExploding;
	private BlockPos explosionLocation;
	private int explosionStage;

	public EntityThrownExplosive(World world) {
		super(world);
	}
	public EntityThrownExplosive(World world, EntityLivingBase entity, int radius, int hardness, float velocity){
		super(world, entity);
		this.MINING_RADIUS = radius;
		this.MAX_HARDNESS = hardness;
		this.VELOCITY = velocity;
		isExploding = false;
		explosionLocation = null;
		explosionStage = 0;
	}


	@Override
	protected void onImpact(RayTraceResult result) {
		if(world.isRemote)
			return;

		if(!isExploding){
			isExploding = true;
			explosionLocation = result.getBlockPos();
			Vec3d loc = result.hitVec;
			world.createExplosion(null, loc.x, loc.y, loc.z, 0, true);
		}

	}

	@Override
	public void onUpdate(){
		super.onUpdate();
		if(isExploding){
			explosionProcess();
		}
	}

	private void explosionProcess(){
		if(explosionStage > MINING_RADIUS) {
			collectItems();
			return;
		}

		for(int x = -explosionStage; x <= explosionStage; x++) {
			for (int y = -explosionStage; y <= explosionStage; y++) {
				for (int z = -explosionStage; z <= explosionStage; z++) {
					//Only break corners of this stage
					if(Math.abs(x) != explosionStage && Math.abs(y) != explosionStage && Math.abs(z) != explosionStage)
						continue;
					breakBlock(x, y, z);
				}
			}
		}
		explosionStage++;
	}

	private void breakBlock(int x, int y, int z){
		BlockPos target = new BlockPos(explosionLocation.getX()+x, explosionLocation.getY()+y, explosionLocation.getZ()+z);
		float hardness = world.getBlockState(target).getBlockHardness(world, target);
		if (hardness >= 0 && hardness <= MAX_HARDNESS) {
			world.destroyBlock(target, true);
		}
	}

	private void collectItems(){
		AxisAlignedBB box = new AxisAlignedBB(
				explosionLocation.getX()-MINING_RADIUS-1,
				explosionLocation.getY()-MINING_RADIUS-1,
				explosionLocation.getZ()-MINING_RADIUS-1,
				explosionLocation.getX()+MINING_RADIUS+1,
				explosionLocation.getY()+MINING_RADIUS+1,
				explosionLocation.getZ()+MINING_RADIUS+1);
		List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, box);
		for(EntityItem i : items){
			i.setPosition(explosionLocation.getX(), explosionLocation.getY(), explosionLocation.getZ());
		}
		setDead();
	}
}
