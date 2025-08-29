package ru.kinopoisk.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.kinopoisk.driverManagers.Driver;

import java.time.Duration;

public class WaitManager {
    private static Wait<WebDriver> wait = new FluentWait<>(Driver.INSTANCE.getDriver())
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofMillis(500));

    public static void waitElementVisible(WebElement element) {
        wait.until(driver -> element.isDisplayed());
    }
}
