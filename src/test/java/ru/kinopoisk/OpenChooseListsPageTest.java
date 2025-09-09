package ru.kinopoisk;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import ru.kinopoisk.pages.ChooseListsPage;
import ru.kinopoisk.pages.HomePage;

import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class OpenChooseListsPageTest extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("Open chooseLists page test")
    @Severity(NORMAL)
    @Feature("Base")
    @Step("Step Open chooseLists page test")
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
