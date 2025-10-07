package ru.kinopoisk;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.kinopoisk.utils.Props;
import ru.kinopoisk.utils.SelenideConfig;

public abstract class BaseTest {
    @BeforeEach
    public void setUp() {
        SelenideConfig.setUp();
        Selenide.open(Props.getProperty("url"));
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
