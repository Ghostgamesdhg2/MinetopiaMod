package com.ghostgamesdhg.minetopia.items;

import com.ghostgamesdhg.minetopia.MinetopiaExtra;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Purple_Weed extends Item {

    public Purple_Weed() {
        super(new Properties()
                .group(MinetopiaExtra.TAB4)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(1.0f)
                        .effect(new EffectInstance(Effects.NAUSEA, 300, 2) ,1f)
                        .effect(new EffectInstance(Effects.SPEED, 940, 2) ,1f)
                        .effect(new EffectInstance(Effects.STRENGTH, 670, 3) ,1f)
                        .effect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1) ,1f)
                        .effect(new EffectInstance(Effects.NIGHT_VISION, 800, 3) ,1f)
                        .effect(new EffectInstance(Effects.BLINDNESS, 350, 3) ,1f)
                        .effect(new EffectInstance(Effects.POISON, 350, 3) ,1f)
                        .fastToEat()
                        .setAlwaysEdible()
                        .build())
        );
    }
}