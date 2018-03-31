package com.vnator.explosivetech.items.entities;

import com.vnator.explosivetech.entities.EntityMiningStick;
import com.vnator.explosivetech.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MiningStick extends ItemBase {
	public MiningStick() {
		super("miningstick");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack itemStack = player.getHeldItem(hand);
		System.out.println("spawning EntityMiningStick!");
		if(!player.capabilities.isCreativeMode)
			itemStack.shrink(1);

		if(!world.isRemote){
			EntityMiningStick stick = new EntityMiningStick(world, player);
			//Vec3d dir = player.getLookVec();
			//stick.motionX = dir.x*50;
			//stick.motionY = dir.y*50;
			//stick.motionZ = dir.z*50;
			stick.shoot(player, player.rotationPitch, player.rotationYaw, 0f, 1.5f, 0f);
			world.spawnEntity(stick);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
	}
}
