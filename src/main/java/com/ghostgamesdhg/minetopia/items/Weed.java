package com.ghostgamesdhg.minetopia.items;

import com.ghostgamesdhg.minetopia.MinetopiaExtra;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Weed extends Item {

    public Weed() {
        super(new Item.Properties()
                .group(MinetopiaExtra.TAB4)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(1.2f)
                        .effect(new EffectInstance(Effects.POISON, 260, 2) ,1f)
                        .effect(new EffectInstance(Effects.NAUSEA, 300, 2) ,1f)
                        .effect(new EffectInstance(Effects.SPEED, 890, 2) ,1f)
                        .effect(new EffectInstance(Effects.STRENGTH, 670, 3) ,1f)
                        .fastToEat()
                        .setAlwaysEdible()
                        .build())
        );
    }
}