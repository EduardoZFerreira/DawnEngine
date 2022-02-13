package com.boss.enums.entities;

public enum ItemType {
    AMMO(0, 0),
    WEAPON(0, 1),
    HEALING(0, 2),
    ARMOR(0, 3);

    public final Integer linePosition;
    public final Integer columnPosition;

    private ItemType(Integer linePosition, Integer columnPosition) {
        this.linePosition = linePosition;
        this.columnPosition = columnPosition;
    }
}
