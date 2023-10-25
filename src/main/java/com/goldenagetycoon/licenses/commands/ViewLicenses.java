package com.goldenagetycoon.licenses.commands;

import net.darkhax.gamestages.GameStageHelper;
import net.darkhax.gamestages.data.IStageData;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Collection;
import java.util.Iterator;


public class ViewLicenses extends CommandBase {
    @Override
    public String getName() {
        return "licensesview";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "licensesview <player>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

            if(args.length < 1) return;
            String s = args[0];

            EntityPlayer player2 = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(s);
            if(player2 == null) {
                 sender.sendMessage(new TextComponentString("This player is not in game"));
                 return;
            }
            IStageData data = GameStageHelper.getPlayerData(player2);

            Collection<String> licenses = data.getStages();

            String licenseString = assembleList(licenses);

            sender.sendMessage(new TextComponentString("This users currently has the following licenses: "+ licenseString));
            return;

    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }


    private String assembleList(Collection<String> i) {
   String licenseString = "";

            for(String str  : i) {
                if(str == "heavy_machinery"){
                    licenseString += "\u00a72Heavy Machinery\u00a7r ";
                }else if(str == "complex_machinery"){
                       licenseString += "\u00a73Complex Machinery\u00a7r ";
                }else if(str == "oil_processing"){
                       licenseString += "\u00a74Oil Processing\u00a7r ";
                }else if(str == "mining"){
                       licenseString += "\u00a75Mining\u00a7r ";
                }else if(str == "agriculture"){
                       licenseString += "\u00a76Agriculture\u00a7r ";
                }else if(str == "forestry"){
                     licenseString += "\u00a79Forestry\u00a7r ";
                }
            }

            return licenseString;

    }
}
