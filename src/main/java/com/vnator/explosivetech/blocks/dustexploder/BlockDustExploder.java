package com.vnator.explosivetech.blocks.dustexploder;

import com.vnator.explosivetech.blocks.BlockTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockDustExploder extends BlockTileEntity<TileEntityDustExploder>{
	public BlockDustExploder() {
		super(Material.ROCK, "dustexploder");
	}

	@Override
	public Class<TileEntityDustExploder> getTileEntityClass() {
		return null;
	}

	@Nullable
	@Override
	public TileEntityDustExploder createTileEntity(World world, IBlockState state) {
		return null;
	}
}
