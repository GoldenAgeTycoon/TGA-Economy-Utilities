package com.goldenagetycoon.licenses;



import com.goldenagetycoon.licenses.proxy.CommonProxy;
import com.goldenagetycoon.licenses.tab.TabMenu;
import com.goldenagetycoon.licenses.util.Reference;
import com.goldenagetycoon.licenses.util.events.GameEvent;
import com.goldenagetycoon.licenses.util.handlers.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = Licenses.MODID, name = Licenses.NAME, version = Licenses.VERSION)
public class Licenses
{  
    public static boolean Reskillable = false;
    public static final String MODID = "licenses";
    public static final String NAME = "TGA - Licenses";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    static { FluidRegistry.enableUniversalBucket(); }

    public static final TabMenu tab = new TabMenu("licensesTab");

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries(event);
        if(Loader.isModLoaded("reskillable")) {
            Licenses.Reskillable = true;
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GameEvent());
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
