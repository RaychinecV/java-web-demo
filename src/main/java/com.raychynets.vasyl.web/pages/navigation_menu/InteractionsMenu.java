package com.raychynets.vasyl.web.pages.navigation_menu;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.pages.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InteractionsMenu extends BaseWebPage implements BaseMenu {

    private final PageElement dropdownElements = new PageElement(el -> {
        el.setName("Elements dropdown");
        el.setLocator(By.xpath("//div[@class='header-wrapper']/div[text()='Interactions']"));
        el.setHasScroll(false);
    });
    private final PageElement openDropdownList = new PageElement(el -> {
        el.setName("Open dropdown list");
        el.setLocator(By.cssSelector(".element-list.collapse.show"));
        el.setHasScroll(false);
    });

    public enum FormsNavigationMenu {

        SORTABLE(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Sortable']"));
            el.setHasScroll(false);
        })),
        SELECTABLE(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Selectable']"));
            el.setHasScroll(false);
        })),
        RESIZABLE(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Resizable']"));
            el.setHasScroll(false);
        })),
        DROPPABLE(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Droppable']"));
            el.setHasScroll(false);
        })),
        DRAGABBLE(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Dragabble']"));
            el.setHasScroll(false);
        }));

        private PageElement pageElement;

        FormsNavigationMenu(PageElement pageElement) {
            this.pageElement = pageElement;
        }

        public PageElement getPageElement() {
            return pageElement;
        }

    }

    public InteractionsMenu(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public InteractionsMenu openMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeVisible(openDropdownList);
        return this;
    }

    @Step
    @Override
    public InteractionsMenu closeMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeInvisible(openDropdownList);
        return this;
    }

    @Step
    public InteractionsMenu select(FormsNavigationMenu menu) {
        wait.waitToBeVisible(openDropdownList);
        wait.waitToBeClickable(menu.pageElement);
        action.click(menu.pageElement);
        return this;
    }
}
