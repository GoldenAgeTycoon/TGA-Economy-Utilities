package com.goldenagetycoon.licenses.util.handlers;

import com.goldenagetycoon.licenses.Licenses;
import com.goldenagetycoon.licenses.commands.ViewLicenses;
import com.goldenagetycoon.licenses.init.ModBlocks;
import com.goldenagetycoon.licenses.init.ModFluids;
import com.goldenagetycoon.licenses.init.ModItems;
import com.goldenagetycoon.licenses.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        Licenses.proxy.registerStateMapper();
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : ModItems.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }

        for(Block block : ModBlocks.BLOCKS)
        {
            if(block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }
    }

    public static void preInitRegistries(FMLPreInitializationEvent event)
    {
        ModFluids.registerFluids();

    }

    public static void serverRegistries(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new ViewLicenses());
    }
}
