package org.finsecure.driver.singleton;

import org.finsecure.driver.factory.DriverFactory;
import org.finsecure.driver.manager.Browser;
import org.openqa.selenium.WebDriver;

public class DriverManager {
//    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){
        // Private constructor to prevent instantiation
    }
    public static WebDriver getDriver(String browserType) {
        if (driver.get() == null) {
            synchronized (DriverManager.class) {
                if (driver.get() == null) {
                    Browser browser = DriverFactory.getDriver(browserType);
                   WebDriver newdriver = browser.createDriver();
                   newdriver.manage().window().maximize();
                    driver.set(newdriver);
                }
            }
        }
        return driver.get();
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
