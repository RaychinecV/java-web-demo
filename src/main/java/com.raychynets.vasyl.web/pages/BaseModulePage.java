package com.raychynets.vasyl.web.pages;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.pages.navigation_menu.NavigationMenu;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
@Getter
public abstract class BaseModulePage extends BaseWebPage {

    public NavigationMenu navigationMenu;
    protected String expectedTitle;

    protected final PageElement actualTitle = new PageElement(el -> {
        el.setName("Title");
        el.setLocator(By.className("main-header"));
        el.setHasScroll(false);
    });

    @Inject
    public BaseModulePage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    @Step
    public <T extends BaseModulePage> T waitForPageLoad() {
        wait.waitToBeVisible(actualTitle);
        wait.waitForTextEqual(actualTitle, expectedTitle);
        return (T) this;
    }

    @Step
    public <T extends BaseModulePage> T validateThatActualTitleAndExpectedAreSame() {
        assertThat(action.getText(actualTitle))
                .as("Actual title and expected should de same!!!")
                .isEqualTo(expectedTitle);
        return (T) this;
    }

}
