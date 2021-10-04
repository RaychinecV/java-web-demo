package com.raychynets.vasyl.web.tests;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.pages.BaseModulePage;
import com.raychynets.vasyl.web.pages.HomePage;
import com.raychynets.vasyl.web.pages.allerts_frame_window.AlertsFrameWindowPage;
import com.raychynets.vasyl.web.pages.book_store_application.BookStoreApplicationPage;
import com.raychynets.vasyl.web.pages.elements.ElementsPage;
import com.raychynets.vasyl.web.pages.forms.FormsPage;
import com.raychynets.vasyl.web.pages.interactions.InteractionsPage;
import com.raychynets.vasyl.web.pages.widgets.WidgetsPage;

import com.raychynets.vasyl.web.retry_analyzer.RetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.raychynets.vasyl.web.pages.HomePage.HomeNavigationMenu.*;

public class HomePageTests extends BaseTest {

    @Inject
    protected HomePage homePage;

    @BeforeMethod
    public void openSite() {
        super.openSite();
    }

    @DataProvider
    public Object[][] pages() {
        return new Object[][]{
                {ELEMENTS, ElementsPage.class},
                {FORMS, FormsPage.class},
                {ALERTS_FRAME_WINDOWS, AlertsFrameWindowPage.class},
                {WIDGETS, WidgetsPage.class},
                {INTERACTIONS, InteractionsPage.class},
                {BOOK_STORE_APPLICATION, BookStoreApplicationPage.class}
        };
    }

    @Test(dataProvider = "pages", retryAnalyzer = RetryAnalyzer.class)
    public void validateRedirectOnTheHomePageTest(HomePage.HomeNavigationMenu menu, Class<? extends BaseModulePage> classPage) {
        homePage
                .waitForPageLoad()
                .verifyThatMainElementsAreDisplayed()
                .hideCommercialBanner();
        homePage.navigateTo(menu);
        BaseModulePage pageInstance = getPageInstance(classPage);
        pageInstance
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
    }
}
