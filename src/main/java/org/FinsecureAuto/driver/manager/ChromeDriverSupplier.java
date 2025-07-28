package org.FinsecureAuto.driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSupplier implements Browser{
    @Override
    public WebDriver createDriver(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
