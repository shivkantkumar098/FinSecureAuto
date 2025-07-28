package org.finsecure.driver.factory;

import org.finsecure.customException.BrowserNotSupported;
import org.finsecure.driver.manager.Browser;
import org.finsecure.driver.manager.ChromeDriverSupplier;
import org.finsecure.driver.manager.EdgeDriverSupplier;
import org.finsecure.driver.manager.FirefoxDriverSupplier;

public class DriverFactory {
    // This class is responsible for creating and managing WebDriver instances.
    // It will handle different browsers and configurations based on the provided settings.
    // The factory pattern allows for flexibility in creating driver instances without exposing the instantiation logic to the client.
    public static Browser getDriver(String browserType) {
        if (browserType == null || browserType.isEmpty()) {
            throw new IllegalArgumentException("Browser type cannot be null or empty");
        }

        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriverSupplier();
            case "firefox":
                return new FirefoxDriverSupplier();
            case "edge":
                return new EdgeDriverSupplier();
            default:
                throw new BrowserNotSupported("Unsupported browser type: " + browserType);
        }
    }
}
