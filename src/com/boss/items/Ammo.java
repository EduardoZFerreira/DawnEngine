package com.boss.items;

import com.boss.enums.items.AmmoType;

public class Ammo extends Item {

    private AmmoType ammoType;

    public Ammo(AmmoType ammoType, Double weight) {
        super(ammoType.sprite, weight);
        this.ammoType = ammoType;
    }
}
