package ru.kinopoisk.pages;

import org.openqa.selenium.By;

public interface PagesUniqueElement {
    By HOME_PAGE_LOCATOR = By.xpath("//*[contains(@class,'styles_title') and contains(.,'Главная')]");
    By MOVIE_PAGE_LOCATOR = By.xpath("//img[contains(@class,'film-poster')]");
    By SEARCH_PAGE_LOCATOR = By.xpath("//*[contains(@class,'search_results_topText')]");
}
