package org.FinsecureAuto.driver.singleton;

import org.FinsecureAuto.driver.factory.DriverFactory;
import org.FinsecureAuto.driver.manager.Browser;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;
    private DriverManager(){
        // Private constructor to prevent instantiation
    }
    public static WebDriver getDriver(String browserType) {
        if (driver == null) {
            synchronized (DriverManager.class) {
                if (driver == null) {
                    Browser browser = DriverFactory.getDriver(browserType);
                    driver = browser.createDriver();
                }
            }
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
