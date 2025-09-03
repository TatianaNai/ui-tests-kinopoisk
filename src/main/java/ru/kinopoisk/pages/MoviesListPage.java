package ru.kinopoisk.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class MoviesListPage extends BasePage {
    private final SelenideElement categoryTitle = $x("//h1[contains(@class,'styles_title')]");
    private final SelenideElement amountMoviesTotalLabel = $x("//*[contains(@class,'styles_subtitle') and preceding-sibling::*[contains(text(),'Все')]]");
    private final ElementsCollection movieItems = $$x("//*[@data-test-id='movie-list-item']");
    private final ElementsCollection loadingElements = $$x("//*[contains(@class,'styles_skeleton')]");

    private final String filterLocator = "//*[contains(@class,'styles_buttonCaption') and contains(text(),'%s')]";
    private final String checkboxOptionLocator = "//*[contains(@class,'styles_title') and text()='%s']";
    private final String movieNameLocator = ".//*[contains(@class,'styles_mainTitle')]";

    public MoviesListPage() {
        super(MOVIES_LISTS_PAGE_UNIQUE_ELEMENT);
    }

    public String getCategoryTitle() {
        log.info("Getting category title");
        return categoryTitle.getText();
    }

    public void clickFilterByName(String name) {
        log.info(String.format("Clicking filter by name: %s", name));
        $x(String.format(filterLocator, name)).click();
    }

    public void clickCheckboxOptionByName(String name) {
        log.info(String.format("Clicking checkbox option by name: %s", name));
        $x(String.format(checkboxOptionLocator, name)).click();
    }

    public int getAmountMoviesTotal() {
        loadingElements.shouldBe(CollectionCondition.size(0));
        log.info("Getting total amount of movies");
        String amountMoviesTotal = amountMoviesTotalLabel.getText();
        log.info(String.format("total amount of movies: %s", amountMoviesTotal));
        return Integer.parseInt(
                amountMoviesTotal.substring(0, amountMoviesTotal.indexOf(' '))
        );
    }

    public int getAmountMoviesOnPage() {
        log.info("Getting amount of movies on page");
        loadingElements.shouldBe(CollectionCondition.size(0));
        return movieItems.size();
    }

    public String getFirstMovieName() {
        log.info("Getting first movie name");
        return movieItems.first().$x(movieNameLocator).getText();
    }
}
