package com.boss.items;

import com.boss.enums.items.AmmoType;

public class Ammo extends Item {

    private AmmoType ammoType;

    public Ammo(Integer x, Integer y, AmmoType ammoType, Double weight) {
        super(x, y, ammoType.sprite, weight);
        this.ammoType = ammoType;
    }
}
