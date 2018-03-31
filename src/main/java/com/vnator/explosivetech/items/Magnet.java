package com.vnator.explosivetech.items;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class Magnet extends ItemBase{
	public Magnet() {
		super("magnet");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		AxisAlignedBB box = new AxisAlignedBB(player.posX-5, player.posY-5, player.posZ-5,
				player.posX+5, player.posY+5, player.posZ+5);
		List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, box);
		for(EntityItem i : items){
			i.setPosition(player.posX, player.posY, player.posZ);
		}

		ItemStack itemStack = player.getHeldItem(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
	}
}
