package com.raychynets.vasyl.web.pages.navigation_menu;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.pages.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WidgetsMenu extends BaseWebPage implements BaseMenu {

    private final PageElement dropdownElements = new PageElement(el -> {
        el.setName("Elements dropdown");
        el.setLocator(By.xpath("//div[@class='header-wrapper']/div[text()='Widgets']"));
        el.setHasScroll(false);
    });
    private final PageElement openDropdownList = new PageElement(el -> {
        el.setName("Open dropdown list");
        el.setLocator(By.cssSelector(".element-list.collapse.show"));
        el.setHasScroll(false);
    });

    public enum WidgetsNavigationMenu {

        ACCORDIAN(new PageElement(el -> {
            el.setName("Accordian");
            el.setLocator(By.xpath("//span[text()='Accordian']"));
            el.setHasScroll(true);
        })),
        AUTO_COMPLETE(new PageElement(el -> {
            el.setName("Auto Complete");
            el.setLocator(By.xpath("//span[text()='Auto Complete']"));
            el.setHasScroll(true);
        })),
        DATE_PICKER(new PageElement(el -> {
            el.setName("Date Picker");
            el.setLocator(By.xpath("//span[text()='Date Picker']"));
            el.setHasScroll(true);
        })),
        SLIDER(new PageElement(el -> {
            el.setName("Slider");
            el.setLocator(By.xpath("//span[text()='Slider']"));
            el.setHasScroll(true);
        })),
        PROGRESS_BAR(new PageElement(el -> {
            el.setName("Progress Bar");
            el.setLocator(By.xpath("//span[text()='Progress Bar']"));
            el.setHasScroll(true);
        })),
        TABS(new PageElement(el -> {
            el.setName("Tabs");
            el.setLocator(By.xpath("//span[text()='Tabs']"));
            el.setHasScroll(true);
        })),
        TOOL_TIPS(new PageElement(el -> {
            el.setName("Tool Tips");
            el.setLocator(By.xpath("//span[text()='Tool Tips']"));
            el.setHasScroll(true);
        })),
        MENU(new PageElement(el -> {
            el.setName("Menu");
            el.setLocator(By.xpath("//span[text()='Menu']"));
            el.setHasScroll(true);
        })),
        SELECT_MENU(new PageElement(el -> {
            el.setName("Select Menu");
            el.setLocator(By.xpath("//span[text()='Select Menu']"));
            el.setHasScroll(true);
        }));

        private PageElement pageElement;

        WidgetsNavigationMenu(PageElement pageElement) {
            this.pageElement = pageElement;
        }

        public PageElement getPageElement() {
            return pageElement;
        }

    }

    public WidgetsMenu(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public WidgetsMenu openMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeVisible(openDropdownList);
        return this;
    }

    @Step
    @Override
    public WidgetsMenu closeMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeInvisible(openDropdownList);
        return this;
    }

    @Step
    public WidgetsMenu select(WidgetsNavigationMenu menu) {
        wait.waitToBeVisible(openDropdownList);
        wait.waitToBeClickable(menu.pageElement);
        action.click(menu.pageElement);
        return this;
    }
}
