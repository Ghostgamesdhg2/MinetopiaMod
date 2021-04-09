package com.ghostgamesdhg.minetopia.items;

import com.ghostgamesdhg.minetopia.MinetopiaExtra;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class drakenvlees extends Item {

    public drakenvlees() {
        super(new Properties()
                .group(MinetopiaExtra.TAB4)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(1.2f)
                        .effect(new EffectInstance(Effects.POISON, 200, 2) ,1f)
                        .effect(new EffectInstance(Effects.NAUSEA, 230, 2) ,1f)
                        .effect(new EffectInstance(Effects.SPEED, 400, 4) ,1f)
                        .effect(new EffectInstance(Effects.STRENGTH, 500, 4) ,1f)
                        .effect(new EffectInstance(Effects.JUMP_BOOST, 250, 2) ,1f)
                        .effect(new EffectInstance(Effects.INSTANT_HEALTH, 150, 4) ,1f)
                        .setAlwaysEdible()
                        .build())
        );
    }
    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}