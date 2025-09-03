package ru.kinopoisk.pages;

import com.codeborne.selenide.SelenideElement;

public abstract class BasePage implements PagesUniqueElement {
    private final SelenideElement uniqueElement;

    public BasePage(SelenideElement uniqueElement) {
        this.uniqueElement = uniqueElement;
    }

    public boolean isPageOpen() {
        return uniqueElement.isDisplayed();
    }
}
