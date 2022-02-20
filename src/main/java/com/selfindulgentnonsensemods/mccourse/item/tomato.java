package com.selfindulgentnonsensemods.mccourse.item;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.util.Config;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class tomato extends Item {
    public tomato(){
        super(new Properties().group(MCCourseMod.COURSE_TAB).food(new Food.Builder()
                .hunger(2).saturation(1.5f)
                .build()));
    }
}
