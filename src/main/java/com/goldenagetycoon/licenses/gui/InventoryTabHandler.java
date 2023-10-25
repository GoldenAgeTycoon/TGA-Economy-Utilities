package com.goldenagetycoon.licenses.gui;

import codersafterdark.reskillable.client.gui.GuiAbilities;
import codersafterdark.reskillable.client.gui.GuiSkillInfo;
import codersafterdark.reskillable.client.gui.GuiSkills;
import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;


import com.goldenagetycoon.licenses.Licenses;
import com.goldenagetycoon.licenses.config.ModConfigViewer;
import com.goldenagetycoon.licenses.gui.button.GuiButtonInventoryTab2;
import com.goldenagetycoon.licenses.gui.button.GuiButtonInventoryTab2.TabType;
import com.goldenagetycoon.licenses.util.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collections;
import java.util.List;

public class InventoryTabHandler {

	public static String tooltip;
	public static int mx, my;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void initGui(GuiScreenEvent.InitGuiEvent.Post event) {

		if (Licenses.Reskillable) {
			if (event.getGui() instanceof GuiInventory || event.getGui() instanceof GuiContainerCreative
					|| event.getGui() instanceof GuiSkills || event.getGui() instanceof GuiSkillInfo
					|| event.getGui() instanceof GuiAbilities) {

				addTabs(event.getGui(), event.getButtonList());
			}
		} else {
			if (event.getGui() instanceof GuiInventory || event.getGui() instanceof GuiContainerCreative) {
				addTabs(event.getGui(), event.getButtonList());
			}
		}
	}

	public static void addTabs(GuiScreen currScreen, List<GuiButton> buttonList) {

		int x = currScreen.width / 2 - 120;
		int y = currScreen.height / 2 - 65;

		if (currScreen instanceof GuiContainerCreative) {
			x -= 10;
			y += 15;
		}

		buttonList.add(new GuiButtonInventoryTab2(82934, x, y, TabType.INVENTORY,
				gui -> gui instanceof GuiInventory || gui instanceof GuiContainerCreative));
		if (Licenses.Reskillable) {
			buttonList.add(new GuiButtonInventoryTab(82932, x, y + 29, GuiButtonInventoryTab.TabType.SKILLS,
					gui -> gui instanceof GuiSkills || gui instanceof GuiSkillInfo));
			buttonList.add(new GuiButtonInventoryTab(82933, x, y + 58, GuiButtonInventoryTab.TabType.ABILITIES,
					gui -> gui instanceof GuiAbilities));
		}
		buttonList.add(new GuiButtonInventoryTab2(82934, x, y + ModConfigViewer.stageTabYoffset, TabType.STAGES,
				gui -> gui instanceof GuiStages));

	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void performAction(GuiScreenEvent.ActionPerformedEvent.Pre event) {
		if (event.getButton() instanceof GuiButtonInventoryTab2) {
			GuiButtonInventoryTab2 tab = (GuiButtonInventoryTab2) event.getButton();
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.player;

			switch (tab.type) {
			case INVENTORY:
				System.out.println("INVENTORY");
				mc.displayGuiScreen(new GuiInventory(mc.player));
				break;
			case STAGES:
				System.out.println("STAGES");
				mc.displayGuiScreen(new GuiStages(player));
				break;
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void finishRenderTick(RenderTickEvent event) {
		if (event.phase == Phase.END && tooltip != null) {
			RenderHelper.renderTooltip(mx, my, Collections.singletonList(tooltip));
			tooltip = null;
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onPotionShiftEvent(GuiScreenEvent.PotionShiftEvent event) {
		event.setCanceled(true);
	}

	public static int getPotionOffset() {
		return 156;
	}
}
