package com.raychynets.vasyl.web.constants;

import com.raychynets.vasyl.web.driver.Browsers;

public final class ApplicationProperties {
    public static final Browsers BROWSER = Browsers.valueOf(System.getProperty("browser", "chrome").toUpperCase());
    public static final Browsers PLATFORM = Browsers.valueOf(System.getProperty("browser", "chrome").toUpperCase());
    public static final String BROWSER_VERSION = System.getProperty("browser.version");
    public static final String BASE_URL = System.getProperty("base.url", "https://demoqa.com/");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final boolean IS_HEADLESS = Boolean.parseBoolean(System.getProperty("is.headless", "false"));
    public static final boolean IS_REMOTE_WEB_DRIVER = Boolean.parseBoolean(System.getProperty("is.remote.webdriver"));
    public static final String REMOTE_DRIVER_URL = System.getProperty("remote.driver.url", "http://localhost:4444/wd/hub");

    private ApplicationProperties() {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
