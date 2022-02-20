package com.selfindulgentnonsensemods.mccourse.item;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import net.minecraft.item.Food;
import net.minecraft.item.SoupItem;

public class tomato_soup extends SoupItem {
    public tomato_soup(){
        super(new Properties().group(MCCourseMod.COURSE_TAB).food(new Food.Builder()
                .hunger(2).saturation(1.5f)
                .build()));
    }
}
