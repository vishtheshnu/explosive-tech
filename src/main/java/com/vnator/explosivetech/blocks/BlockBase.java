package com.vnator.explosivetech.blocks;

import com.vnator.explosivetech.ExplosiveTech;
import com.vnator.explosivetech.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

	protected String name;

	public BlockBase(Material material, String name){
		super(material);

		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		ModBlocks.blockList.add(this);
		ModBlocks.blockItemList.add(createItemBlock());
		setCreativeTab(ExplosiveTech.creativeTab);
	}

	public void registerItemModel(Item itemBlock){
		ExplosiveTech.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	public Item createItemBlock(){
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public BlockBase setCreativeTab(CreativeTabs tab){
		super.setCreativeTab(tab);
		return this;
	}
}
