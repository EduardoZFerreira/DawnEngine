package com.boss.repositories.items;

import com.boss.enums.items.AmmoType;
import com.boss.items.Ammo;
import com.boss.utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmmoRepository {
    private static final String DATA_SOURCE = "data/ammo.csv";

    public static List<Ammo> loadAmmoList() {
        List<Ammo> resultSet = new ArrayList<>();

        try {
            BufferedReader file = new BufferedReader(FileUtils.getInstance().readFileAsAStream(DATA_SOURCE));

            if (!AmmoRepository.validateFile(file)) return resultSet;

            String line;
            while((line = file.readLine()) != null) {
                String[] ammoData = line.split(";");
                if (AmmoRepository.validateLine(ammoData)) {
                    Ammo ammo = new Ammo(AmmoType.valueOf(ammoData[0]), Double.valueOf(ammoData[1]));
                    resultSet.add(ammo);
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
        if (!line.equals("AMMO_TYPE;WEIGHT")) throw new IllegalArgumentException("File has wrong columns: " + line);

        return true;
    }

    private static Boolean validateLine(String[] line) {
        if (line.length != 2) return false;
        return true;
    }

}
