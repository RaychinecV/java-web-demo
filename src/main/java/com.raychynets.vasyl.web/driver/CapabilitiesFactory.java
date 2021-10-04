package com.raychynets.vasyl.web.driver;

import com.raychynets.vasyl.web.constants.ApplicationProperties;
import com.raychynets.vasyl.web.services.Factory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;
import java.util.HashMap;

public class CapabilitiesFactory implements Factory<Capabilities, CapabilitiesFactory> {

    private final Browsers browser = ApplicationProperties.BROWSER;
    private final String browserVersion = ApplicationProperties.BROWSER_VERSION;
    private final boolean isHeadless = ApplicationProperties.IS_HEADLESS;
    private final boolean isRemoteWebDriver = ApplicationProperties.IS_REMOTE_WEB_DRIVER;

    @Override
    public Capabilities create() {
        switch (browser) {
            case CHROME:
                return this.getChromeCapabilities();
            case FIREFOX:
                return this.getFirefoxCapabilities();
            default:
                throw new IllegalArgumentException("Please select from exist browsers: " + Arrays.toString(Browsers.values()));
        }
    }

    private ChromeOptions getChromeCapabilities() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.setHeadless(isHeadless);
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--lang=en-GB");
        if (isRemoteWebDriver) {
            chromeOptions.setCapability("browserName", browser.getBrowser());
            chromeOptions.setCapability("browserVersion", browserVersion);
            chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
                put("enableVNC", true);
                put("enableVideo", true);
            }});
        }
        return chromeOptions;
    }

    private FirefoxOptions getFirefoxCapabilities() {
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(isHeadless);
        firefoxOptions.setCapability("marionette", true);
        if (isRemoteWebDriver) {
            firefoxOptions.setCapability("browserName", browser.getBrowser());
            firefoxOptions.setCapability("browserVersion", browserVersion);
            firefoxOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
                put("enableVNC", true);
                put("enableVideo", true);
            }});
        }
        return firefoxOptions;
    }
}
