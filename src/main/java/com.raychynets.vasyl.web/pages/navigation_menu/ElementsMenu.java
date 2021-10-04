package com.raychynets.vasyl.web.pages.navigation_menu;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.pages.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsMenu extends BaseWebPage implements BaseMenu {

    private final PageElement dropdownElements = new PageElement(el -> {
        el.setName("Elements dropdown");
        el.setLocator(By.xpath("//div[@class='header-wrapper']/div[text()='Elements']"));
        el.setHasScroll(false);
    });
    private final PageElement openDropdownList = new PageElement(el -> {
        el.setName("Open dropdown list");
        el.setLocator(By.cssSelector(".element-list.collapse.show"));
        el.setHasScroll(false);
    });

    public enum ElementsNavigationMenu {

        TEXT_BOX(new PageElement(el -> {
            el.setName("Text box");
            el.setLocator(By.xpath("//span[text()='Text Box']"));
            el.setHasScroll(false);
        })),
        CHECK_BOX(new PageElement(el -> {
            el.setName("Check box");
            el.setLocator(By.xpath("//span[text()='Check Box']"));
            el.setHasScroll(false);
        })),
        RADIO_BUTTON(new PageElement(el -> {
            el.setName("Radio Button");
            el.setLocator(By.xpath("//span[text()='Radio Button']"));
            el.setHasScroll(false);
        })),
        WEB_TABLES(new PageElement(el -> {
            el.setName("Web Tables");
            el.setLocator(By.xpath("//span[text()='Web Tables']"));
            el.setHasScroll(false);
        })),
        BUTTONS(new PageElement(el -> {
            el.setName("Buttons");
            el.setLocator(By.xpath("//span[text()='Buttons']"));
            el.setHasScroll(false);
        })),
        LINKS(new PageElement(el -> {
            el.setName("Links");
            el.setLocator(By.xpath("//span[text()='Links']"));
            el.setHasScroll(false);
        })),
        BROKEN_LINKS_IMAGES(new PageElement(el -> {
            el.setName("Broken Links - Images");
            el.setLocator(By.xpath("//span[text()='Broken Links - Images']"));
            el.setHasScroll(false);
        })),
        UPLOAD_AND_DOWNLOAD(new PageElement(el -> {
            el.setName("Upload and Download");
            el.setLocator(By.xpath("Upload and Download"));
            el.setHasScroll(false);
        })),
        DYNAMIC_PROPERTIES(new PageElement(el -> {
            el.setName("Dynamic Properties");
            el.setLocator(By.xpath("//span[text()='Dynamic Properties']"));
            el.setHasScroll(false);
        }));

        private PageElement pageElement;

        @Inject
        ElementsNavigationMenu(PageElement pageElement) {
            this.pageElement = pageElement;
        }

        public PageElement getPageElement() {
            return pageElement;
        }

    }

    public ElementsMenu(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public ElementsMenu openMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeVisible(openDropdownList);
        return this;
    }

    @Step
    @Override
    public ElementsMenu closeMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeInvisible(openDropdownList);
        return this;
    }

    @Step
    public ElementsMenu select(ElementsNavigationMenu menu) {
        wait.waitToBeVisible(openDropdownList);
        wait.waitToBeClickable(menu.pageElement);
        action.click(menu.pageElement);
        return this;
    }
}
