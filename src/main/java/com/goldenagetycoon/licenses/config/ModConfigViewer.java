package com.goldenagetycoon.licenses.config;

import com.goldenagetycoon.licenses.Licenses;


import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = Licenses.MODID, name = "licensesconfig", type = Type.INSTANCE)
@LangKey("config.stageviewerconfig.title")
public class ModConfigViewer {

	@LangKey(Licenses.MODID + ".config.stageguititle")
	@Comment({ "Set title of stages title gui" })
	public static String stageGuiTitle = "Game Stages";

	@LangKey(Licenses.MODID + ".config.nostagemessage")
	@Comment({ "Set the message when there is no stages" })
	public static String noStagesMessage = "No Stages";

	@LangKey(Licenses.MODID + ".config.stagestaby")
	@Comment({ "Set the Y offset of stages tab" })
	public static int stageTabYoffset = 30;
	
	@LangKey(Licenses.MODID + ".config.stagevalues")
	@Comment({ "Set stage, title and icon index \nExample: stageone:Build Master:0" })
	public static String[] newStageTitles = {"stageone:Build Master:0"};
}
