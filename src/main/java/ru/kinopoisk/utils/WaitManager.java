package ru.kinopoisk.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.kinopoisk.driverManagers.Driver;

import java.time.Duration;

public class WaitManager {
    private static final Wait<WebDriver> wait = new FluentWait<>(Driver.INSTANCE.getDriver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    public static boolean isElementVisible(By locator) {
        try {
            return wait.until(driver -> {
                WebElement element = Driver.INSTANCE.getDriver().findElement(locator);
                return element.isDisplayed();
            });
        }
        catch (TimeoutException ex){
            return false;
        }
    }
}
