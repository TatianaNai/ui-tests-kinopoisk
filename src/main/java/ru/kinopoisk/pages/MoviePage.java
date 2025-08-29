package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends BasePage{
    @FindBy(xpath = "//*[@itemprop='name']")
    private WebElement movieTitle;

    public MoviePage() {
        super(By.xpath("//img[contains(@class,'film-poster')]"));
    }

    public String getMovieName() {
        String movieNameAndYear = movieTitle.getText();
        int openBracketIndex = movieNameAndYear.indexOf("(");
        return movieNameAndYear.substring(0, openBracketIndex).trim();
    }

    public int getMovieReleaseYear() {
        String movieNameAndReleaseYear = movieTitle.getText();
        int openBracketIndex = movieNameAndReleaseYear.indexOf('(');
        int closeBracketIndex = movieNameAndReleaseYear.indexOf(')');
        return Integer.parseInt(movieNameAndReleaseYear.substring(openBracketIndex + 1, closeBracketIndex));
    }
}
