package com.selfindulgentnonsensemods.mccourse.block;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.item.ModItems;
import com.selfindulgentnonsensemods.mccourse.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class ModFluids
{
    public static final ResourceLocation MUD_STILL_RL = new ResourceLocation(MCCourseMod.MOD_ID,
            "block/mud_still");
    public static final ResourceLocation MUD_FLOWING_RL = new ResourceLocation(MCCourseMod.MOD_ID,
            "block/mud_flowing");
    public static final ResourceLocation MUD_OVERLAY_RL = new ResourceLocation(MCCourseMod.MOD_ID,
            "block/mud_overlay");

    public static final RegistryObject<FlowingFluid> MUD_FLUID =
            Registration.FLUIDS.register("mud_fluid",
                    () -> new ForgeFlowingFluid.Source(ModFluids.MUD_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MUD_FLOWING =
            Registration.FLUIDS.register("mud_flowing",
                    () -> new ForgeFlowingFluid.Flowing(ModFluids.MUD_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MUD_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MUD_FLUID.get(), () -> MUD_FLOWING.get(), FluidAttributes.builder(MUD_STILL_RL, MUD_FLOWING_RL)
            .density(15).luminosity(0).rarity(Rarity.COMMON).sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(MUD_OVERLAY_RL)
            .viscosity(1)).slopeFindDistance(3).levelDecreasePerBlock(3)
            .block(() -> ModFluids.MUD_BLOCK.get()).bucket(() -> ModItems.MUD_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> MUD_BLOCK = Registration.BLOCKS.register("mud",
            () -> new FlowingFluidBlock(() -> ModFluids.MUD_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

    public static void register() {}
}
