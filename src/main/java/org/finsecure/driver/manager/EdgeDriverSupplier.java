package org.finsecure.driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverSupplier implements Browser{
    @Override
    public WebDriver createDriver(){
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
