package com.raychynets.vasyl.web.pages;

import com.raychynets.vasyl.web.constants.ApplicationProperties;
import com.raychynets.vasyl.web.models.BaseElement;
import com.raychynets.vasyl.web.models.PageElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;

@Log4j2
public class HomePage extends BaseWebPage {

    public enum HomeNavigationMenu {

        ELEMENTS(new PageElement(el -> {
            el.setName("Elements");
            el.setLocator(By.xpath("//h5[text()='Elements']"));
            el.setHasScroll(true);
        })),
        FORMS(new PageElement(el -> {
            el.setName("Forms");
            el.setLocator(By.xpath("//h5[text()='Forms']"));
            el.setHasScroll(true);
        })),
        ALERTS_FRAME_WINDOWS(new PageElement(el -> {
            el.setName("Alerts, Frame & Windows");
            el.setLocator(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            el.setHasScroll(true);
        })),
        WIDGETS(new PageElement(el -> {
            el.setName("Widgets");
            el.setLocator(By.xpath("//h5[text()='Widgets']"));
            el.setHasScroll(true);
        })),
        INTERACTIONS(new PageElement(el -> {
            el.setName("Interactions");
            el.setLocator(By.xpath("//h5[text()='Interactions']"));
            el.setHasScroll(true);
        })),
        BOOK_STORE_APPLICATION(new PageElement(el -> {
            el.setName("Book Store Application");
            el.setLocator(By.xpath("//h5[text()='Book Store Application']"));
            el.setHasScroll(true);
        }));

        private PageElement pageElement;

        HomeNavigationMenu(PageElement pageElement) {
            this.pageElement = pageElement;
        }

        public BaseElement getPageElement() {
            return pageElement;
        }

    }

    private final PageElement baseBanner = new PageElement(el -> {
        el.setName("Base banner");
        el.setLocator(By.className("home-banner"));
        el.setHasScroll(false);
    });


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public HomePage waitForPageLoad() {
        wait.waitToBePresent(baseBanner);
        wait.waitToBeVisible(baseBanner);
        return this;
    }

    @Step
    public HomePage verifyThatMainElementsAreDisplayed() {
        Arrays.asList(HomeNavigationMenu.values()).forEach(el -> {
            Assert.assertTrue(element.isElementVisible(el.pageElement));
        });
        return this;
    }

    @Step
    public void navigateTo(final HomeNavigationMenu menu) {
        log.info("Navigating to the <{}>.", menu.pageElement.getName());
        wait.waitToBeClickable(menu.pageElement);
        action.click(menu.pageElement);
    }

    public HomePage openSite() {
        driver.navigate().to(ApplicationProperties.BASE_URL);
        return this;
    }
}
