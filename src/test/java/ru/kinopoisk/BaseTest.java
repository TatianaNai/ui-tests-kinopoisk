package ru.kinopoisk;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.ConfigManager;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Driver.INSTANCE.getDriver();
        Driver.INSTANCE.getDriver().manage().window().maximize();
        Driver.INSTANCE.getDriver().get(ConfigManager.getCONFIG().getUrl());
    }

    @AfterMethod
    public void tearDown() {
        Driver.INSTANCE.quit();
    }
}
