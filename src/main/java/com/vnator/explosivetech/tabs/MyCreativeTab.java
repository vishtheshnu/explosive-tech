package com.vnator.explosivetech.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MyCreativeTab extends CreativeTabs {

    public MyCreativeTab(String label){
        super("explosive-tech");
        //this.setBackgroundImageName("adminshop.png"); //image saved as tab_adminshop.png

    }

    @Override
    public ItemStack getTabIconItem() {
        return null; //TODO return new item stack w/ item to display as icon
    }
}
