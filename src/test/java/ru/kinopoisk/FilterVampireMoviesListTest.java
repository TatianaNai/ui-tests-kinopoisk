package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.pages.ChooseListsPage;
import ru.kinopoisk.pages.MoviesListPage;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class FilterVampireMoviesListTest extends BaseTest{

    @Test
    public void shouldHaveCorrectFilterMoviesList() {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage();
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Go to chooseLists page of Kinopoisk");
        homePage.clickMoviesButton();
        ChooseListsPage chooseListsPage = new ChooseListsPage();
        assertTrue(chooseListsPage.isPageOpen(), "ChooseLists page was not open");

        log.info("3. Choose category of movies");
        chooseListsPage.clickListMoviesButtonByTitle("Фильмы про вампиров");
        MoviesListPage moviesListPage = new MoviesListPage();
        assertTrue(moviesListPage.isPageOpen(), "MoviesList page was not open");

        log.info("4. Check if page of right category open");
        String categoryTitle = moviesListPage.getCategoryTitle();
        assertEquals("Фильмы про вампиров", categoryTitle, "Category title \"" + categoryTitle + "\" is not equal to \"Фильмы про вампиров\"");

    }
}
