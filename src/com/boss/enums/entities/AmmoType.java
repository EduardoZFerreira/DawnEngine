package com.boss.enums.entities;

public enum AmmoType {
    PISTOL(0.1, 1.00, 10),
    SHOTGUN(0.4, 10.00, 10);

    public final Double size;
    public final Double damage;
    public final Integer pickUpAmmount;

    private AmmoType(Double size, Double damage, Integer pickUpAmmount) {
        this.size = size;
        this.damage = damage;
        this.pickUpAmmount = pickUpAmmount;
    }
}
