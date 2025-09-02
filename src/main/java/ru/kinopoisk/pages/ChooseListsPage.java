package ru.kinopoisk.pages;

import org.openqa.selenium.WebDriver;

public class ChooseListsPage extends BasePage implements PagesUniqueElement {
    public ChooseListsPage(WebDriver driver) {
        super(CHOOSE_LISTS_PAGE_LOCATOR, driver);
    }
}
