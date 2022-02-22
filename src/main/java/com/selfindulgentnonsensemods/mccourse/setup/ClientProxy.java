package com.selfindulgentnonsensemods.mccourse.setup;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.block.ModBlocks;
import net.minecraft.client.Minecraft;
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
    }
    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
