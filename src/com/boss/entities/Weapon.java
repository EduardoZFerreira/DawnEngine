package com.boss.entities;

import com.boss.enums.entities.WeaponType;

public class Weapon {
    private WeaponType type;

    private Double meleeDamage;

    public WeaponType getType() {
        return type;
    }

    public Double getMeleeDamage() {
        return meleeDamage;
    }
}
