package com.vnator.explosivetech;

import com.vnator.explosivetech.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<ItemBase> itemsList = new ArrayList<ItemBase>();

	//public static FirstItem firstItem = new FirstItem();

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
