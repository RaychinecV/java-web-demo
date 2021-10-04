package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface BaseElementService {

    WebElement find(BaseElement baseElement, Integer timeout);

    WebElement find(BaseElement baseElement);

    WebElement find(By by, Integer timeout);

    WebElement find(By baseElement);

    List<WebElement> findAll(BaseElement baseElement);

    List<WebElement> findAll(By by);

    boolean isElementVisible(BaseElement element);

    boolean isElementVisible(BaseElement element, int timeout);

    boolean isElementVisible(By element);

    boolean isElementVisible(By element, int timeout);

    boolean isElementPresent(BaseElement element);

    boolean isElementPresent(BaseElement element, int timeout);

    boolean isElementPresent(By element);

    boolean isElementPresent(By element, int timeout);

    boolean isElementEnabled(BaseElement element);

    boolean isElementEnabled(BaseElement element, int timeout);

    boolean isElementEnabled(By element);

    boolean isElementEnabled(By element, int timeout);

}
