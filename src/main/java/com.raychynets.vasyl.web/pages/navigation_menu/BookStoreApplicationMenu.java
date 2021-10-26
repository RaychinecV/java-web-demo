package com.raychynets.vasyl.web.pages.navigation_menu;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.pages.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStoreApplicationMenu extends BaseWebPage implements BaseMenu {

    private final PageElement dropdownElements = new PageElement(el -> {
        el.setName("Elements dropdown");
        el.setLocator(By.xpath("//div[@class='header-wrapper']/div[text()='Book Store Application']"));
        el.setHasScroll(false);
    });
    private final PageElement openDropdownList = new PageElement(el -> {
        el.setName("Open dropdown list");
        el.setLocator(By.cssSelector(".element-list.collapse.show"));
        el.setHasScroll(false);
    });

    public enum BookStoreApplicationNavigationMenu {

        LOGIN(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Login']"));
            el.setHasScroll(false);
        })),
        BOOK_STORE(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Book Store']"));
            el.setHasScroll(false);
        })),
        PROFILE(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Profile']"));
            el.setHasScroll(false);
        })),
        BOOK_STORE_API(new PageElement(el -> {
            el.setLocator(By.xpath("//span[text()='Book Store API']"));
            el.setHasScroll(false);
        }));

        private PageElement pageElement;

        BookStoreApplicationNavigationMenu(PageElement pageElement) {
            this.pageElement = pageElement;
        }

        public PageElement getPageElement() {
            return pageElement;
        }

    }

    public BookStoreApplicationMenu(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public BookStoreApplicationMenu openMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeVisible(openDropdownList);
        return this;
    }

    @Step
    @Override
    public BookStoreApplicationMenu closeMenu() {
        wait.waitToBeClickable(dropdownElements);
        action.click(dropdownElements);
        wait.waitToBeInvisible(openDropdownList);
        return this;
    }

    @Step
    public BookStoreApplicationMenu select(BookStoreApplicationNavigationMenu menu) {
        wait.waitToBeVisible(openDropdownList);
        wait.waitToBeClickable(menu.pageElement);
        action.click(menu.pageElement);
        return this;
    }
}
