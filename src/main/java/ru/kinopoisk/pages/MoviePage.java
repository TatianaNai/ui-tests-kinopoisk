package ru.kinopoisk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends BasePage implements PagesUniqueElement{
    @FindBy(xpath = "//*[@itemprop='name']")
    private WebElement movieTitle;

    public MoviePage() {
        super(MOVIE_PAGE_LOCATOR);
    }

    public String getMovieName() {
        String movieNameAndReleaseYear = movieTitle.getText();
        int openBracketIndex = movieNameAndReleaseYear.indexOf("(");
        return movieNameAndReleaseYear.substring(0, openBracketIndex).trim();
    }

    public int getMovieReleaseYear() {
        String movieNameAndReleaseYear = movieTitle.getText();
        int openBracketIndex = movieNameAndReleaseYear.indexOf('(');
        int closeBracketIndex = movieNameAndReleaseYear.indexOf(')');
        return Integer.parseInt(movieNameAndReleaseYear.substring(openBracketIndex + 1, closeBracketIndex));
    }
}
