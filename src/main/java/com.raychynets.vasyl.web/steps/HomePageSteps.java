package com.raychynets.vasyl.web.steps;

import com.raychynets.vasyl.web.pages.BaseModulePage;
import com.raychynets.vasyl.web.pages.HomePage;
import com.raychynets.vasyl.web.pages.PageManager;
import com.raychynets.vasyl.web.pages.allerts_frame_window.AlertsFrameWindowPage;
import com.raychynets.vasyl.web.pages.book_store_application.BookStoreApplicationPage;
import com.raychynets.vasyl.web.pages.elements.ElementsPage;
import com.raychynets.vasyl.web.pages.forms.FormsPage;
import com.raychynets.vasyl.web.pages.interactions.InteractionsPage;
import com.raychynets.vasyl.web.pages.widgets.WidgetsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
public class HomePageSteps {

    private HomePage homePage;
    private PageManager pageManager;

    public HomePageSteps(PageManager pageManager) {
        this.pageManager = pageManager;
        homePage = pageManager.getPageInstance(HomePage.class);
    }

    @Step
    @When("hide commercial banner")
    public void hideCommercialBanner() {
        homePage.hideCommercialBanner();
    }

    @Step
    @Given("^open site$")
    public void openSite() {
        homePage.openSite();
    }

    @Step
    @When("^navigate to (ELEMENTS|FORMS|ALERTS_FRAME_WINDOWS|WIDGETS|INTERACTIONS|BOOK_STORE_APPLICATION)$")
    public void navigateToPage(final HomePage.HomeNavigationMenu page) {
        homePage
                .waitForPageLoad()
                .verifyThatMainElementsAreDisplayed()
                .navigateTo(page);
        this.getPageFromHomeNavigationMenu(page)
                .waitForPageLoad();
    }

    @Step
    @Then("^validate that user is redirected to (ELEMENTS|FORMS|ALERTS_FRAME_WINDOWS|WIDGETS|INTERACTIONS|BOOK_STORE_APPLICATION)$")
    public void validateThatUserIsRedirectedToPage(final HomePage.HomeNavigationMenu page) {
        this.getPageFromHomeNavigationMenu(page)
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
    }

    @Step
    private BaseModulePage getPageFromHomeNavigationMenu(final HomePage.HomeNavigationMenu page) {
        switch (page) {
            case ELEMENTS:
                return pageManager.getPageInstance(ElementsPage.class);
            case FORMS:
                return pageManager.getPageInstance(FormsPage.class);
            case BOOK_STORE_APPLICATION:
                return pageManager.getPageInstance(BookStoreApplicationPage.class);
            case WIDGETS:
                return pageManager.getPageInstance(WidgetsPage.class);
            case INTERACTIONS:
                return pageManager.getPageInstance(InteractionsPage.class);
            case ALERTS_FRAME_WINDOWS:
                return pageManager.getPageInstance(AlertsFrameWindowPage.class);
            default:
                throw new IllegalArgumentException(
                        String.format("Please use exist pages %s", Arrays.asList(HomePage.HomeNavigationMenu.values())));
        }
    }
}
