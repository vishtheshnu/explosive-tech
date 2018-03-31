package com.vnator.explosivetech.models;

import com.vnator.explosivetech.ModItems;
import com.vnator.explosivetech.entities.EntityMiningStick;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class EntityMiningStickFactory implements IRenderFactory<EntityMiningStick> {
	@SideOnly(Side.CLIENT)
	@Override
	public Render<? super EntityMiningStick> createRenderFor(RenderManager manager) {
		return new RenderSnowball<EntityMiningStick>(manager, ModItems.miningStick, Minecraft.getMinecraft().getRenderItem());
	}
}
