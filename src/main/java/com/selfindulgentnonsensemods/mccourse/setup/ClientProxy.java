package com.selfindulgentnonsensemods.mccourse.setup;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.block.ModBlocks;
import com.selfindulgentnonsensemods.mccourse.container.ModContainers;
import com.selfindulgentnonsensemods.mccourse.screens.TotemSummoningStationScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy
{
    @Override
    public void init(){
        RenderTypeLookup.setRenderLayer(ModBlocks.TOMATO_CROP.get(), RenderType.getCutout());
        ScreenManager.registerFactory(ModContainers.TOTEM_SUMMONING_STATION_CONTAINER.get(), TotemSummoningStationScreen::new);
    }
    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
