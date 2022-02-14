package com.boss.entities;

import com.boss.enums.entities.AmmoType;

public class Ammo {
    private Integer ammount;
    private final AmmoType type;

    public Ammo(AmmoType type) {
        this.type = type;
        ammount = type.pickUpAmmount;
    }

    public void increaseAmmount() {
        ammount += type.pickUpAmmount;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public AmmoType getType() {
        return type;
    }
}
