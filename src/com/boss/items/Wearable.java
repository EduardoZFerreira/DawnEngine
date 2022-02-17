package com.boss.items;

import com.boss.enums.items.WearableType;

public class Wearable extends Item {

    private WearableType wearableType;
    private Double defense;

    public Wearable(Integer x, Integer y, WearableType wearableType, Double defense, Double weight) {
        super(x, y, wearableType.sprite, weight);
        this.wearableType = wearableType;
        this.defense = defense;
    }

    public void wear() {
    }
}
