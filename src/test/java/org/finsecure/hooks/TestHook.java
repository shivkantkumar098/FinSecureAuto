package org.finsecure.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.finsecure.driver.singleton.DriverManager;
import org.finsecure.utils.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestHook {
    @Before
    public void setUp(Scenario scenario) {
        String browser = System.getProperty("browser", "chrome");
        DriverManager.getDriver(browser);
        System.out.println("Starting Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverManager.getDriver(null);

            // Attach screenshot to report
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");

            // Save screenshot to disk
            ScreenshotUtils.takeScreenshot(driver, scenario.getName().replaceAll(" ", "_"));
        }
        DriverManager.quitDriver();
        System.out.println("Ending Scenario: " + scenario.getName());
    }
}
