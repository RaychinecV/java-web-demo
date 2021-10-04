package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class WebScroll implements BaseScrollService {

    private final WebDriver driver;

    public WebScroll(final WebDriver driver) {
        this.driver = driver;
    }

    @Step
    @Override
    public void scrollToElement(BaseElement element, boolean isIntoView) {
        this.scrollToElement(element.getLocator(), isIntoView);
        log.info("Successfully scrolled to element <{}>.", element.getName());
    }

    @Step
    @Override
    public void scrollToElement(By by, boolean isIntoView) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].scrollIntoView(%b);", isIntoView), element);
    }
}