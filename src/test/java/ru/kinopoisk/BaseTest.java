package ru.kinopoisk;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.Props;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        Driver.INSTANCE.getDriver();
        Driver.INSTANCE.getDriver().manage().window().maximize();
        Driver.INSTANCE.getDriver().get(Props.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        Driver.INSTANCE.quit();
    }
}
