package com.boss.enums.entities;

public enum AmmoType {
    PISTOL(0.1, 1.00),
    SHOTGUN(0.4, 10.00);

    public final Double size;
    public final Double damage;

    private AmmoType(Double size, Double damage) {
        this.size = size;
        this.damage = damage;
    }
}
