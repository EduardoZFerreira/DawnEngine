package com.boss.entities;

import com.boss.items.*;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private Double currentCarryWeight = 0.00;
    private Double maxCarryWeight = 20.00;

    List<Consumable> consumableList = new ArrayList<>();
    List<Ammo> ammoList = new ArrayList<>();
    List<Weapon> weaponList = new ArrayList<>();
    List<Wearable> wearableList = new ArrayList<>();

    public double getMaxCarryWeight() {
        return maxCarryWeight;
    }
}
