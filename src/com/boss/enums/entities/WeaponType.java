package com.boss.enums.entities;

public enum WeaponType {
    PISTOL(1.00),
    SHOTGUN(2.00),
    MELEE_S(1.00),
    MELEE_L(2.00);

    public final Double size;

    private WeaponType(Double size) {
        this.size = size;
    }
}
