package com.vnator.explosivetech.items;

import net.minecraft.item.ItemStack;

public class Saltpeter extends ItemBase {
	public Saltpeter() {
		super("saltpeter");
	}

	@Override
	public int getItemBurnTime(ItemStack stack){
		return 100;
	}
}
