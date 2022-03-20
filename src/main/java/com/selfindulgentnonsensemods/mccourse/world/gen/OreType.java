package com.selfindulgentnonsensemods.mccourse.world.gen;

import com.selfindulgentnonsensemods.mccourse.block.ModBlocks;
import net.minecraft.block.Block;

public enum OreType {
    YOURMOM(ModBlocks.YOURMOM_ORE.get(),5,0, 96); // min + maxHeight define Spawn Area, maxVeinSize defines amount of veins per chunk

    private final Block block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Block block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Block getResource() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}
