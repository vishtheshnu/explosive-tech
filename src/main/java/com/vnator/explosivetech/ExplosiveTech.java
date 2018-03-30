package com.vnator.explosivetech;

import com.vnator.explosivetech.client.ExplosiveTechTab;
import com.vnator.explosivetech.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
@Mod(modid = ExplosiveTech.MODID, name = ExplosiveTech.NAME, version = ExplosiveTech.VERSION)
public class ExplosiveTech
{
    public static final String MODID = "explosive-tech";
    public static final String NAME = "Explosive Tech";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.vnator.explosivetech.proxy.ClientProxy", serverSide = "com.vnator.explosivetech.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ExplosiveTech instance;

    public static final ExplosiveTechTab creativeTab = new ExplosiveTechTab();

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        System.out.println(NAME+" is loading!");
        proxy.preInit(event);
       // NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);

        //Test
        logger.log(Level.INFO, "Water = "+ FluidRegistry.LAVA.getName());
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler{

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event){
            ModItems.registerItems(event);
            ModBlocks.registerItemBlocks(event);
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event){
            ModBlocks.register(event);
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event){
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }

}
