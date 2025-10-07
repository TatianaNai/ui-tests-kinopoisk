package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kinopoisk.consts.FilterOptions;
import ru.kinopoisk.pages.ChooseListsPage;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.pages.MoviesListPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class FilterMoviesListTest extends BaseTest {
    public static Stream<Arguments> categoryFiltersProvider() {
        return Stream.of(
                Arguments.of("Фильмы про вампиров", FilterOptions.allCountries, "США", FilterOptions.allGenres, "Фэнтези", "Ван Хельсинг"),
                Arguments.of("Фильмы про вампиров", FilterOptions.allCountries, "Великобритания", FilterOptions.allGenres, "Ужасы", "Дракула"),
                Arguments.of("Фильмы про акул", FilterOptions.allCountries, "Австралия", FilterOptions.allGenres, "Ужасы", "Цунами 3D")
        );
    }

    @ParameterizedTest
    @MethodSource("categoryFiltersProvider")
    @DisplayName("Check filters in movies list test")
    public void shouldHaveCorrectFilterMoviesList(String category, String allCountries, String country,String allGenres, String genre, String expectedMovieName) {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage();
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Go to chooseLists page of Kinopoisk");
        homePage.clickMoviesButton();
        ChooseListsPage chooseListsPage = new ChooseListsPage();
        assertTrue(chooseListsPage.isPageOpen(), "ChooseLists page was not open");

        log.info("3. Choose category of movies");
        chooseListsPage.clickListMoviesButtonByTitle(category);
        MoviesListPage moviesListPage = new MoviesListPage();
        assertTrue(moviesListPage.isPageOpen(), "MoviesList page was not open");

        log.info("4. Check if page of right category open");
        String categoryTitle = moviesListPage.getCategoryTitle();
        assertEquals(category, categoryTitle, "Category title \"" + categoryTitle + "\" is not equal to \"" + category + "\"");

        log.info("5. Set filters and check amount of movies in list");
        moviesListPage.clickFilterByName(allCountries);
        moviesListPage.clickCheckboxOptionByName(country);
        moviesListPage.clickFilterByName(allGenres);
        moviesListPage.clickCheckboxOptionByName(genre);
        int amountMoviesTotal = moviesListPage.getAmountMoviesTotal();
        log.info("Amount of movies total: " + amountMoviesTotal);
        int amountMoviesOnPage = moviesListPage.getAmountMoviesOnPage();
        log.info("Amount of movies on page: " + amountMoviesOnPage);
        assertEquals(amountMoviesTotal, amountMoviesOnPage, "Amount of movies on page: " + amountMoviesOnPage + " is not equal to amount of movies total: " + amountMoviesTotal);

        log.info("6. Check first movie's name on the list");
        String firstMovieName = moviesListPage.getFirstMovieName();
        log.info("First movie's name on the list: " + firstMovieName);
        assertEquals(expectedMovieName, firstMovieName, "First movie's name on the list is \"" + firstMovieName + "\" but expected \"" + expectedMovieName + "\"");
    }
}
