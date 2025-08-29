package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.WaitManager;

public abstract class BasePage {
    private final By locator;

    public BasePage(By locator) {
        this.locator = locator;
        PageFactory.initElements(Driver.INSTANCE.getDriver(), this);
    }

    public boolean isPageOpen() {
        return WaitManager.isElementVisible(locator);
    }
}
