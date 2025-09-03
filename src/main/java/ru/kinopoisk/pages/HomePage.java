package ru.kinopoisk.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {
    private final SelenideElement searchMovieInput = $x("//input[@name='kp_query']");
    private final SelenideElement searchButton = $x("//*[contains(@class,'kinopoisk-header-search')]//button[@type='submit']");

    public HomePage() {
        super(HOME_PAGE_UNIQUE_ELEMENT);
    }

    public void typeTextInSearchMovieInput(String text) {
        searchMovieInput.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
