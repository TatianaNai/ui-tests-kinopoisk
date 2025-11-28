package ru.kinopoisk.pages;

import org.openqa.selenium.By;
import ru.kinopoisk.utils.WaitManager;

public class ChooseListsPage extends BasePage {
    private final String titleLocator = "//*[contains(@class,'styles_name') and contains(text(),'%s')]";

    public ChooseListsPage() {
        super(CHOOSE_LISTS_PAGE_LOCATOR);
    }

    public void clickListMoviesButtonByTitle(String title) {
        WaitManager.waitElementVisible(By.xpath(String.format(titleLocator, title))).click();
    }
}
