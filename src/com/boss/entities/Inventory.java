package com.boss.entities;

import com.boss.enums.entities.AmmoType;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Double carryCapacity = 20.00;

    List<Weapon> weaponList = new ArrayList<>();
    List<Ammo> ammo = new ArrayList<>();
    List<Consumable> consumables = new ArrayList<>();

    public Double calculateCurrentCarryWeight() {
        Double currentCarryWeight = 0.00;

        for (Weapon weapon : weaponList) {
             currentCarryWeight += weapon.getType().size;
        }

        for (Ammo ammunition : ammo) {
             currentCarryWeight += ammunition.getType().size * ammunition.getAmmount();
        }

        for (Consumable consumable : consumables) {
            currentCarryWeight += consumable.getType().size;
        }

        return currentCarryWeight;
    }

    public void addAmmo(AmmoType ammoType) {
        Ammo pickedUpAmmo = ammo.stream()
                .filter(ammunition -> ammoType.equals(ammunition.getType()))
                .findAny()
                .orElse(null);

        if (pickedUpAmmo == null) {
            ammo.add(new Ammo(ammoType));
        } else {
            pickedUpAmmo.increaseAmmount();
        }
    }

    public double getCarryCapacity() {
        return carryCapacity;
    }
}
