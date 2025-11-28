package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.pages.ChooseListsPage;
import ru.kinopoisk.pages.MoviesListPage;
import ru.kinopoisk.testData.TestDataManager;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class FilterVampireMoviesListTest extends BaseTest{

    @Test
    @DisplayName("Check filters in movies list test")
    public void shouldHaveCorrectFilterMoviesList() {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage();
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Go to chooseLists page of Kinopoisk");
        homePage.clickMoviesButton();
        ChooseListsPage chooseListsPage = new ChooseListsPage();
        assertTrue(chooseListsPage.isPageOpen(), "ChooseLists page was not open");

        log.info("3. Choose category of movies");
        chooseListsPage.clickListMoviesButtonByTitle(TestDataManager.getTEST_DATA().getCategory());
        MoviesListPage moviesListPage = new MoviesListPage();
        assertTrue(moviesListPage.isPageOpen(), "MoviesList page was not open");

        log.info("4. Check if page of right category open");
        String categoryTitle = moviesListPage.getCategoryTitle();
        assertEquals(TestDataManager.getTEST_DATA().getCategory(), categoryTitle, "Category title \"" + categoryTitle + "\" is not equal to \"" + TestDataManager.getTEST_DATA().getCategory() + "\"");

        log.info("5. Set filters and check amount of movies in list");
        moviesListPage.clickFilterByName(TestDataManager.getTEST_DATA().getAllCountries());
        moviesListPage.clickCheckboxOptionByName(TestDataManager.getTEST_DATA().getCountry());
        moviesListPage.clickFilterByName(TestDataManager.getTEST_DATA().getAllGenres());
        moviesListPage.clickCheckboxOptionByName(TestDataManager.getTEST_DATA().getGenre());
        int amountMoviesTotal = moviesListPage.getAmountMoviesTotal();
        log.info("Amount of movies total: " + amountMoviesTotal);
        int amountMoviesOnPage = moviesListPage.getAmountMoviesOnPage();
        log.info("Amount of movies on page: " + amountMoviesOnPage);
        assertEquals(amountMoviesTotal, amountMoviesOnPage, "Amount of movies on page: " + amountMoviesOnPage + " is not equal to amount of movies total: " + amountMoviesTotal);

        log.info("6. Check first movie's name on the list");
        String firstMovieName = moviesListPage.getFirstMovieName();
        log.info("First movie's name on the list: " + firstMovieName);
        assertEquals(TestDataManager.getTEST_DATA().getMovieName(), firstMovieName, "First movie's name on the list is \"" + firstMovieName + "\" but expected \"" + TestDataManager.getTEST_DATA().getMovieName() + "\"");
    }
}
