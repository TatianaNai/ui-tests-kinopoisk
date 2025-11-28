package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.pages.MoviePage;
import ru.kinopoisk.pages.SearchResultPage;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

@Slf4j
public class FindMovieTest extends BaseTest{
    public static Stream<String> movieProvider() {
        return Stream.of("Начало", "Король Лев", "Хороший год");
    }

    @ParameterizedTest
    @MethodSource("movieProvider")
    @DisplayName("Search movie by name test")
    public void shouldHaveCorrectToFindMovie(String movieName) {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage();
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Search for movie");
        homePage.typeTextInSearchMovieInput(movieName);
        homePage.clickSearchButton();

        log.info("3. Choose movie");
        SearchResultPage searchResultPage = new SearchResultPage();
        assertTrue(searchResultPage.isPageOpen(), "Search result page was not open");
        String movieSearchName = searchResultPage.getMostWantedMovieName();
        int movieSearchReleaseYear = searchResultPage.getMostWantedMovieReleaseYear();
        log.info("Movie from search page: name - \"" + movieSearchName + "\", release year - \"" + movieSearchReleaseYear + "\"");
        assertEquals(movieName, movieSearchName, "Movie's name from search page: \"" + movieSearchName + "\" is not equal to \"" + movieName + "\"");

        log.info("4. Go to movie page");
        searchResultPage.clickMostWantedMovieImage();
        MoviePage moviePage = new MoviePage();
        assertTrue(moviePage.isPageOpen(), "Movie page was not open");

        log.info("5. Check movie's name and release year");
        String movieNameFromMoviePage = moviePage.getMovieName();
        int movieReleaseYearFromMoviePage = moviePage.getMovieReleaseYear();
        log.info("Movie from movie page: name - \"" + movieNameFromMoviePage + "\", release year - \"" + movieReleaseYearFromMoviePage + "\"");
        assertAll(
                () -> assertEquals(movieSearchName, movieNameFromMoviePage, "Movie's name: \"" + movieNameFromMoviePage + "\" is not equal to movie's name from search page: \"" + movieSearchName + "\""),
                () -> assertEquals(movieSearchReleaseYear, movieReleaseYearFromMoviePage, "Movie's release year: \"" + movieReleaseYearFromMoviePage + "\" is not equal to movie's release year from search page: \"" + movieSearchReleaseYear + "\"")
        );
    }
}
