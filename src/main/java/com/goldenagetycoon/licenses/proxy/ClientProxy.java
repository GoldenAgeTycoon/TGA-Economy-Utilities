package com.goldenagetycoon.licenses.proxy;

import com.goldenagetycoon.licenses.util.handlers.RenderHandler;
import com.goldenagetycoon.licenses.gui.InventoryTabHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy{
    public void registerItemRenderer(Item item, int meta)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public void registerStateMapper(){
        RenderHandler.registerCustomStateMapper();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        MinecraftForge.EVENT_BUS.register(InventoryTabHandler.class);
    }
}
