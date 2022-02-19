package com.selfindulgentnonsensemods.mccourse.item;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.util.Config;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Slice_of_pizza extends Item {
    public Slice_of_pizza(){
        super(new Properties().group(MCCourseMod.COURSE_TAB).food(new Food.Builder()
                .hunger(5).saturation(1.5f).effect(() -> new EffectInstance(Effects.SPEED, Config.PIZZAD_SPEED_DURATION.get(), 1), 0.5f)
                .build()));
    }
}
