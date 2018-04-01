package com.vnator.explosivetech.blocks.explosionbore;

import com.vnator.explosivetech.blocks.BlockTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockExplosionBore extends BlockTileEntity<TileEntityExplosionBore> {
	public BlockExplosionBore() {
		super(Material.ROCK, "explosionbore");
	}

	@Override
	public Class<TileEntityExplosionBore> getTileEntityClass() {
		return TileEntityExplosionBore.class;
	}

	@Nullable
	@Override
	public TileEntityExplosionBore createTileEntity(World world, IBlockState state) {
		return new TileEntityExplosionBore();
	}
}
