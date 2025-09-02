package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.WaitManager;

public abstract class BasePage implements PagesUniqueElement{
    protected final WebDriver driver;
    private final By locator;

    public BasePage(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return WaitManager.isElementVisible(locator, driver);
    }
}
