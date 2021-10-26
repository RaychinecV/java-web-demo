package com.raychynets.vasyl.web.pages.navigation_menu;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.pages.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsFrameWindowMenu extends BaseWebPage implements BaseMenu {

    private final PageElement dropdownElements = new PageElement(el -> {
        el.setName("Elements dropdown");
        el.setLocator(By.xpath("//div[@class='header-wrapper']/div[text()='Alerts, Frame & Windows']"));
        el.setHasScroll(false);
    });
    private final PageElement openDropdownList = new PageElement(el -> {
        el.setName("Open dropdown list");
        el.setLocator(By.cssSelector(".element-list.collapse.show"));
        el.setHasScroll(false);
    });

    public enum AlertsFrameWindowMenuNavigationMenu {

        BROWSER_WINDOWS(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Browser Windows']"));
            el.setHasScroll(false);
        })),
        ALERTS(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Alerts']"));
            el.setHasScroll(false);
        })),
        FRAMES(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Frames']"));
            el.setHasScroll(false);
        })),
        NESTED_FRAMES(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Nested Frames']"));
            el.setHasScroll(false);
        })),
        MODAL_DIALOGS(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Modal Dialogs']"));
            el.setHasScroll(false);
        }));

        private PageElement pageElement;

        AlertsFrameWindowMenuNavigationMenu(PageElement pageElement) {
            this.pageElement = pageElement;
        }

        public PageElement getPageElement() {
            return pageElement;
        }

    }


    public AlertsFrameWindowMenu(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public AlertsFrameWindowMenu openMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeVisible(openDropdownList);
        return this;
    }

    @Step
    @Override
    public AlertsFrameWindowMenu closeMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeInvisible(openDropdownList);
        return this;
    }

    @Step
    public AlertsFrameWindowMenu select(AlertsFrameWindowMenuNavigationMenu menu) {
        wait.waitToBeVisible(openDropdownList);
        wait.waitToBeClickable(menu.pageElement);
        action.click(menu.pageElement);
        return this;
    }
}
