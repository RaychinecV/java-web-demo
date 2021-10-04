package com.raychynets.vasyl.web.tests.widgets;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.pages.HomePage;
import com.raychynets.vasyl.web.pages.widgets.ProgressBarPage;
import com.raychynets.vasyl.web.pages.widgets.WidgetsPage;
import com.raychynets.vasyl.web.retry_analyzer.RetryAnalyzer;
import com.raychynets.vasyl.web.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.raychynets.vasyl.web.pages.HomePage.HomeNavigationMenu.WIDGETS;
import static com.raychynets.vasyl.web.pages.navigation_menu.WidgetsMenu.WidgetsNavigationMenu.PROGRESS_BAR;

public class ProgressBarTests extends BaseTest {

    @Inject
    private HomePage homePage;
    @Inject
    private WidgetsPage widgetsPage;
    @Inject
    private ProgressBarPage progressBarPage;

    @BeforeMethod
    public void openSite() {
        super.openSite();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validateThatProgressBarStopAndContinueLoadTest() {

        final int stopMark = 20;
        final int endMark = 100;

        homePage
                .waitForPageLoad()
                .hideCommercialBanner();
        homePage.navigateTo(WIDGETS);

        widgetsPage
                .waitForPageLoad()
                .navigationMenu
                .widgetsMenu
                .select(PROGRESS_BAR);

        progressBarPage
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
        progressBarPage
                .clickOnBtnStart()
                .stopProgressBarAtTheMark(stopMark)
                .validateThatProgressBarAtMark(stopMark)
                .clickOnBtnStart()
                .waitThatProgressBarAtMark(endMark)
                .validateThatProgressBarAtMark(endMark);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validateResetProgressBarTest() {

        final int startMark = 0;
        final int endMark = 100;

        homePage
                .waitForPageLoad()
                .hideCommercialBanner();
        homePage.navigateTo(WIDGETS);

        widgetsPage
                .waitForPageLoad()
                .navigationMenu
                .widgetsMenu
                .select(PROGRESS_BAR);

        progressBarPage
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
        progressBarPage
                .clickOnBtnStart()
                .waitThatProgressBarAtMark(endMark)
                .validateThatProgressBarAtMark(endMark)
                .clickOnBtnReset()
                .validateThatProgressBarAtMark(startMark);
    }
}
