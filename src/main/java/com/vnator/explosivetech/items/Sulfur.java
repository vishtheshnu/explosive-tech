package com.vnator.explosivetech.items;

import net.minecraft.item.ItemStack;

public class Sulfur extends ItemBase {
	public Sulfur() {
		super("sulfur");
	}

	@Override
	public int getItemBurnTime(ItemStack stack){
		return 400;
	}
}
