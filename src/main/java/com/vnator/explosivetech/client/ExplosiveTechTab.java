package com.vnator.explosivetech.client;

import com.vnator.explosivetech.ExplosiveTech;
import com.vnator.explosivetech.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExplosiveTechTab extends CreativeTabs {

	public ExplosiveTechTab(){
		super(ExplosiveTech.MODID);
	}

	@Override
	public ItemStack getTabIconItem(){
		return new ItemStack(Item.getByNameOrId("minecraft:stone"));
	}
}
