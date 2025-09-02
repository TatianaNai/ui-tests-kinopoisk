package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import ru.kinopoisk.pages.HomePage;

import static org.testng.Assert.assertTrue;
@Slf4j
public class OpenHomePageTest extends BaseTest {

    @Test(invocationCount=2)
    public void shouldHaveCorrectToOpenHomePage() {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage();
        assertTrue(homePage.isPageOpen(), "Home page was not open");
    }
}
