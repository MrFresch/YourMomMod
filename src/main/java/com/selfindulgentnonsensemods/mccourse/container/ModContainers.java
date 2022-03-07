package com.selfindulgentnonsensemods.mccourse.container;

import com.selfindulgentnonsensemods.mccourse.util.Registration;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ModContainers
{
    public static final RegistryObject<ContainerType<TotemSummoningStationContainer>> TOTEM_SUMMONING_STATION_CONTAINER
            = Registration.CONTAINERS.register("totem_summoning_station_container",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new TotemSummoningStationContainer(windowId, world, pos, inv, inv.player);
            }));

    public static void register() { }

}