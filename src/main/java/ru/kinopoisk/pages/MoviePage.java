package ru.kinopoisk.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class MoviePage extends BasePage {
    private final SelenideElement movieTitle = $x("//*[@itemprop='name']");

    public MoviePage() {
        super(MOVIE_PAGE_UNIQUE_ELEMENT);
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
