package com.boss.entities;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Double carryCapacity = 20.00;

    List<Weapon> weaponList = new ArrayList<>();
    List<Ammo> ammo = new ArrayList<>();
    List<Consumable> consumables = new ArrayList<>();
}
