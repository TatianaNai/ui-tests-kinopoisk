package ru.kinopoisk.utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.kinopoisk.driverManagers.Driver;

public class ScreenshotUtil implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        boolean testFailed = context.getExecutionException().isPresent();
        if (testFailed) {
            if (Driver.INSTANCE.getDriver() != null) {
                takeScreenshot();
            }
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] takeScreenshot() {
        return ((TakesScreenshot) Driver.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
