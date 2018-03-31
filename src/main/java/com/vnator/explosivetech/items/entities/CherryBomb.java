package com.vnator.explosivetech.items.entities;

import com.vnator.explosivetech.entities.EntityCherryBomb;
import com.vnator.explosivetech.entities.EntityMiningStick;
import com.vnator.explosivetech.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CherryBomb extends ItemBase {
	public CherryBomb() {
		super("cherrybomb");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack itemStack = player.getHeldItem(hand);
		if(!player.capabilities.isCreativeMode)
			itemStack.shrink(1);

		if(!world.isRemote){
			EntityCherryBomb bomb = new EntityCherryBomb(world, player);
			bomb.shoot(player, player.rotationPitch, player.rotationYaw, 0f, 1.5f, 0f);
			world.spawnEntity(bomb);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
	}
}
