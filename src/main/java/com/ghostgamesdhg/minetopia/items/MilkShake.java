package com.ghostgamesdhg.minetopia.items;

import com.ghostgamesdhg.minetopia.MinetopiaExtra;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MilkShake extends Item {

    public MilkShake() {
        super(new Item.Properties()
                .group(MinetopiaExtra.TAB4)
                .food(new Food.Builder()
                        .hunger(1)
                        .saturation(1.2f)
                        .effect(new EffectInstance(Effects.HASTE, 2000, 1) ,1f)
                        .effect(new EffectInstance(Effects.NAUSEA, 340, 0), 0.4f)
                        .setAlwaysEdible()
                        .build())
        );
    }
}
