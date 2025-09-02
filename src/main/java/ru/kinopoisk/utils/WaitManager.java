package ru.kinopoisk.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.kinopoisk.driverManagers.Driver;

import java.time.Duration;

public class WaitManager {

    public static boolean isElementVisible(By locator, WebDriver webDriver) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            return wait.until(driver -> {
                WebElement element = webDriver.findElement(locator);
                return element.isDisplayed();
            });
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public static WebElement waitElementVisible(By locator, WebDriver webDriver) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        try {
            return wait.until(driver -> {
                WebElement element = webDriver.findElement(locator);
                element.isDisplayed();
                return element;
            });
        } catch (TimeoutException ex) {
            throw new RuntimeException("WebElement with locator \"" + locator + "\" was not found");
        }
    }

    public static void waitElementsDisappear(By locator, WebDriver webDriver) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        try {
            wait.until(driver -> webDriver.findElements(locator).isEmpty());
        } catch (TimeoutException ex) {
            throw new RuntimeException("Elements with locator \"" + locator + "\" did not disappear");
        }
    }
}
