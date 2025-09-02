package ru.kinopoisk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'element most_wanted')]//*[contains(@class,'pic')]")
    private WebElement mostWantedMovieImage;
    @FindBy(xpath = "//*[contains(@class,'element most_wanted')]//*[contains(@class,'name')]//*[contains(@class,'js-serp-metrika')]")
    private WebElement mostWantedMovieTitle;
    @FindBy(xpath = "//*[contains(@class,'element most_wanted')]//*[contains(@class,'year')]")
    private WebElement mostWantedMovieReleaseYear;

    public SearchResultPage(WebDriver driver) {
        super(SEARCH_PAGE_LOCATOR, driver);
    }

    public void clickMostWantedMovieImage() {
        mostWantedMovieImage.click();
    }

    public String getMostWantedMovieName() {
        return mostWantedMovieTitle.getText();
    }

    public int getMostWantedMovieReleaseYear() {
        String movieReleaseYearString= mostWantedMovieReleaseYear.getText();
        if (!movieReleaseYearString.matches("\\d+")) {
            throw new IllegalArgumentException("Only numbers are expected in most wanted movie's release year: " + movieReleaseYearString);
        }

        return Integer.parseInt(movieReleaseYearString);
    }
}
