package com.goldenagetycoon.licenses.util.events;

import com.goldenagetycoon.licenses.Licenses;

import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Config;

public class GameEvent {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(Licenses.MODID)) {
			ConfigManager.sync(Licenses.MODID, Config.Type.INSTANCE);
		}
	}
}
