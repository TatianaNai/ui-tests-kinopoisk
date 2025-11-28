package ru.kinopoisk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.Props;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        Driver.INSTANCE.getDriver();
        Driver.INSTANCE.getDriver().manage().window().maximize();
        Driver.INSTANCE.getDriver().get(Props.getProperty("url"));
    }

    @AfterEach
    public void tearDown() {
        Driver.INSTANCE.quit();
    }
}
