package com.raychynets.vasyl.web.pages;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.services.BaseActionService;
import com.raychynets.vasyl.web.services.BaseElementService;
import com.raychynets.vasyl.web.services.BaseScrollService;
import com.raychynets.vasyl.web.services.BaseWaitService;
import org.assertj.core.api.WithAssertions;
import org.openqa.selenium.WebDriver;

public abstract class BasePage implements WithAssertions {

    protected WebDriver driver;
    protected BaseWaitService wait;
    protected BaseElementService element;
    protected BaseScrollService scroll;
    protected BaseActionService action;

    @Inject
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
