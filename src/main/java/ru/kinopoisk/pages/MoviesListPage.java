package ru.kinopoisk.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.kinopoisk.utils.WaitManager;

import java.util.*;

public class MoviesListPage extends BasePage{
    @FindBy(xpath = "//h1[contains(@class,'styles_title')]")
    private WebElement categoryTitle;
    @FindBy(xpath = "//*[contains(@class,'styles_subtitle') and preceding-sibling::*[contains(text(),'Все')]]")
    private WebElement amountMoviesTotalLabel;
    @FindBy(xpath = "//*[@data-test-id='movie-list-item']")
    private List<WebElement> movieItems;

    private final String filterLocator = "//*[contains(@class,'styles_buttonCaption') and contains(text(),'%s')]";
    private final String checkboxOptionLocator = "//*[contains(@class,'styles_title') and text()='%s']";
    private final String movieNameLocator = ".//*[contains(@class,'styles_mainTitle')]";
    private final String loadingElementsLocator = "//*[contains(@class,'styles_skeleton')]";

    public MoviesListPage() {
        super(MOVIES_LISTS_PAGE_LOCATOR);
    }

    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

    public void clickFilterByName(String name) {
        WaitManager.waitElementVisible(By.xpath(String.format(filterLocator, name))).click();
    }

    public void clickCheckboxOptionByName(String name) {
        WaitManager.waitElementVisible(By.xpath(String.format(checkboxOptionLocator, name))).click();
    }

    public int getAmountMoviesTotal() {
        WaitManager.waitElementsDisappear(By.xpath(loadingElementsLocator));
        String amountMoviesTotal = amountMoviesTotalLabel.getText();
        return Integer.parseInt(
                amountMoviesTotal.substring(0, amountMoviesTotal.indexOf(' '))
        );
    }

    public int getAmountMoviesOnPage() {
        WaitManager.waitElementsDisappear(By.xpath(loadingElementsLocator));
        return movieItems.size();
    }

    public String getFirstMovieName() {
        Optional<String> firstElement = movieItems.stream()
                .findFirst()
                .map(m -> m.findElement(By.xpath(movieNameLocator)).getText());
        if(firstElement.isPresent()) {
            return firstElement.get();
        }
        else {
            throw new NoSuchElementException("The list of movies is empty");
        }
    }
}
