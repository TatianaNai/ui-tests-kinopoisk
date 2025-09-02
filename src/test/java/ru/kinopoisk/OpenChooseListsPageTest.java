package ru.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import ru.kinopoisk.pages.ChooseListsPage;
import ru.kinopoisk.pages.HomePage;
import ru.kinopoisk.utils.Props;

import static org.testng.Assert.assertTrue;

@Slf4j
public class OpenChooseListsPageTest extends BaseTest{

    @Test
    public void shouldHaveCorrectOpenChooseListsPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);
        driver.get(Props.getProperty("url"));

        log.info("1. Go to home page of Kinopoisk");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isPageOpen(), "Home page was not open");

        log.info("2. Go to chooseLists page of Kinopoisk");
        homePage.clickMoviesButton();
        ChooseListsPage chooseListsPage = new ChooseListsPage(driver);
        assertTrue(chooseListsPage.isPageOpen(), "ChooseLists page was not open");

        driver.quit();
    }
}
