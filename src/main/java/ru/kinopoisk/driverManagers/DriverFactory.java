package ru.kinopoisk.driverManagers;

import lombok.SneakyThrows;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.kinopoisk.utils.Props;

import java.net.URL;

public class DriverFactory {
    @SneakyThrows
    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return new RemoteWebDriver(new URL(Props.getProperty("urlHub")), options);
    }
}
