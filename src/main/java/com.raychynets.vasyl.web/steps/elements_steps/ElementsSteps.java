package com.raychynets.vasyl.web.steps.elements_steps;

import com.raychynets.vasyl.web.pages.PageManager;
import com.raychynets.vasyl.web.pages.elements.ElementsPage;
import com.raychynets.vasyl.web.pages.navigation_menu.ElementsMenu;
import io.cucumber.java.en.When;

public class ElementsSteps {

    private PageManager pageManager;
    private ElementsPage elementsPage;

    public ElementsSteps(PageManager pageManager) {
        this.pageManager = pageManager;
        this.elementsPage = pageManager.getPageInstance(ElementsPage.class);
    }

    @When("^select in elements submenu (TEXT_BOX|CHECK_BOX|RADIO_BUTTON|WEB_TABLES|BUTTONS|LINKS|BROKEN_LINKS_IMAGES|UPLOAD_AND_DOWNLOAD|DYNAMIC_PROPERTIES)$")
    public void selectInSubmenu(ElementsMenu.ElementsNavigationMenu submenu) {
        elementsPage
                .navigationMenu
                .elementsMenu
                .select(submenu);
    }
}
