package ru.kinopoisk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage implements PagesUniqueElement{
    @FindBy(xpath = "//input[@name='kp_query']")
    private WebElement searchMovieInput;
    @FindBy(xpath = "//*[contains(@class,'kinopoisk-header-search')]//button[@type='submit']")
    private WebElement searchButton;

    public HomePage() {
        super(HOME_PAGE_LOCATOR);
    }

    public void typeTextInSearchMovieInput(String text) {
        searchMovieInput.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
