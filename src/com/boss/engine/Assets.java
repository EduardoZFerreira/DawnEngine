package com.boss.engine;

import com.boss.items.Ammo;
import com.boss.items.Consumable;
import com.boss.items.Weapon;
import com.boss.items.Wearable;
import com.boss.repositories.items.AmmoRepository;
import com.boss.repositories.items.ConsumableRepository;
import com.boss.repositories.items.WeaponRepository;
import com.boss.repositories.items.WearableRepository;

import java.util.List;

public class Assets {
    public static final List<Weapon> weaponList = WeaponRepository.loadWeapons();
    public static final List<Ammo> ammoList = AmmoRepository.loadAmmoList();
    public static final List<Consumable> consumableList = ConsumableRepository.loadConsumables();
    public static final List<Wearable> wearableList = WearableRepository.loadWearables();
}
