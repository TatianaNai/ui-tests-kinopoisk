package ru.kinopoisk.utils;

import java.io.IOException;
import java.util.Properties;

public class Props {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(Props.class.getClassLoader()
                    .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
