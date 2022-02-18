package com.boss.repositories.items;

import com.boss.enums.items.WearableType;
import com.boss.items.Wearable;
import com.boss.utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WearableRepository {
    private static final String DATA_SOURCE = "data/wearable.csv";

    public static List<Wearable> loadWearables() {
        List<Wearable> resultSet = new ArrayList<>();

        try {
            BufferedReader file = new BufferedReader(FileUtils.getInstance().readFileAsAStream(DATA_SOURCE));

            if (!WearableRepository.validateFile(file)) return resultSet;

            String line;
            while((line = file.readLine()) != null) {
                String[] wearableData = line.split(";");
                if (WearableRepository.validateLine(wearableData)) {
                    Wearable wearable = new Wearable(WearableType.valueOf(wearableData[0]), Double.valueOf(wearableData[1]), Double.valueOf(wearableData[1]));
                    resultSet.add(wearable);
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
        if (!line.equals("WEARABLE_TYPE;DEFENSE;WEIGHT")) throw new IllegalArgumentException("File has wrong columns: " + line);

        return true;
    }

    private static Boolean validateLine(String[] line) {
        if (line.length != 3) return false;
        return true;
    }
}
