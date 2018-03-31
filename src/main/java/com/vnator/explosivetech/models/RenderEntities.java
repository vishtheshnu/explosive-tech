package com.vnator.explosivetech.models;

import com.vnator.explosivetech.ModItems;
import com.vnator.explosivetech.entities.EntityCherryBomb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderEntities {

	public static final EntityCherryBombFactory factoryCherryBomb = new EntityCherryBombFactory();

	public static class EntityCherryBombFactory implements IRenderFactory<EntityCherryBomb>{
		@Override
		@SideOnly(Side.CLIENT)
		public Render<? super EntityCherryBomb> createRenderFor(RenderManager manager) {
			return new RenderSnowball<EntityCherryBomb>(manager, ModItems.cherryBomb, Minecraft.getMinecraft().getRenderItem());
		}
	}
}
