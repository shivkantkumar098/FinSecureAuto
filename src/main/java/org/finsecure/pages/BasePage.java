package org.finsecure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// This file is part of the FinSecure project.
public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
