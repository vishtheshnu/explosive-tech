package com.vnator.explosivetech.blocks.miningcharge;

import com.vnator.explosivetech.blocks.BlockTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockMiningCharge extends BlockTileEntity<TileEntityMiningCharge> {
	public BlockMiningCharge() {
		super(Material.ROCK, "miningcharge");
	}

	@Override
	public Class getTileEntityClass() {
		return TileEntityMiningCharge.class;
	}

	@Nullable
	@Override
	public TileEntityMiningCharge createTileEntity(World world, IBlockState state) {
		return new TileEntityMiningCharge();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
									EnumFacing side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			TileEntityMiningCharge tile = getTileEntity(world, pos);
			tile.activate(side);
		}

		return true;
	}
}
