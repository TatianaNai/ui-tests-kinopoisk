package ru.kinopoisk.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage extends BasePage{
    private final SelenideElement mostWantedMovieImage = $x("//*[contains(@class,'element most_wanted')]//*[contains(@class,'pic')]");
    private final SelenideElement mostWantedMovieTitle = $x("//*[contains(@class,'element most_wanted')]//*[contains(@class,'name')]//*[contains(@class,'js-serp-metrika')]");
    private final SelenideElement mostWantedMovieReleaseYear = $x("//*[contains(@class,'element most_wanted')]//*[contains(@class,'year')]");

    public SearchResultPage() {
        super(SEARCH_PAGE_UNIQUE_ELEMENT);
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
