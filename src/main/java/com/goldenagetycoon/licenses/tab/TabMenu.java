package com.goldenagetycoon.licenses.tab;

import com.goldenagetycoon.licenses.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class TabMenu extends CreativeTabs {

    public TabMenu(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.TESTITEM);
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        super.displayAllRelevantItems(items);

    }
}
