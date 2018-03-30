package com.vnator.explosivetech.items;

import com.vnator.explosivetech.ExplosiveTech;
import com.vnator.explosivetech.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name){
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        ModItems.itemsList.add(this);
        setCreativeTab(ExplosiveTech.creativeTab);
    }

    public void registerItemModel(){
        ExplosiveTech.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}
