package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;
import com.raychynets.vasyl.web.models.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface BaseWaitService {

    void waitForAnimation();

    void waitAndAcceptAlert();

    void waitToBeVisible(BaseElement element);

    void waitToBeVisible(BaseElement element, int timeout);

    void waitToBeVisible(By element);

    void waitToBeVisible(By by, int timeoutMs);

    void waitToBeInvisible(BaseElement element);

    void waitToBeInvisible(BaseElement element, int timeout);

    void waitToBeInvisible(By by);

    void waitToBeInvisible(By by, int timeout);

    void waitToBeClickable(BaseElement element);

    void waitToBeClickable(BaseElement element, int timeout);

    void waitToBeClickable(By by);

    void waitToBeClickable(By by, int timeout);

    void waitToBePresent(BaseElement element);

    void waitToBePresent(BaseElement element, int timeout);

    void waitToBePresent(By by);

    void waitToBePresent(By by, int timeout);

    void waitForAttributeValue(BaseElement element, String attributeName, String expectedValue);

    void waitForAttributeValue(BaseElement element, int timeout, String attributeName, String expectedValue);

    void waitForAttributeValue(By by, int timeout, String attributeName, String expectedValue);

    void waitForAttributeValue(By by, String attributeName, String expectedValue);

    int getDefaultWaitDuration();

    WebDriverWait getWait();

    void waitForTextEqual(PageElement actualText, String expectedText);

    void waitForTextEqual(PageElement actualText, String expectedText, int timeout);

    void sleep(int timeout);

}
