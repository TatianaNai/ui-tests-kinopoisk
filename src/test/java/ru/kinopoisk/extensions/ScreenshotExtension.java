package ru.kinopoisk.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.kinopoisk.driverManagers.Driver;
import ru.kinopoisk.utils.ScreenshotManager;

public class ScreenshotExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent() && Driver.INSTANCE.getDriver() != null) {
            ScreenshotManager.takeScreenshot();
        }
    }
}
