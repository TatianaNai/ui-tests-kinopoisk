package ru.kinopoisk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@name='kp_query']")
    private WebElement searchMovieInput;
    @FindBy(xpath = "//*[contains(@class,'kinopoisk-header-search')]//button[@type='submit']")
    private WebElement searchButton;
    @FindBy(xpath = "//*[contains(@class,'styles_title') and contains(.,'Фильмы')]")
    private WebElement moviesButton;

    public HomePage(WebDriver driver) {
        super(HOME_PAGE_LOCATOR, driver);
    }

    public void typeTextInSearchMovieInput(String text) {
        searchMovieInput.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickMoviesButton() {
        moviesButton.click();
    }
}
