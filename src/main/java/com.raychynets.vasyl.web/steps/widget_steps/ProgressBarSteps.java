package com.raychynets.vasyl.web.steps.widget_steps;

import com.raychynets.vasyl.web.pages.PageManager;
import com.raychynets.vasyl.web.pages.widgets.ProgressBarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressBarSteps {

    private ProgressBarPage progressBarPage;
    private PageManager pageManager;

    public ProgressBarSteps(PageManager pageManager) {
        this.pageManager = pageManager;
        this.progressBarPage = pageManager.getProgressBarPage();
    }

    @When("^progress bar page is displayed$")
    public void progressBarPageIsDisplayed() {
        progressBarPage.waitForPageLoad();
    }

    @When("^click on the start button$")
    public void clickOnTheStartButton() {
        progressBarPage.clickOnBtnStart();
    }

    @When("^click on stop button at the mark \"(\\d+)\"$")
    public void clickOnStopButtonAtTheMark(int mark) {
        progressBarPage.stopProgressBarAtTheMark(mark);
    }

    @Then("^validate that progress bar at the mark \"(\\d+)\"$")
    public void validateThatProgressBarAtMark(int mark) {
        progressBarPage.validateThatProgressBarAtMark(mark);
    }

    @And("wait until load bar will be at the mark \"(\\d+)\"$")
    public void waitUntilProgressBarWillBeAtTheMark(int mark) {
        progressBarPage.waitUntilProgressBarWillBeAtTheMark(mark);
    }

    @And("^click on the reset button$")
    public void clickOnTheResetButton() {
        progressBarPage.clickOnBtnReset();
    }
}
