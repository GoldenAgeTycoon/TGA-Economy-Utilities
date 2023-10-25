package com.goldenagetycoon.licenses.init;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
   // public static final Fluid TEST_FLUID = new FluidBase("test_fluid", new ResourceLocation("questitems:blocks/testfluid_still"), new ResourceLocation("questitems:blocks/testfluid_flow"));



    public static void registerFluids()
    {

    }

    public static void registerFluid(Fluid fluid)
    {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }
}
