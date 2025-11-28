package ru.kinopoisk.driverManagers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public enum Driver {
    INSTANCE;
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }

    public void quit() {
        driver.get().quit();
        driver.set(null);
    }
}
