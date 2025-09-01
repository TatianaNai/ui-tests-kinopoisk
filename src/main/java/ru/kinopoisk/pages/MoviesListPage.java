package ru.kinopoisk.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviesListPage extends BasePage{
    @FindBy(xpath = "//h1[contains(@class,'styles_title')]")
    private WebElement categoryTitle;

    public MoviesListPage() {
        super(MOVIES_LISTS_PAGE_LOCATOR);
    }

    public String getCategoryTitle() {
        return categoryTitle.getText();
    }
}
