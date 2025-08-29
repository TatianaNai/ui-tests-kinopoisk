package ru.kinopoisk;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.Props;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Driver.INSTANCE.getDriver();
        Driver.INSTANCE.getDriver().manage().window().maximize();
        Driver.INSTANCE.getDriver().get(Props.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.INSTANCE.quit();
    }
}
