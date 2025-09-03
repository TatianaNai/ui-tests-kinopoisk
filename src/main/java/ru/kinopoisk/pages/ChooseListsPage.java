package ru.kinopoisk.pages;


import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class ChooseListsPage extends BasePage{
    private final String titleLocator = "//*[contains(@class,'styles_name') and contains(text(),'%s')]";

    public ChooseListsPage() {
        super(CHOOSE_LISTS_PAGE_UNIQUE_ELEMENT);
    }

    public void clickListMoviesButtonByTitle(String title) {
        log.info(String.format("Clicking ListMoviesButton by name: %s", title));
        $x(String.format(titleLocator, title)).click();
    }
}
