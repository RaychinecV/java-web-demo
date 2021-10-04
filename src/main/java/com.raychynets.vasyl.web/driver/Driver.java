package com.raychynets.vasyl.web.driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void setUp() {
        WebDriver driver = new DriverFactory().create();
        DRIVER.set(driver);
        DRIVER.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        DRIVER.get().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        DRIVER.get().manage().window().maximize();
    }

    public static void tearDown() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}
