package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.pages.MoviePage;
import ru.kinopoisk.pages.SearchResultPage;
import ru.kinopoisk.utils.Props;

import static org.testng.Assert.*;

@Slf4j
public class FindMovieTest extends BaseTest{
    @DataProvider(name = "movies", parallel=true)
    public Object[][] moviesName() {
        return new Object[][]{
                {"Начало"},
                {"Король Лев"},
                {"Хороший год"}
        };
    }

    @Test(dataProvider = "movies")
    public void shouldHaveCorrectToFindMovie(String movieName) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);
        driver.get(Props.getProperty("url"));

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Search for movie");
        homePage.typeTextInSearchMovieInput(movieName);
        homePage.clickSearchButton();

        log.info("3. Choose movie");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertTrue(searchResultPage.isPageOpen(), "Search result page was not open");
        String movieSearchName = searchResultPage.getMostWantedMovieName();
        int movieSearchReleaseYear = searchResultPage.getMostWantedMovieReleaseYear();
        log.info("Movie from search page: name - \"" + movieSearchName + "\", release year - \"" + movieSearchReleaseYear + "\"");
        assertEquals(movieSearchName, movieName, "Movie's name from search page: \"" + movieSearchName + "\" is not equal to \"" + movieName + "\"");

        log.info("4. Go to movie page");
        searchResultPage.clickMostWantedMovieImage();
        MoviePage moviePage = new MoviePage(driver);
        assertTrue(moviePage.isPageOpen(), "Movie page was not open");

        log.info("5. Check movie's name and release year");
        String movieNameFromMoviePage = moviePage.getMovieName();
        int movieReleaseYearFromMoviePage = moviePage.getMovieReleaseYear();
        log.info("Movie from movie page: name - \"" + movieNameFromMoviePage + "\", release year - \"" + movieReleaseYearFromMoviePage + "\"");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(movieNameFromMoviePage, movieSearchName, "Movie's name: \"" + movieNameFromMoviePage + "\" is not equal to movie's name from search page: \"" + movieSearchName + "\"");
        softAssert.assertEquals(movieReleaseYearFromMoviePage, movieSearchReleaseYear, "Movie's release year: \"" + movieReleaseYearFromMoviePage + "\" is not equal to movie's release year from search page: \"" + movieSearchReleaseYear + "\"");
        softAssert.assertAll();

        driver.quit();
    }
}
