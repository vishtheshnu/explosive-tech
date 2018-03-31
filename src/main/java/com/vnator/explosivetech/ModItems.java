package com.vnator.explosivetech;

import com.vnator.explosivetech.items.*;
import com.vnator.explosivetech.items.dusts.FirePowder;
import com.vnator.explosivetech.items.dusts.Phosphorus;
import com.vnator.explosivetech.items.dusts.Saltpeter;
import com.vnator.explosivetech.items.dusts.Sulfur;
import com.vnator.explosivetech.items.entities.MiningStick;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<ItemBase> itemsList = new ArrayList<ItemBase>();

	//public static FirstItem firstItem = new FirstItem();
	public static Sulfur sulfur = new Sulfur();
	public static Phosphorus phosphorus = new Phosphorus();
	public static Saltpeter saltpeter = new Saltpeter();
	public static FirePowder firePowder = new FirePowder();
	public static MiningStick miningStick = new MiningStick();
	public static Magnet magnet = new Magnet();

	public static void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().registerAll(itemsList.toArray(new Item[0]));
	}

	public static void registerModels(){
		System.out.println("Number of Items: "+itemsList.size());
		for(ItemBase i : itemsList){
			i.registerItemModel();
		}
	}
}
