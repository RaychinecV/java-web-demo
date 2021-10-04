package com.raychynets.vasyl.web.pages.navigation_menu;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;

public class NavigationMenu {

    public ElementsMenu elementsMenu;
    public FormsMenu formsMenu;
    public AlertsFrameWindowMenu alertsFrameWindowMenu;
    public WidgetsMenu widgetsMenu;
    public InteractionsMenu interactionsMenu;
    public BookStoreApplicationMenu bookStoreApplicationMenu;

    @Inject
    public NavigationMenu(WebDriver driver) {
        this.elementsMenu = new ElementsMenu(driver);
        this.formsMenu = new FormsMenu(driver);
        this.alertsFrameWindowMenu = new AlertsFrameWindowMenu(driver);
        this.widgetsMenu = new WidgetsMenu(driver);
        this.interactionsMenu = new InteractionsMenu(driver);
        this.bookStoreApplicationMenu = new BookStoreApplicationMenu(driver);
    }
}
