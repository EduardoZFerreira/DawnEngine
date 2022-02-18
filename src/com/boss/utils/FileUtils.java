package com.boss.utils;

import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
    private static FileUtils singleton = null;

    public static FileUtils getInstance() {
        if (singleton == null) {
            singleton = new FileUtils();
        }
        return singleton;
    }

    public InputStreamReader readFileAsAStream(String path) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(inputStream);
    }

    private FileUtils() {
    }
}
