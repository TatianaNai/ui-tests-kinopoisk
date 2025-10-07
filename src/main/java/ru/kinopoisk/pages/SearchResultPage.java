package ru.kinopoisk.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class SearchResultPage extends BasePage{
    private final SelenideElement mostWantedMovieImage = $x("//*[contains(@class,'element most_wanted')]//*[contains(@class,'pic')]");
    private final SelenideElement mostWantedMovieTitle = $x("//*[contains(@class,'element most_wanted')]//*[contains(@class,'name')]//*[contains(@class,'js-serp-metrika')]");
    private final SelenideElement mostWantedMovieReleaseYear = $x("//*[contains(@class,'element most_wanted')]//*[contains(@class,'year')]");

    public SearchResultPage() {
        super(SEARCH_PAGE_UNIQUE_ELEMENT);
    }

    public void clickMostWantedMovieImage() {
        log.info("Clicking MostWantedMovieImage");
        mostWantedMovieImage.click();
    }

    public String getMostWantedMovieName() {
        log.info("Getting MostWantedMovieName");
        return mostWantedMovieTitle.getText();
    }

    public int getMostWantedMovieReleaseYear() {
        log.info("Getting MostWantedMovieReleaseYear");
        String movieReleaseYearString= mostWantedMovieReleaseYear.getText();
        if (!movieReleaseYearString.matches("\\d+")) {
            throw new IllegalArgumentException("Only numbers are expected in most wanted movie's release year: " + movieReleaseYearString);
        }

        return Integer.parseInt(movieReleaseYearString);
    }
}
