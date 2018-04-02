package com.vnator.explosivetech.blocks.explosionbore;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityExplosionBore extends TileEntity implements ITickable{

	public Item[] VALID_FUELS = {Item.getByNameOrId("minecraft:gunpowder")};
	private ItemStackHandler inventory = new ItemStackHandler(1);

	@Override
	public void update() {
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound.setTag("inventory", inventory.serializeNBT());
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound){
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		super.readFromNBT(compound);
	}
}
