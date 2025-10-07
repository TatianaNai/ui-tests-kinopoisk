package ru.kinopoisk.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public interface PagesUniqueElement {
    SelenideElement HOME_PAGE_UNIQUE_ELEMENT = $x("//*[contains(@class,'styles_title') and contains(.,'Главная')]");
    SelenideElement SEARCH_PAGE_UNIQUE_ELEMENT = $x("//*[contains(@class,'search_results_topText')]");
    SelenideElement MOVIE_PAGE_UNIQUE_ELEMENT = $x("//img[contains(@class,'film-poster')]");
    SelenideElement CHOOSE_LISTS_PAGE_UNIQUE_ELEMENT = $x("//*[contains(@class,'styles_title') and contains(text(),'Списки')]");
    SelenideElement MOVIES_LISTS_PAGE_UNIQUE_ELEMENT = $x("//*[contains(@class,'styles_sidebarSlot')]");
}
