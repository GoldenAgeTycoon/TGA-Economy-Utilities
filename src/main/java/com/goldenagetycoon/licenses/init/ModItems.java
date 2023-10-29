package com.goldenagetycoon.licenses.init;

import com.goldenagetycoon.licenses.items.License;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final License TESTITEM = new License("example_license" );
    public static final License HEAVY_MACHINERY = new License("heavy_machinery" );
    public static final License COMPLEX_MACHINERY = new License("complex_machinery" );
    public static final License OIL_PROCESSING = new License("oil_processing" );
    public static final License MINING = new License("mining" );
    public static final License AGRICULTURE = new License("agriculture" );
    public static final License FORESTRY = new License("forestry" );
    public static final License CULINARY = new License("culinary");
}
