package ru.kinopoisk;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.kinopoisk.pages.HomePage;

public class FindMovieTest extends BaseTest{
    @Test
    public void shouldHaveCorrectToFindMovie() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageOpen());

        homePage.typeTextInSearchMovieInput("Начало");
        homePage.clickSearchButton();
    }
}
