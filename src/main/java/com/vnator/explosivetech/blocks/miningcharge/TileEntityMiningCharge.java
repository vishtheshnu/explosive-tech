package com.vnator.explosivetech.blocks.miningcharge;

import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class TileEntityMiningCharge extends TileEntity implements ITickable {

	public static final float COUNTDOWN = 100f;
	public static final int RADIUS = 5;
	public static final int DEPTH = 2;

	private boolean activated;
	private float timeActivated;
	private BlockPos center;
	private int explosionStage;

	public TileEntityMiningCharge(){
		activated = false;
		timeActivated = 0;
		explosionStage = 0;
	}

	@Override
	public void update() {
		if(world.isRemote)
			return;


		if(activated){
			System.out.println("Time elapsed: "+(world.getWorldTime()-timeActivated));
			if(world.getWorldTime() > timeActivated + COUNTDOWN){
				System.out.println("Boom!");
				explosionProcess();
				//world.createExplosion(null, center.getX(), center.getY(), center.getZ(), 5, true);

			}
		}
	}

	public void activate(EnumFacing face){
		System.out.println("Priming mining charge");
		activated = true;
		timeActivated = world.getWorldTime();
		switch(face){
			case DOWN: center = new BlockPos(pos.add(0, RADIUS+1, 0)); break;
			case UP: center = new BlockPos(pos.add(0, -RADIUS-1, 0)); break;
			case SOUTH: center = new BlockPos(pos.add(0, 0, -RADIUS-1)); break;
			case NORTH: center = new BlockPos(pos.add(0, 0, RADIUS+1)); break;
			case EAST: center = new BlockPos(pos.add(-RADIUS-1, 0, 0)); break;
			case WEST: center = new BlockPos(pos.add(RADIUS+1, 0, 0)); break;
		}
	}

	private void explosionProcess(){
		if(explosionStage > RADIUS) {
			collectItems();
			activated = false;
			world.destroyBlock(pos, false);
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 1, true);
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
		world.createExplosion(null, center.getX(), center.getY(), center.getZ(), 0, true);
	}

	private void breakBlock(int x, int y, int z){
		BlockPos target = new BlockPos(center.getX()+x, center.getY()+y, center.getZ()+z);
		float hardness = world.getBlockState(target).getBlockHardness(world, target);
		if (hardness >= 0 && hardness <= 49) {
			world.destroyBlock(target, true);
		}
	}

	private void collectItems(){
		AxisAlignedBB box = new AxisAlignedBB(
				center.getX()-RADIUS-1,
				center.getY()-RADIUS-1,
				center.getZ()-RADIUS-1,
				center.getX()+RADIUS+1,
				center.getY()+RADIUS+1,
				center.getZ()+RADIUS+1);
		List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, box);
		for(EntityItem i : items){
			i.setPosition(center.getX(), center.getY(), center.getZ());
		}
	}
}
