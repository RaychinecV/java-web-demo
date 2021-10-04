package com.raychynets.vasyl.web.driver;

public enum Browsers {
    CHROME("chrome"), FIREFOX("firefox");

    private String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
