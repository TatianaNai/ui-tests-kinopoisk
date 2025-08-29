package ru.kinopoisk;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.pages.MoviePage;
import ru.kinopoisk.pages.SearchResultPage;

public class FindMovieTest extends BaseTest{
    @Test
    @Parameters({"movieName"})
    public void shouldHaveCorrectToFindMovie(String expectedMovieName) {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        MoviePage moviePage = new MoviePage();

        System.out.println("1. Go to home page of Kinopoisk");
        Assert.assertTrue(homePage.isPageOpen(), "Home page was not open");

        System.out.println("2. Search for movie");
        homePage.typeTextInSearchMovieInput(expectedMovieName);
        homePage.clickSearchButton();

        System.out.println("3. Choose movie");
        String movieSearchName = searchResultPage.getMostWantedMovieName();
        int movieSearchReleaseYear = searchResultPage.getMostWantedMovieReleaseYear();
        Assert.assertEquals(movieSearchName, expectedMovieName, "Movie's name from search page: \"" + movieSearchName + "\" is not equal to \"" + expectedMovieName + "\"");
        Assert.assertTrue(searchResultPage.isPageOpen(), "Search result page was not open");

        System.out.println("4. Go to movie page");
        searchResultPage.clickMostWantedMovieImage();
        Assert.assertTrue(moviePage.isPageOpen(), "Movie page was not open");

        System.out.println("5. Check movie's name and release year");
        String movieName = moviePage.getMovieName();
        int movieReleaseYear = moviePage.getMovieReleaseYear();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(movieName, movieSearchName, "Movie's name: \"" + movieName + "\" is not equal to movie's name from search page: \"" + movieSearchName + "\"");
        softAssert.assertEquals(movieReleaseYear, movieSearchReleaseYear, "Movie's release year: \"" + movieReleaseYear + "\" is not equal to movie's release year from search page: \"" + movieSearchReleaseYear + "\"");
        softAssert.assertAll();
    }
}
