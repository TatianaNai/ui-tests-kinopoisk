package ru.kinopoisk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import ru.kinopoisk.pojos.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ConfigManager {
    @Getter
    private static final Config CONFIG;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream("config.json")) {
            CONFIG = mapper.readValue(inputStream, Config.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File config.json was not found");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file config.json");
        }
    }
}
