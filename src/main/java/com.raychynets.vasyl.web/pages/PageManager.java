package com.raychynets.vasyl.web.pages;

import com.raychynets.vasyl.web.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;


public class PageManager {

    private DriverManager driverManager;

    public PageManager() {
        driverManager = new DriverManager();
    }

    public synchronized <T extends BasePage> T getPageInstance(final Class<T> pageClass) {
        T pageInstance = null;
        try {
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
            pageInstance = constructor.newInstance(driverManager.getDriver());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(pageInstance);
    }
}
