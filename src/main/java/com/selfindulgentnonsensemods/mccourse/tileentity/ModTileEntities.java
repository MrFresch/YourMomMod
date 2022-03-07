package com.selfindulgentnonsensemods.mccourse.tileentity;

import com.selfindulgentnonsensemods.mccourse.block.ModBlocks;
import com.selfindulgentnonsensemods.mccourse.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities
{
    public static final RegistryObject<TileEntityType<TotemSummoningStationTile>> TOTEM_SUMMONING_STATION_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register("totem_summoning_station_tile_entity",
            () -> TileEntityType.Builder.create(
            () -> new TotemSummoningStationTile(), ModBlocks.TOTEM_SUMMONING_STATION.get()).build(null));

    public static void register() {}
}
