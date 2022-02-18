package com.boss.repositories.items;

import com.boss.enums.items.ConsumableType;
import com.boss.items.Consumable;
import com.boss.utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsumableRepository {
    private static final String DATA_SOURCE = "data/consumable.csv";

    public static List<Consumable> loadConsumables() {
        List<Consumable> resultSet = new ArrayList<>();

        try {
            BufferedReader file = new BufferedReader(FileUtils.getInstance().readFileAsAStream(DATA_SOURCE));

            if (!ConsumableRepository.validateFile(file)) return resultSet;

            String line;
            while((line = file.readLine()) != null) {
                String[] consumableData = line.split(";");
                if (ConsumableRepository.validateLine(consumableData)) {
                    Consumable consumable = new Consumable(ConsumableType.valueOf(consumableData[0]), Double.valueOf(consumableData[1]), Double.valueOf(consumableData[1]));
                    resultSet.add(consumable);
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
        if (!line.equals("CONSUMABLE_TYPE;REGEN_AMMOUNT;WEIGHT")) throw new IllegalArgumentException("File has wrong columns: " + line);

        return true;
    }

    private static Boolean validateLine(String[] line) {
        if (line.length != 3) return false;
        return true;
    }
}
