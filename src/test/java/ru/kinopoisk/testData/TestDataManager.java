package ru.kinopoisk.testData;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TestDataManager {
    @Getter
    private static final TestData TEST_DATA;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStreamReader inputStream = new InputStreamReader(
                TestDataManager.class.getClassLoader().getResourceAsStream("testData.json"),
                StandardCharsets.UTF_8)) {
            TEST_DATA = mapper.readValue(inputStream, TestData.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File testData.json was not found");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file testData.json");
        }
    }
}
