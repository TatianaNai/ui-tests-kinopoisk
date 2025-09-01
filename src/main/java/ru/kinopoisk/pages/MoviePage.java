package ru.kinopoisk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class MoviePage extends BasePage implements PagesUniqueElement{
    @FindBy(xpath = "//*[@itemprop='name']")
    private WebElement movieTitle;

    public MoviePage() {
        super(MOVIE_PAGE_LOCATOR);
    }

    public String getMovieName() {
        return getMovieNameAndReleaseYear().get("name");
    }

    public int getMovieReleaseYear() {
        return Integer.parseInt(getMovieNameAndReleaseYear().get("year"));
    }

    private Map<String, String> getMovieNameAndReleaseYear() {
        String movieNameAndReleaseYear = movieTitle.getText();
        int openBracketIndex = movieNameAndReleaseYear.indexOf('(');
        int closeBracketIndex = movieNameAndReleaseYear.indexOf(')');
        Map<String, String> moviesInfo = new HashMap<>();
        moviesInfo.put("name", movieNameAndReleaseYear.substring(0, openBracketIndex).trim());
        moviesInfo.put("year", movieNameAndReleaseYear.substring(openBracketIndex + 1, closeBracketIndex));
        return moviesInfo;
    }
}
