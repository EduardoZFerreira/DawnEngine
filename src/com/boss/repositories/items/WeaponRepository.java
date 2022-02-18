package com.boss.repositories.items;

import com.boss.enums.items.AmmoType;
import com.boss.enums.items.WeaponType;
import com.boss.items.Weapon;
import com.boss.utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeaponRepository {
    private static final String DATA_SOURCE = "data/weapon.csv";

    public static List<Weapon> loadWeapons() {
        List<Weapon> resultSet = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(FileUtils.getInstance().readFileAsAStream(DATA_SOURCE));

            if (!WeaponRepository.validateFile(file)) return resultSet;

            String line;
            while((line = file.readLine()) != null) {
                String[] weaponData = line.split(";");
                if (WeaponRepository.validateLine(weaponData)) {
                    Weapon weapon = new Weapon(WeaponType.valueOf(weaponData[0]),
                            AmmoType.valueOf(weaponData[1]),
                            Double.valueOf(weaponData[2]),
                            Double.valueOf(weaponData[3]),
                            Integer.valueOf(weaponData[4]),
                            Double.valueOf(weaponData[5]),
                            Double.valueOf(weaponData[6]));
                    resultSet.add(weapon);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return resultSet;
    }

    private static Boolean validateFile(BufferedReader file) throws IOException {
        String line = file.readLine();

        if (line==null) throw new IllegalArgumentException("File is empty");
        if (!line.equals("WEAPON_TYPE;AMMO_TYPE;DAMAGE;RANGE;AMMO_CAPACITY;DURABILITY;WEIGHT")) throw new IllegalArgumentException("File has wrong columns: " + line);

        return true;
    }

    private static Boolean validateLine(String[] line) {
        if (line.length != 7) return false;
        return true;
    }
}