package com.vnator.explosivetech.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e){
        //File directory = e.getModConfigurationDirectory();
        //config = new Configuration(new File(directory.getPath(), "adminshop.cfg"));
        //ConfigHandler.readConfig();
		/* TODO
		PacketHandler.registerMessages("AdminShop");
        CapabilityManager.INSTANCE.register(IMoney.class, new MoneyStorage(), new MoneyFactory());
        CapabilityManager.INSTANCE.register(ILedger.class, new LedgerStorage(), new LedgerFactory());
        */
    }

    public void init(FMLInitializationEvent e){

    }

    public void postInit(FMLPostInitializationEvent e){

    }

    public String localize(String unlocalized, Object... args){
    	return I18n.translateToLocalFormatted(unlocalized, args);
	}

    /**Implemented in ClientProxy*/
    public void registerItemRenderer(Item item, int meta, String id){}
}
