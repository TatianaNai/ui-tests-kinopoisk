package ru.kinopoisk.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.kinopoisk.driverManagers.Driver;

public class ScreenshotManager {
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) Driver.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
