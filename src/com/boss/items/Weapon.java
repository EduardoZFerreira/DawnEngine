package com.boss.items;

import com.boss.enums.items.AmmoType;
import com.boss.enums.items.WeaponType;

public class Weapon extends Item {
    private Integer currentAmmo = 0;

    private AmmoType ammoType;
    private WeaponType weaponType;
    private Double damage;
    private Double range;
    private Integer ammoCapacity;
    private Double durability;

    public Weapon(Integer x, Integer y, WeaponType weaponType, AmmoType ammoType, Double damage, Double range, Integer ammoCapacity, Double durability, Double weight) {
        super(x, y, weaponType.sprite, weight);
        this.weaponType = weaponType;
        this.damage = damage;
        this.range = range;
        this.ammoCapacity = ammoCapacity;
        this.ammoType = ammoType;
        this.durability = durability;
    }

    public Double getDamage() {
        return damage;
    }

    public Integer getAmmoCapacity() {
        return ammoCapacity;
    }
}
