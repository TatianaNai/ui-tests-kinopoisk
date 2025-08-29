package ru.kinopoisk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import ru.kinopoisk.pojos.Config;

import java.io.IOException;

public class ConfigManager {
    @Getter
    private static final Config CONFIG;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CONFIG = mapper.readValue(
                    Props.class.getClassLoader()
                            .getResourceAsStream("config.json"),
                    Config.class);
        } catch (IOException e) {
            throw new RuntimeException("File config.json was not found");
        }
    }
}
