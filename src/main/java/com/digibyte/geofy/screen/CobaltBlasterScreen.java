package com.digibyte.geofy.screen;

import com.digibyte.geofy.GeofyMod;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CobaltBlasterScreen extends AbstractContainerScreen<CobaltBlasterMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(GeofyMod.MOD_ID, "textures/gui/cobalt_blaster_gui.png");

    public CobaltBlasterScreen(CobaltBlasterMenu pMenu, Inventory pPlayerInventory, Component pTitle){
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseSTack, float pPartialTicks, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseSTack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()){
            blit(pPoseSTack, x + 84, y + 22, 176, 14, menu.getScaledProgress(), 36);
        }

        if(menu.hasFuel()){
            blit(pPoseSTack, x + 18, y + 33 + 14 - menu.getScaledFuelProgress(), 176,
                    14 - menu.getScaledFuelProgress(), 14, menu.getScaledFuelProgress());
        }


    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {

        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
