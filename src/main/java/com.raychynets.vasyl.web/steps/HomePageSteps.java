package com.raychynets.vasyl.web.steps;

import com.raychynets.vasyl.web.pages.BaseModulePage;
import com.raychynets.vasyl.web.pages.HomePage;
import com.raychynets.vasyl.web.pages.PageManager;
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
        homePage = pageManager.getHomePage();
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
                return pageManager.getElementsPage();
            case FORMS:
                return pageManager.getFormsPage();
            case BOOK_STORE_APPLICATION:
                return pageManager.getBookStoreApplicationPage();
            case WIDGETS:
                return pageManager.getWidgetsPage();
            case INTERACTIONS:
                return pageManager.getInteractionsPage();
            case ALERTS_FRAME_WINDOWS:
                return pageManager.getAlertsFrameWindowPage();
            default:
                throw new IllegalArgumentException(
                        String.format("Please use exist pages %s", Arrays.asList(HomePage.HomeNavigationMenu.values())));
        }
    }
}
