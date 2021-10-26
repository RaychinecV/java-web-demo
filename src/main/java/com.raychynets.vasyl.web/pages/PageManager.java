package com.raychynets.vasyl.web.pages;

import com.raychynets.vasyl.web.driver.DriverManager;
import com.raychynets.vasyl.web.pages.allerts_frame_window.AlertsFrameWindowPage;
import com.raychynets.vasyl.web.pages.book_store_application.BookStoreApplicationPage;
import com.raychynets.vasyl.web.pages.elements.ElementsPage;
import com.raychynets.vasyl.web.pages.elements.TextBoxPage;
import com.raychynets.vasyl.web.pages.elements.WebTablesPage;
import com.raychynets.vasyl.web.pages.elements.WebTablesRegistrationPopup;
import com.raychynets.vasyl.web.pages.forms.FormsPage;
import com.raychynets.vasyl.web.pages.interactions.InteractionsPage;
import com.raychynets.vasyl.web.pages.widgets.ProgressBarPage;
import com.raychynets.vasyl.web.pages.widgets.WidgetsPage;


public class PageManager {

    private DriverManager driverManager;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private FormsPage formsPage;
    private BookStoreApplicationPage bookStoreApplicationPage;
    private WidgetsPage widgetsPage;
    private InteractionsPage interactionsPage;
    private AlertsFrameWindowPage alertsFrameWindowPage;
    private TextBoxPage textBoxPage;
    private WebTablesPage webTablesPage;
    private WebTablesRegistrationPopup webTablesRegistrationPopup;
    private ProgressBarPage progressBarPage;

    public PageManager() {
        driverManager = new DriverManager();
    }

    public HomePage getHomePage() {
        return homePage == null ? new HomePage(driverManager.getDriver()) : homePage;
    }

    public ElementsPage getElementsPage() {
        return elementsPage == null ? new ElementsPage(driverManager.getDriver()) : elementsPage;
    }

    public FormsPage getFormsPage() {
        return formsPage == null ? new FormsPage(driverManager.getDriver()) : formsPage;
    }

    public BookStoreApplicationPage getBookStoreApplicationPage() {
        return bookStoreApplicationPage == null ? new BookStoreApplicationPage(driverManager.getDriver()) : bookStoreApplicationPage;
    }

    public WidgetsPage getWidgetsPage() {
        return widgetsPage == null ? new WidgetsPage(driverManager.getDriver()) : widgetsPage;
    }

    public InteractionsPage getInteractionsPage() {
        return interactionsPage == null ? new InteractionsPage(driverManager.getDriver()) : interactionsPage;
    }

    public AlertsFrameWindowPage getAlertsFrameWindowPage() {
        return alertsFrameWindowPage == null ? new AlertsFrameWindowPage(driverManager.getDriver()) : alertsFrameWindowPage;
    }

    public TextBoxPage getTextBoxPage() {
        return textBoxPage == null ? new TextBoxPage(driverManager.getDriver()) : textBoxPage;
    }

    public WebTablesPage getWebTablesPage() {
        return webTablesPage == null ? new WebTablesPage(driverManager.getDriver()) : webTablesPage;
    }

    public WebTablesRegistrationPopup getWebTablesRegistrationPopup() {
        return webTablesRegistrationPopup == null ? new WebTablesRegistrationPopup(driverManager.getDriver()) : webTablesRegistrationPopup;
    }

    public ProgressBarPage getProgressBarPage() {
        return progressBarPage == null ? new ProgressBarPage(driverManager.getDriver()) : progressBarPage;
    }
}
