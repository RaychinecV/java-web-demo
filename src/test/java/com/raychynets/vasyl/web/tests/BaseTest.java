package com.raychynets.vasyl.web.tests;

import com.google.inject.Guice;
import com.raychynets.vasyl.web.constants.ApplicationProperties;
import com.raychynets.vasyl.web.driver.Driver;
import com.raychynets.vasyl.web.listener.TestListener;
import com.raychynets.vasyl.web.modules.DriverModule;
import com.raychynets.vasyl.web.pages.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.WithAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Log4j2

@Listeners(TestListener.class)
public abstract class BaseTest implements WithAssertions {

    @Step
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Driver.setUp();
        injectPages();
    }

    @Step
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.tearDown();
    }

    @Step
    protected void injectPages() {
        Guice.createInjector(new DriverModule()).injectMembers(this);
    }

    @Step
    protected void openSite() {
        this.openSite(ApplicationProperties.BASE_URL);
    }

    @Step
    protected void openSite(final String url) {
        log.info("Opening site <{}>.", url);
        Driver.getDriver().navigate().to(url);
    }

    protected synchronized <T extends BasePage> T getPageInstance(final Class<T> pageClass) {
        T pageInstance = null;
        try {
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
            pageInstance = constructor.newInstance(Driver.getDriver());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(pageInstance);
    }
}

