package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.WaitManager;

public abstract class BasePage {
    private By locator;

    public BasePage(By locator) {
        this.locator = locator;
        PageFactory.initElements(Driver.INSTANCE.getDriver(), this);
    }

    public boolean isPageOpen() {
        WebElement element = Driver.INSTANCE.getDriver().findElement(locator);
        WaitManager.waitElementVisible(element);
        return element.isDisplayed();
    }
}
