package com.selfindulgentnonsensemods.mccourse.tileentity;

import com.selfindulgentnonsensemods.mccourse.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TotemSummoningStationTile extends TileEntity implements ITickableTileEntity
{

    private final ItemStackHandler itemHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    private int tick = 0;
    private int energyLevel = 0;
    private int progress = 0;

    public TotemSummoningStationTile(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    public TotemSummoningStationTile()
    {
        this(ModTileEntities.TOTEM_SUMMONING_STATION_TILE_ENTITY.get());
    }

    public boolean isItemEntered(int slot, Item ItemToPutIn)
    {
        return this.itemHandler.getStackInSlot(slot).getItem().toString() == String.valueOf(ItemToPutIn);
    }

    @OnlyIn(Dist.CLIENT)
    public int getProgress ()
    {
        return progress;
    }

    @Override
    public void tick()
    {
        if(isItemEntered(1, Items.EMERALD) &&
                this.itemHandler.getStackInSlot(2).getItem().toString() == String.valueOf(ModItems.TOTEM_OF_NOTHINGNESS) &&
                isItemEntered(3, Items.EMERALD) &&
                isItemEntered(4, Items.DIRT) &&
                isItemEntered(5, Items.NETHERRACK) &&
                isItemEntered(6, Items.END_STONE) &&
                isItemEntered(7, Items.DIAMOND) &&
                isItemEntered(8, Items.NETHERITE_INGOT) &&
                isItemEntered(9, Items.END_CRYSTAL) //&&
                //this.itemHandler.getStackInSlot(10).toString().contains("Potion") || this.itemHandler.getStackInSlot(10).getItem() == null
        ){
            progress++;
            if(progress > 104)
            {
                itemHandler.extractItem(1,1,false);
                itemHandler.extractItem(2,1,false);
                itemHandler.extractItem(3,1,false);
                itemHandler.extractItem(4,1,false);
                itemHandler.extractItem(5,1,false);
                itemHandler.extractItem(6,1,false);
                itemHandler.extractItem(7,1,false);
                itemHandler.extractItem(8,1,false);
                itemHandler.extractItem(9,1,false);
                //itemHandler.extractItem(10,1,false);

                itemHandler.insertItem(0, new ItemStack(Items.TOTEM_OF_UNDYING, 1), false);

                progress = 0;
            }
        } else {
            progress = 0;
        }

            //if(this.itemHandler.getStackInSlot(0).getItem() == Items.DIAMOND && this.energyLevel < 64)
            //{
            //    itemHandler.extractItem(0,1,false); // deletes the item, slot, amount, simulate
            //    energyLevel++;
            //}

            //if(this.itemHandler.getStackInSlot(1).getItem() == ModItems.SLICE_OF_PIZZA.get() && this.energyLevel > 0 && this.itemHandler.getStackInSlot(2).getCount() < 64)
            //{
            //    itemHandler.extractItem(1,1,false);
            //   itemHandler.insertItem(2, new ItemStack(Items.EMERALD, 1), false);
            //   energyLevel--;
            //}
    }

    @Override
    public void read(BlockState state, CompoundNBT tag)
    {
        itemHandler.deserializeNBT(tag.getCompound("inv"));
        super.read(state, tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag)
    {
        tag.put("inv", itemHandler.serializeNBT());
        return super.write(tag);
    }

    private ItemStackHandler createHandler()
    {
        return new ItemStackHandler(10)
        {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            public boolean isItemValid(int slot, @Nonnull ItemStack stack)
            {
                switch (slot)
                {
                    case 0: return stack.getItem() == Items.TOTEM_OF_UNDYING;
                    case 1: return stack.getItem() == Items.EMERALD;
                    case 2: return stack.getItem() == ModItems.TOTEM_OF_NOTHINGNESS.get();
                    case 3: return stack.getItem() == Items.EMERALD;
                    case 4: return stack.getItem() == Items.DIRT;
                    case 5: return stack.getItem() == Items.NETHERRACK;
                    case 6: return stack.getItem() == Items.END_STONE;
                    case 7: return stack.getItem() == Items.DIAMOND;
                    case 8: return stack.getItem() == Items.NETHERITE_INGOT;
                    case 9: return stack.getItem() == Items.END_CRYSTAL;
                    //case 10: return true; // stack.getItem().toString().contains("Potion");
                    default: return false;
                }
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
            {
                if(!isItemValid(slot, stack))
                {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return handler.cast();
        }
        return super.getCapability(capability, side);
    };
}
