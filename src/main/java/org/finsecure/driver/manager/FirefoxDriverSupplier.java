package org.finsecure.driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverSupplier implements Browser{
    @Override
    public WebDriver createDriver(){
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
