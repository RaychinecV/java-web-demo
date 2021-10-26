package com.raychynets.vasyl.web.pages;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.services.Element;
import com.raychynets.vasyl.web.services.WaitWeb;
import com.raychynets.vasyl.web.services.WebActions;
import com.raychynets.vasyl.web.services.WebScroll;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BaseWebPage extends BasePage {

    protected final PageElement hideCommercialArrow = new PageElement(el -> {
        el.setName("Hide commercial arrow");
        el.setLocator(By.id("close-fixedban"));
        el.setHasScroll(false);
    });


    public BaseWebPage(WebDriver driver) {
        super(driver);
        scroll = new WebScroll(driver);
        wait = new WaitWeb(driver, scroll);
        element = new Element(driver, wait, scroll);
        action = new WebActions(driver, wait, element, scroll);
    }

    @Step
    public <T extends BaseWebPage> T hideCommercialBanner() {
        log.info("Hiding commercial banner.");
        wait.waitToBeClickable(hideCommercialArrow);
        action.click(hideCommercialArrow);
        wait.waitToBeInvisible(hideCommercialArrow);
        log.info("Commercial banner hidden.");
        return (T) this;
    }

}
