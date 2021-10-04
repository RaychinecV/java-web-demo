package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Log4j2
public class Element implements BaseElementService {

    private WebDriver driver;
    private BaseWaitService wait;
    private BaseScrollService scrollService;

    public Element(WebDriver driver, BaseWaitService wait, BaseScrollService scrollService) {
        this.driver = driver;
        this.wait = wait;
        this.scrollService = scrollService;
    }

    @Step
    @Override
    public WebElement find(BaseElement baseElement) {
        return this.find(baseElement, wait.getDefaultWaitDuration());
    }

    @Step
    @Override
    public WebElement find(BaseElement baseElement, Integer timeout) {
        if (baseElement.hasScroll()) scrollService.scrollToElement(baseElement, true);
        return this.find(baseElement.getLocator(), timeout);
    }

    @Step
    @Override
    public WebElement find(By by) {
        return this.find(by, wait.getDefaultWaitDuration());
    }

    @Step
    @Override
    public WebElement find(By by, Integer timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Step
    @Override
    public List<WebElement> findAll(BaseElement baseElement) {
        return this.findAll(baseElement.getLocator());
    }

    @Step
    @Override
    public List<WebElement> findAll(By by) {
        return driver.findElements(by);
    }

    @Override
    public boolean isElementVisible(BaseElement element) {
        return this.isElementVisible(element, wait.getDefaultWaitDuration());
    }

    @Override
    public boolean isElementVisible(BaseElement element, int timeout) {
        return this.isElementVisible(element.getLocator(), timeout);
    }

    @Override
    public boolean isElementVisible(By element) {
        return this.isElementVisible(element, wait.getDefaultWaitDuration());
    }

    @Override
    public boolean isElementVisible(By by, int timeout) {
        try {
            wait.waitToBeVisible(by, timeout);
            return true;
        } catch (TimeoutException ignore) {
        }
        return false;
    }

    @Override
    public boolean isElementPresent(BaseElement element) {
        return this.isElementPresent(element, wait.getDefaultWaitDuration());
    }

    @Override
    public boolean isElementPresent(BaseElement element, int timeout) {
        return this.isElementPresent(element.getLocator(), timeout);
    }

    @Override
    public boolean isElementPresent(By by) {
        return this.isElementPresent(by, wait.getDefaultWaitDuration());
    }

    @Override
    public boolean isElementPresent(By by, int timeout) {
        try {
            wait.waitToBePresent(by, timeout);
            return true;
        } catch (TimeoutException ignore) {
        }
        return false;
    }

    @Override
    public boolean isElementEnabled(BaseElement element) {
        return this.isElementEnabled(element, wait.getDefaultWaitDuration());
    }

    @Override
    public boolean isElementEnabled(BaseElement element, int timeout) {
        return this.isElementEnabled(element.getLocator(), timeout);
    }

    @Override
    public boolean isElementEnabled(By by) {
        return isElementEnabled(by, wait.getDefaultWaitDuration());
    }

    @Override
    public boolean isElementEnabled(By by, int timeout) {
        return find(by, timeout).isEnabled();
    }
}
