package com.vnator.explosivetech;

import com.vnator.explosivetech.blocks.BlockBase;
import com.vnator.explosivetech.blocks.BlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

	public static final List<BlockBase> blockList = new ArrayList<BlockBase>();
	public static final List<Item> blockItemList = new ArrayList<Item>();
	public static final List<BlockTileEntity> blockTEList = new ArrayList<BlockTileEntity>();


    public static void register(RegistryEvent.Register<Block> event){
		event.getRegistry().registerAll(blockList.toArray(new BlockBase[0]));
		for(BlockTileEntity te : blockTEList){
			GameRegistry.registerTileEntity(te.getTileEntityClass(), te.getRegistryName().toString());
		}
		//GameRegistry.registerTileEntity(counter.getTileEntityClass(), counter.getRegistryName().toString());
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		event.getRegistry().registerAll(blockItemList.toArray(new Item[0]));
		/*
		for(BlockBase b : blockList){
			event.getRegistry().register(b.createItemBlock());
		}
		*/
    }

    public static void registerModels(){
		for(BlockBase b : blockList){
			b.registerItemModel(Item.getItemFromBlock(b));
		}
    }
}
