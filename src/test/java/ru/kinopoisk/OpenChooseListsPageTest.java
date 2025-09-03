package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Isolated;
import ru.kinopoisk.pages.ChooseListsPage;
import ru.kinopoisk.pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Isolated
public class OpenChooseListsPageTest extends BaseTest {

    @RepeatedTest(3)
    @DisplayName("Open chooseLists page test")
    public void shouldHaveCorrectOpenChooseListsPage() {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Go to chooseLists page of Kinopoisk");
        homePage.clickMoviesButton();
        ChooseListsPage chooseListsPage = new ChooseListsPage(driver);
        assertTrue(chooseListsPage.isPageOpen(), "ChooseLists page was not open");
    }
}
