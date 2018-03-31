package com.vnator.explosivetech.items;

import net.minecraft.item.ItemStack;

public class FirePowder extends ItemBase {
	public FirePowder() {
		super("firepowder");
	}

	@Override
	public int getItemBurnTime(ItemStack stack){
		return 6400;
	}
}
