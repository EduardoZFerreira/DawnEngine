package com.boss.enums.entities;

public enum ItemType {
    PISTOL_AMMO(0, 0, 0.2),
    WEAPON_PISTOL(0, 1, 1.00),
    HEALING(0, 2, 0.5),
    ARMOR(0, 3, 0.00);

    public final Integer linePosition;
    public final Integer columnPosition;
    public final Double size;

    private ItemType(Integer linePosition, Integer columnPosition, Double size) {
        this.linePosition = linePosition;
        this.columnPosition = columnPosition;
        this.size = size;
    }
}
