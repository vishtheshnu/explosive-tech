package com.vnator.explosivetech.items.dusts;

import com.vnator.explosivetech.items.ItemBase;
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
