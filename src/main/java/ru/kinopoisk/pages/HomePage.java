package ru.kinopoisk.pages;


import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class HomePage extends BasePage {
    private final SelenideElement searchMovieInput = $x("//input[@name='kp_query']");
    private final SelenideElement searchButton = $x("//*[contains(@class,'kinopoisk-header-search')]//button[@type='submit']");
    private final SelenideElement moviesButton = $x("//*[contains(@class,'styles_title') and contains(.,'Фильмы')]");

    public HomePage() {
        super(HOME_PAGE_UNIQUE_ELEMENT);
    }

    public void typeTextInSearchMovieInput(String text) {
        log.info(String.format("Typing %s in SearchMovieInput", text));
        searchMovieInput.sendKeys(text);
    }

    public void clickSearchButton() {
        log.info("Clicking SearchButton");
        searchButton.click();
    }

    public void clickMoviesButton() {
        log.info("Clicking MoviesButton");
        moviesButton.click();
    }
}
