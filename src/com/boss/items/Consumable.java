package com.boss.items;

import com.boss.enums.items.ConsumableType;

public class Consumable extends Item {

    private ConsumableType consumableType;
    private Double regenAmount;

    public Consumable(ConsumableType consumableType, Double regenAmount, Double weight) {
        super(consumableType.sprite, weight);
        this.consumableType = consumableType;
        this.regenAmount = regenAmount;
    }

    public void use() {
    }
}
