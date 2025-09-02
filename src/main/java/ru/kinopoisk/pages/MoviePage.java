package ru.kinopoisk.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MoviePage extends BasePage {
    @FindBy(xpath = "//*[@itemprop='name']")
    private WebElement movieTitle;

    public MoviePage(WebDriver driver) {
        super(MOVIE_PAGE_LOCATOR, driver);
    }

    public String getMovieName() {
        return getMovieNameAndReleaseYear().get("name");
    }

    public int getMovieReleaseYear() {
        return Integer.parseInt(getMovieNameAndReleaseYear().get("year"));
    }

    private Map<String, String> getMovieNameAndReleaseYear() {
        log.info("Getting movie name and release year from movieTitle element");
        String movieNameAndReleaseYear = movieTitle.getText();
        int openBracketIndex = movieNameAndReleaseYear.indexOf('(');
        int closeBracketIndex = movieNameAndReleaseYear.indexOf(')');
        log.info("Open bracket index: {}, close bracket index: {}", openBracketIndex, closeBracketIndex);
        Map<String, String> moviesInfo = new HashMap<>();
        log.info("Adding movie name to HashMap");
        moviesInfo.put("name", movieNameAndReleaseYear.substring(0, openBracketIndex).trim());
        log.info("Adding movie release year to HashMap");
        moviesInfo.put("year", movieNameAndReleaseYear.substring(openBracketIndex + 1, closeBracketIndex));
        return moviesInfo;
    }
}
