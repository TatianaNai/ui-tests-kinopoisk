package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.kinopoisk.utils.WaitManager;

public abstract class BasePage {
    private final By locator;
    private final WebDriver driver;

    public BasePage(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return WaitManager.isElementVisible(locator, driver);
    }
}
