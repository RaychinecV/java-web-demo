package com.raychynets.vasyl.web.steps.widget_steps;

import com.raychynets.vasyl.web.pages.PageManager;
import com.raychynets.vasyl.web.pages.navigation_menu.WidgetsMenu;
import com.raychynets.vasyl.web.pages.widgets.WidgetsPage;
import io.cucumber.java.en.When;

public class WidgetSteps {

    private WidgetsPage widgetsPage;
    private PageManager pageManager;

    public WidgetSteps(PageManager pageManager) {
        this.pageManager = pageManager;
        this.widgetsPage = pageManager.getPageInstance(WidgetsPage.class);
    }

    @When("^select in widgets submenu (PROGRESS_BAR|ACCORDIAN|AUTO_COMPLETE|DATE_PICKER|SLIDER|PROGRESS_BAR|TABS|TOOL_TIPS|MENU|SELECT_MENU)$")
    public void selectInWidgetsSubmenu(WidgetsMenu.WidgetsNavigationMenu submenu) {
        widgetsPage
                .waitForPageLoad()
                .navigationMenu
                .widgetsMenu
                .select(submenu);
    }
}
