package ru.kinopoisk.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.visible;

@Slf4j
public abstract class BasePage implements PagesUniqueElement {
    private final SelenideElement uniqueElement;

    public BasePage(SelenideElement uniqueElement) {
        this.uniqueElement = uniqueElement;
    }

    public boolean isPageOpen() {
        log.info("Waiting unique element visible");
        uniqueElement.shouldBe(visible);
        return uniqueElement.isDisplayed();
    }
}
