package com.goldenagetycoon.licenses.items;

import com.goldenagetycoon.licenses.Licenses;
import com.goldenagetycoon.licenses.init.ModItems;
import com.goldenagetycoon.licenses.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
    {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Licenses.tab);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Licenses.proxy.registerItemRenderer(this, 0 );
    }


}
