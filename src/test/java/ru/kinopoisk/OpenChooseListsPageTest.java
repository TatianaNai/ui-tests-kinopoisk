package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import ru.kinopoisk.pages.ChooseListsPage;
import ru.kinopoisk.pages.HomePage;

import static org.testng.Assert.assertTrue;

@Slf4j
public class OpenChooseListsPageTest extends BaseTest{

    @Test(enabled=false)
    public void shouldHaveCorrectOpenChooseListsPage() {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage();
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Go to chooseLists page of Kinopoisk");
        homePage.clickMoviesButton();
        ChooseListsPage chooseListsPage = new ChooseListsPage();
        assertTrue(chooseListsPage.isPageOpen(), "ChooseLists page was not open");
    }
}
