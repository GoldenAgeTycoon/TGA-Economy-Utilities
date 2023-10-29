package com.goldenagetycoon.licenses.items;

import com.goldenagetycoon.licenses.Licenses;
import com.goldenagetycoon.licenses.init.ModItems;
import com.goldenagetycoon.licenses.util.IHasModel;
import com.goldenagetycoon.licenses.util.functions;
import net.darkhax.gamestages.GameStageHelper;
import net.darkhax.gamestages.data.IStageData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class License extends ItemSimpleFoiled implements IHasModel
{

    public License(String name)
    {

        setTranslationKey(name);
         setRegistryName(name);
        setCreativeTab(Licenses.tab);
      setMaxStackSize(1);
        ModItems.ITEMS.add(this);

    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> Lore, ITooltipFlag flagIn)
    {
        if (ModItems.HEAVY_MACHINERY.equals(this)) {
            super.addInformation(stack, worldIn, Lore, ITooltipFlag.TooltipFlags.ADVANCED);
            Lore.add("\u00a7rThis is a \u00a7lPRIMARY\u00a7r license and will");
            Lore.add("\u00a7rcount towards your license limit");
        }
        if (ModItems.CULINARY.equals(this)) {
            super.addInformation(stack, worldIn, Lore, ITooltipFlag.TooltipFlags.ADVANCED);
            Lore.add("\u00a7rThis is a \u00a7lPRIMARY\u00a7r license and will");
            Lore.add("\u00a7rcount towards your license limit");
        }
        if (ModItems.COMPLEX_MACHINERY.equals(this)) {
            super.addInformation(stack, worldIn, Lore, ITooltipFlag.TooltipFlags.ADVANCED);
            Lore.add("\u00a7rThis is a \u00a7lSECONDARY\u00a7r license and will");
            Lore.add("\u00a7r\u00a7lNOT\u00a7r count towards your license limit");
        }
        if (ModItems.OIL_PROCESSING.equals(this)) {
            super.addInformation(stack, worldIn, Lore, ITooltipFlag.TooltipFlags.ADVANCED);
            Lore.add("\u00a7rThis is a \u00a7lPRIMARY\u00a7r license and will");
            Lore.add("\u00a7rcount towards your license limit");
        }
        if (ModItems.MINING.equals(this)) {
            super.addInformation(stack, worldIn, Lore, ITooltipFlag.TooltipFlags.ADVANCED);
            Lore.add("\u00a7rThis is a \u00a7lPRIMARY\u00a7r license and will");
            Lore.add("\u00a7rcount towards your license limit");
        }
        if (ModItems.AGRICULTURE.equals(this)) {
            super.addInformation(stack, worldIn, Lore, ITooltipFlag.TooltipFlags.ADVANCED);
            Lore.add("\u00a7rThis is a \u00a7lPRIMARY\u00a7r license and will");
            Lore.add("\u00a7rcount towards your license limit");

        }
        if (ModItems.FORESTRY.equals(this)) {
            super.addInformation(stack, worldIn, Lore, ITooltipFlag.TooltipFlags.ADVANCED);
            Lore.add("\u00a7rThis is a \u00a7lPRIMARY\u00a7r license and will");
            Lore.add("\u00a7rcount towards your license limit");
        }
    }

    @Override
    public void registerModels()
    {
        Licenses.proxy.registerItemRenderer(this, 0 );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack item = playerIn.getHeldItem(handIn);
        IStageData data = GameStageHelper.getPlayerData(playerIn);



         System.out.println(data.getStages());

         List<String> PrimaryLicenses = new ArrayList<>(Arrays.asList("heavy_machinery", "oil_processing", "mining", "agriculture", "forestry"));

         Collection<String> licenses = data.getStages();
         Boolean max_licenses = functions.listCheck(PrimaryLicenses,  licenses);


         if (ModItems.HEAVY_MACHINERY.equals(this)) {
             if(max_licenses) {
                 if(!world.isRemote)    playerIn.sendStatusMessage(new TextComponentString("You are at your max license count, you cannot redeem any more!"), true);
                 return new ActionResult<>(EnumActionResult.FAIL, item);
             }
             if(!data.getStages().contains("heavy_machinery")){
                 playerIn.setHeldItem(handIn, ItemStack.EMPTY);
                 GameStageHelper.addStage(playerIn, "heavy_machinery");
                    GameStageHelper.syncPlayer(playerIn);
                if(!world.isRemote) playerIn.sendStatusMessage(new TextComponentString("You now have the \u00a7l\u00a72Heavy Machinery\u00a7r license!"), true);
                 return new ActionResult<>(EnumActionResult.SUCCESS, item);
             }
             if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You already have this license!"), true);
             return new ActionResult<>(EnumActionResult.FAIL, item);
         }
         if (ModItems.COMPLEX_MACHINERY.equals(this)) {
             if(!data.getStages().contains("complex_machinery")){
                 playerIn.setHeldItem(handIn, ItemStack.EMPTY);
                 GameStageHelper.addStage(playerIn, "complex_machinery");
                    GameStageHelper.syncPlayer(playerIn);
                 if(!world.isRemote)  playerIn.sendStatusMessage(new TextComponentString("You now have the \u00a7l\u00a73Complex Machinery\u00a7r license!"), true);
                 return new ActionResult<>(EnumActionResult.SUCCESS, item);
             }
             if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You already have this license!"), true);
             return new ActionResult<>(EnumActionResult.FAIL, item);
         }
         if (ModItems.OIL_PROCESSING.equals(this)) {
             if(max_licenses) {
                 if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You are at your max license count, you cannot redeem any more!"), true);
                 return new ActionResult<>(EnumActionResult.FAIL, item);
             }
             if(!data.getStages().contains("oil_processing")){

                 playerIn.setHeldItem(handIn, ItemStack.EMPTY);
                 GameStageHelper.addStage(playerIn, "oil_processing");
                    GameStageHelper.syncPlayer(playerIn);
                 if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You now have the \u00a7l\u00a74Oil Processing\u00a7r license!"), true);
                 return new ActionResult<>(EnumActionResult.SUCCESS, item);
             }
             if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You already have this license!"), true);
             return new ActionResult<>(EnumActionResult.FAIL, item);
         }
        if (ModItems.CULINARY.equals(this)) {
            if(max_licenses) {
                if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You are at your max license count, you cannot redeem any more!"), true);
                return new ActionResult<>(EnumActionResult.FAIL, item);
            }
            if(!data.getStages().contains("culinary")){

                playerIn.setHeldItem(handIn, ItemStack.EMPTY);
                GameStageHelper.addStage(playerIn, "culinary");
                GameStageHelper.syncPlayer(playerIn);
                if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You now have the \u00a7l\u00a7dCulinary\u00a7r license!"), true);
                return new ActionResult<>(EnumActionResult.SUCCESS, item);
            }
            if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You already have this license!"), true);
            return new ActionResult<>(EnumActionResult.FAIL, item);
        }
         if (ModItems.MINING.equals(this)) {
             if(max_licenses) {
                 if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You are at your max license count, you cannot redeem any more!"), true);
                 return new ActionResult<>(EnumActionResult.FAIL, item);
             }
             if(!data.getStages().contains("mining")){
                 playerIn.setHeldItem(handIn, ItemStack.EMPTY);
                 GameStageHelper.addStage(playerIn, "mining");
                    GameStageHelper.syncPlayer(playerIn);
                 if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You now have the \u00a7l\u00a75Mining\u00a7r license!"), true);
                 return new ActionResult<>(EnumActionResult.SUCCESS, item);
             }
             if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You already have this license!"), true);
             return new ActionResult<>(EnumActionResult.FAIL, item);
         }
         if (ModItems.AGRICULTURE.equals(this)) {
             if(max_licenses) {
                 if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You are at your max license count, you cannot redeem any more!"), true);
                 return new ActionResult<>(EnumActionResult.FAIL, item);
             }
             if(!data.getStages().contains("agriculture")){
                 playerIn.setHeldItem(handIn, ItemStack.EMPTY);
                 GameStageHelper.addStage(playerIn, "agriculture");
                    GameStageHelper.syncPlayer(playerIn);
                 if(!world.isRemote)  playerIn.sendStatusMessage(new TextComponentString("you now have the \u00a7l\u00a76Agriculture\u00a7r license!"), true);
                 return new ActionResult<>(EnumActionResult.SUCCESS, item);
             }
             if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You already have this license!"), true);
             return new ActionResult<>(EnumActionResult.FAIL, item);
         }
         if (ModItems.FORESTRY.equals(this)) {
             if(max_licenses) {
                 if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You are at your max license count, you cannot redeem any more!"), true);
                 return new ActionResult<>(EnumActionResult.FAIL, item);
             }
             if(!data.getStages().contains("forestry")){
                 playerIn.setHeldItem(handIn, ItemStack.EMPTY);
                 GameStageHelper.addStage(playerIn, "forestry");
                    GameStageHelper.syncPlayer(playerIn);
                 if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You now have the \u00a7l\u00a79Forestry\u00a7r license!"), true);
                 return new ActionResult<>(EnumActionResult.SUCCESS, item);
             }
             if(!world.isRemote)     playerIn.sendStatusMessage(new TextComponentString("You already have this license!"), true);
             return new ActionResult<>(EnumActionResult.FAIL, item);
         }



        return new ActionResult<>(EnumActionResult.FAIL, item);
    }



}
