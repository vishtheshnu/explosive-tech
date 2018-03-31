package com.vnator.explosivetech.proxy;

import com.vnator.explosivetech.ExplosiveTech;
import com.vnator.explosivetech.ModItems;
import com.vnator.explosivetech.entities.EntityCherryBomb;
import com.vnator.explosivetech.entities.EntityMiningStick;
import com.vnator.explosivetech.models.EntityMiningStickFactory;
import com.vnator.explosivetech.models.RenderEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityCherryBomb.class, (manager) -> new RenderSnowball<>(manager, ModItems.cherryBomb, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMiningStick.class, (manager) -> new RenderSnowball<>(manager, ModItems.miningStick, Minecraft.getMinecraft().getRenderItem()));
        //RenderingRegistry.registerEntityRenderingHandler(EntityMiningStick.class, new EntityMiningStickFactory());
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ExplosiveTech.MODID+":"+id, "inventory"));
    }

    @Override
	public String localize(String unlocalized, Object... args){
    	return I18n.format(unlocalized, args);
	}
}
