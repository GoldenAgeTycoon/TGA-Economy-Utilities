package com.goldenagetycoon.licenses.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBase extends Fluid
{
    public FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing)
    {
        super(fluidName, still, flowing);
    }
}
