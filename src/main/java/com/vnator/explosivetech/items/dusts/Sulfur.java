package com.vnator.explosivetech.items.dusts;

import com.vnator.explosivetech.items.ItemBase;
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
