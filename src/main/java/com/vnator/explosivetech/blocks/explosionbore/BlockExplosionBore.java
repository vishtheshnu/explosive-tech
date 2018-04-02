package com.vnator.explosivetech.blocks.explosionbore;

import com.vnator.explosivetech.blocks.BlockTileEntity;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockExplosionBore extends BlockTileEntity<TileEntityExplosionBore> {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

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

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state){
		super.onBlockAdded(worldIn, pos, state);
	}

	public static EnumFacing getFacing(int meta){

		return EnumFacing.getFront(meta & 7);
	}

}
