package com.vnator.explosivetech.items;

import net.minecraft.item.ItemStack;

public class Phosphorus extends ItemBase {
	public Phosphorus() {
		super("phosphorus");
	}

	@Override
	public int getItemBurnTime(ItemStack stack){
		return 200;
	}
}
