package com.raychynets.vasyl.web.driver;

import com.raychynets.vasyl.web.constants.ApplicationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import com.raychynets.vasyl.web.services.Factory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Arrays;
import java.util.Objects;

public class DriverFactory implements Factory<WebDriver, DriverFactory> {

    private Browsers browser = ApplicationProperties.BROWSER;
    private boolean isRemoteWebDriver = ApplicationProperties.IS_REMOTE_WEB_DRIVER;

    @Override
    public WebDriver create() {

        final Capabilities options = new CapabilitiesFactory().create();

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return this.getChromeDriver(options);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return this.getFirefoxDriver(options);
            default:
                throw new IllegalArgumentException("Please select from exist browsers: " + Arrays.toString(Browsers.values()));
        }
    }

    private WebDriver getChromeDriver(Capabilities options) {
        return isRemoteWebDriver ? this.getRemoteWebDriver(options) : new ChromeDriver((ChromeOptions) options);
    }

    private WebDriver getFirefoxDriver(Capabilities options) {
        return isRemoteWebDriver ? this.getRemoteWebDriver(options) : new FirefoxDriver((FirefoxOptions) options);
    }

    private WebDriver getRemoteWebDriver(Capabilities options) {
        WebDriver driver = null;
        final String url = ApplicationProperties.REMOTE_DRIVER_URL;
        try {
            driver = new RemoteWebDriver(URI.create(url).toURL(), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(driver);
    }
}
