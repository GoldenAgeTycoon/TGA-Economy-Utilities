package com.goldenagetycoon.licenses.blocks;

import com.goldenagetycoon.licenses.Licenses;
import com.goldenagetycoon.licenses.init.ModBlocks;
import com.goldenagetycoon.licenses.init.ModItems;
import com.goldenagetycoon.licenses.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Licenses.tab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels()
    {
        Licenses.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}
