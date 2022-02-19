package com.selfindulgentnonsensemods.mccourse.block;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    // Basic Blocks

    public static final RegistryObject<Block> YOURMOM_BLOCK = register("yourmom_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(10f, 10f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> YOURMOM_ORE = register("yourmom_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(1).harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(7f, 10f).sound(SoundType.STONE)));

    // Weird Blocks (Stairs, Doors, Fences, Pressure Plates and buttons)

    public static final RegistryObject<Block> YOURMOM_STAIRS =
            register("yourmom_stairs", () -> new StairsBlock(() -> ModBlocks.YOURMOM_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(10f, 10f).harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> YOURMOM_FENCE =
            register("yourmom_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(10f, 10f).setRequiresTool().harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> YOURMOM_FENCE_GATE =
            register("yourmom_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(10f, 10f).setRequiresTool().harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> YOURMOM_PRESSURE_PLATE =
            register("yourmom_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> YOURMOM_SLAB =
            register("yourmom_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(10f, 10f)
                    .setRequiresTool().harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> YOURMOM_BUTTON =
            register("yourmom_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static void register() {}

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(MCCourseMod.COURSE_TAB)));
        return toReturn;
    }
}
