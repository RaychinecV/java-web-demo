package com.raychynets.vasyl.web.modules;

import com.google.inject.AbstractModule;
import com.raychynets.vasyl.web.driver.Driver;
import org.openqa.selenium.WebDriver;

public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {
        final WebDriver driver = Driver.getDriver();
        bind(WebDriver.class).toInstance(driver);
    }
}
