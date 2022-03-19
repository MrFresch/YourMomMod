package com.selfindulgentnonsensemods.mccourse.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.container.TotemSummoningStationContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.apache.logging.log4j.LogManager;

public class TotemSummoningStationScreen extends ContainerScreen<TotemSummoningStationContainer>
{

    private final ResourceLocation GUI = new ResourceLocation(MCCourseMod.MOD_ID,
            "textures/gui/totem_summoning_station_gui.png");

    public TotemSummoningStationScreen(TotemSummoningStationContainer container, PlayerInventory inv, ITextComponent name)
    {
        super(container, inv, name);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }


    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
        LogManager.getLogger().debug("EL: " + container.getProgress());
        drawString(matrixStack, Minecraft.getInstance().fontRenderer,"Progress: " +
                container.getProgress(), 5, 5, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        this.blit(matrixStack, i + 0, j + 166, 44, 35, 0 + container.getProgress(), 16);
    }
}

// 0 + container.getProgress()