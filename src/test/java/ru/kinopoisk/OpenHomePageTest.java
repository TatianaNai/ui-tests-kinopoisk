package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kinopoisk.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class OpenHomePageTest extends BaseTest{

    @Test
    @Disabled
    @DisplayName("Open home page test")
    public void shouldHaveCorrectOpenHomePage() {

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage();
        assertTrue(homePage.isPageOpen(), "Home page was not open");
    }
}
