package com.raychynets.vasyl.web.services;

import com.raychynets.vasyl.web.models.BaseElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class WebActions extends Actions implements BaseActionService {

    private WebDriver driver;
    private BaseWaitService waitService;
    private BaseElementService element;
    private BaseScrollService scroll;

    public WebActions(final WebDriver driver,
                      final BaseWaitService waitService,
                      final BaseElementService element,
                      final BaseScrollService scroll) {

        super(driver);
        this.driver = driver;
        this.waitService = waitService;
        this.element = element;
        this.scroll = scroll;
    }

    @Step
    @Override
    public void click(final BaseElement baseElement) {
        log.info("Clicking on the element <{}>.", baseElement.getName());
        element.find(baseElement).click();
        log.info("Clicked on the element <{}>.", baseElement.getName());
    }

    @Step
    @Override
    public void moveOnAndClick(BaseElement baseElement) {
        log.info("Clicking on the element <{}>.", baseElement.getName());
        moveToElement(element.find(baseElement)).click().build().perform();
        log.info("Clicked on the element <{}>.", baseElement.getName());
    }

    @Step
    @Override
    public String getText(final BaseElement baseElement) {
        log.info("Getting text from element <{}>.", baseElement.getName());
        String actualText = element.find(baseElement).getText();
        log.info("Text for element <{}> is <{}>.", baseElement.getName(), actualText);
        return actualText;
    }

    @Step
    @Override
    public String getInputValue(final BaseElement baseElement) {
        log.info("Getting value from element <{}>.", baseElement.getName());
        String value = element.find(baseElement).getAttribute("value");
        log.info("Value for element <{}> is <{}>.", baseElement.getName(), value);
        return value;
    }

    @Step
    @Override
    public void enterText(final BaseElement baseElement, final String text) {
        this.enterText(baseElement, text, false);
    }

    @Step
    @Override
    public void enterText(final BaseElement baseElement, final String text, final boolean clear) {
        log.info("Entering text <{}> to the element <{}>.", text, baseElement.getName());
        if (clear) {
            log.info("Clearing element field <{}>.", baseElement.getName());
            element.find(baseElement).clear();
        }
        element.find(baseElement).sendKeys(text);
        log.info("Entered text <{}> to the element <{}>.", text, baseElement.getName());
    }

    @Step
    @Override
    public void selectDropDownOptionByValue(final BaseElement baseElement, final String value) {
        log.info("Selecting option from element <{}> by value <{}>.", baseElement.getName(), value);
        final Select select = new Select(element.find(baseElement));
        select.selectByValue(value);
        log.info("Selected option from element <{}> by value <{}>.", baseElement.getName(), value);
    }

    @Step
    @Override
    public void selectDropDownOptionByText(final BaseElement baseElement, final String value) {
        log.info("Selecting option from element <{}> by value <{}>.", baseElement.getName(), value);
        final Select select = new Select(element.find(baseElement));
        select.selectByVisibleText(value);
        log.info("Selected option from element <{}> by value <{}>.", baseElement.getName(), value);
    }

    @Step
    @Override
    public void checkCheckbox(final BaseElement baseElement) {
        if (!element.find(baseElement).isEnabled()) {
            log.info("Enabling element <{}>.", baseElement.getName());
            click(baseElement);
        } else {
            log.info("Can't enable element <{}>. Element is enabled.", baseElement.getName());
        }
    }

    @Step
    @Override
    public void uncheckCheckbox(final BaseElement baseElement) {
        if (element.find(baseElement).isEnabled()) {
            log.info("Disabling element <{}>.", baseElement.getName());
            click(baseElement);
        } else {
            log.info("Can't disable element <{}>. Element is disabled.", baseElement.getName());
        }
    }

    @Step
    @Override
    public void dragAndDrop(final BaseElement from, final BaseElement to) {
        log.info("Drag from <{}> to <{}>.", from.getName(), to.getName());
        dragAndDrop(element.find(from), element.find(to)).perform();
    }

    @Step
    @Override
    public void doubleClick(final BaseElement baseElement) {
        log.info("Double clicking on the <{}>.", baseElement.getName());
        super.doubleClick(element.find(baseElement)).perform();
    }

    @Step
    @Override
    public void pressEnter() {
        log.info("Pressing to the enter.");
        super.sendKeys(Keys.ENTER).perform();
    }

    @Step
    @Override
    public void pressTab() {
        log.info("Pressing to the tab.");
        super.sendKeys(Keys.TAB).perform();
    }
}
