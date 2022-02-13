package com.boss.enums.entities;

public enum ConsumableItemType {
    HEALING_ITEM_S(2.00),
    HEALING_ITEM_L(5.00);

    public final Double size;

    private ConsumableItemType(Double size) {
        this.size = size;
    }
}
