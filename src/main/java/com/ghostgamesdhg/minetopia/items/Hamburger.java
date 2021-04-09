package com.ghostgamesdhg.minetopia.items;

import com.ghostgamesdhg.minetopia.MinetopiaExtra;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Hamburger extends Item {

    public Hamburger() {
        super(new Item.Properties()
                .group(MinetopiaExtra.TAB4)
                .food(new Food.Builder()
                        .hunger(8)
                        .saturation(1.2f)
                        .effect(new EffectInstance(Effects.REGENERATION, 340, 2) ,1f)
                        .build())
        );
    }
}
