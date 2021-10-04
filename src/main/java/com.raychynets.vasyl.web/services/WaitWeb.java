package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;
import com.raychynets.vasyl.web.models.PageElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

@Log4j2
public class WaitWeb implements BaseWaitService {

    int defaultWaitDuration = 20;
    int defaultWaitPolling = 500;
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final BaseScrollService scrollService;

    public WaitWeb(final WebDriver driver, BaseScrollService scrollService) {
        this.driver = driver;
        this.scrollService = scrollService;
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitDuration));
    }

    @Step
    @Override
    public void waitForAnimation() {
        wait.until((ExpectedCondition<Boolean>) wdriver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        log.info("Animation completed");
    }

    @Step
    @Override
    public void waitAndAcceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        log.info("Alert appeared and was accepted");
    }

    @Step
    @Override
    public void waitToBeVisible(BaseElement element) {
        this.waitToBeVisible(element.getLocator());
    }

    @Step
    @Override
    public void waitToBeVisible(BaseElement element, int timeout) {
        log.info("Waiting until element {} will be visible.", element.getName());
        this.waitToBeVisible(element.getLocator(), timeout);
    }

    @Step
    @Override
    public void waitToBeVisible(By element) {
        this.waitToBeVisible(element, defaultWaitDuration);
    }

    @Step
    @Override
    public void waitToBeVisible(By by, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    @Step
    @Override
    public void waitToBeInvisible(BaseElement element) {
        this.waitToBeInvisible(element, defaultWaitDuration);
    }

    @Step
    @Override
    public void waitToBeInvisible(BaseElement element, int timeout) {
        this.waitToBeInvisible(element.getLocator(), timeout);
    }

    @Step
    @Override
    public void waitToBeInvisible(By by) {
        this.waitToBeInvisible(by, defaultWaitDuration);
    }

    @Step
    @Override
    public void waitToBeInvisible(By by, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    @Step
    @Override
    public void waitToBeClickable(BaseElement element) {
        this.waitToBeClickable(element, defaultWaitDuration);
    }

    @Step
    @Override
    public void waitToBeClickable(BaseElement element, int timeout) {
        this.waitToBeClickable(element.getLocator(), timeout);
    }

    @Step
    @Override
    public void waitToBeClickable(By by) {
        this.waitToBeClickable(by, defaultWaitDuration);
    }

    @Step
    @Override
    public void waitToBeClickable(By by, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(by));
    }

    @Step
    @Override
    public void waitToBePresent(BaseElement element) {
        this.waitToBePresent(element, defaultWaitDuration);
    }

    @Step
    @Override
    public void waitToBePresent(BaseElement element, int timeout) {
        this.waitToBePresent(element.getLocator(), timeout);
    }

    @Step
    @Override
    public void waitToBePresent(By by) {
        this.waitToBePresent(by, defaultWaitDuration);
    }


    @Step
    @Override
    public void waitToBePresent(By by, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    @Step
    @Override
    public void waitForAttributeValue(BaseElement element, String attributeName, String expectedValue) {
        this.waitForAttributeValue(element, defaultWaitDuration, attributeName, expectedValue);
    }

    @Step
    @Override
    public void waitForAttributeValue(BaseElement element, int timeout, String attributeName, String expectedValue) {
        this.waitForAttributeValue(element.getLocator(), timeout, attributeName, expectedValue);
    }

    @Step
    @Override
    public void waitForAttributeValue(By by, String attributeName, String expectedValue) {
        this.waitForAttributeValue(by, defaultWaitDuration, attributeName, expectedValue);
    }

    @Step
    @Override
    public void waitForAttributeValue(By by, int timeout, String attributeName, String expectedValue) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(50))
                .until(ExpectedConditions.attributeToBe(by, attributeName, expectedValue));
    }

    @Step
    @Override
    public int getDefaultWaitDuration() {
        return defaultWaitDuration;
    }

    @Step
    @Override
    public WebDriverWait getWait() {
        return wait;
    }

    @Override
    public void waitForTextEqual(PageElement actualText, String expectedText) {
        this.waitForTextEqual(actualText, expectedText, defaultWaitDuration);
    }

    @Override
    public void waitForTextEqual(final PageElement actualText, final String expectedText, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.textToBe(actualText.getLocator(), expectedText));
    }

    @Override
    public void sleep(int seconds) {
        if (seconds >= 1000) seconds /= 1000;
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
