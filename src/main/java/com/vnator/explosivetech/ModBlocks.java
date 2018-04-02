package com.vnator.explosivetech;

import com.vnator.explosivetech.blocks.BlockBase;
import com.vnator.explosivetech.blocks.BlockTileEntity;
import com.vnator.explosivetech.blocks.explosionbore.BlockExplosionBore;
import com.vnator.explosivetech.blocks.miningcharge.BlockMiningCharge;
import com.vnator.explosivetech.blocks.ores.PhosphorusOre;
import com.vnator.explosivetech.blocks.ores.SaltpeterOre;
import com.vnator.explosivetech.blocks.ores.SulfurOre;
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

	public static SulfurOre sulfurOre = new SulfurOre();
	public static SaltpeterOre saltpeterOre = new SaltpeterOre();
	public static PhosphorusOre phosphorusOre = new PhosphorusOre();

	public static BlockMiningCharge miningCharge = new BlockMiningCharge();
	public static BlockExplosionBore explosionBore = new BlockExplosionBore();

    public static void register(RegistryEvent.Register<Block> event){
		event.getRegistry().registerAll(blockList.toArray(new BlockBase[0]));
		System.out.println("registering blocks; # blocks: "+blockList.size());
		for(BlockTileEntity te : blockTEList){
			GameRegistry.registerTileEntity(te.getTileEntityClass(), te.getRegistryName().toString());
		}
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		event.getRegistry().registerAll(blockItemList.toArray(new Item[0]));
    }

    public static void registerModels(){
		for(BlockBase b : blockList){
			b.registerItemModel(Item.getItemFromBlock(b));
		}
    }
}
