package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.pages.MoviePage;
import ru.kinopoisk.pages.SearchResultPage;

@Slf4j
public class FindMovieTest extends BaseTest{
    @Test
    @Parameters({"movieName"})
    public void shouldHaveCorrectToFindMovie(String expectedMovieName) {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        MoviePage moviePage = new MoviePage();

        log.info("1. Go to home page of Kinopoisk");
        Assert.assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Search for movie");
        homePage.typeTextInSearchMovieInput(expectedMovieName);
        homePage.clickSearchButton();

        log.info("3. Choose movie");
        Assert.assertTrue(searchResultPage.isPageOpen(), "Search result page was not open");
        String movieSearchName = searchResultPage.getMostWantedMovieName();
        int movieSearchReleaseYear = searchResultPage.getMostWantedMovieReleaseYear();
        log.info("Movie from search page: name - \"" + movieSearchName + "\", release year - \"" + movieSearchReleaseYear + "\"");
        Assert.assertEquals(movieSearchName, expectedMovieName, "Movie's name from search page: \"" + movieSearchName + "\" is not equal to \"" + expectedMovieName + "\"");

        log.info("4. Go to movie page");
        searchResultPage.clickMostWantedMovieImage();
        Assert.assertTrue(moviePage.isPageOpen(), "Movie page was not open");

        log.info("5. Check movie's name and release year");
        String movieName = moviePage.getMovieName();
        int movieReleaseYear = moviePage.getMovieReleaseYear();
        log.info("Movie from movie page: name - \"" + movieName + "\", release year - \"" + movieReleaseYear + "\"");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(movieName, movieSearchName, "Movie's name: \"" + movieName + "\" is not equal to movie's name from search page: \"" + movieSearchName + "\"");
        softAssert.assertEquals(movieReleaseYear, movieSearchReleaseYear, "Movie's release year: \"" + movieReleaseYear + "\" is not equal to movie's release year from search page: \"" + movieSearchReleaseYear + "\"");
        softAssert.assertAll();
    }
}
