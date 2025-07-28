package org.FinsecureAuto.driver.manager;

import org.openqa.selenium.WebDriver;

public interface Browser {
    WebDriver createDriver();
    // This interface defines a contract for creating WebDriver instances.
}
