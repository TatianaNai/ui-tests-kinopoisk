package ru.kinopoisk.driverManagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public enum Driver {
    INSTANCE;
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void quit() {
        driver.quit();
        driver = null;
    }
}
