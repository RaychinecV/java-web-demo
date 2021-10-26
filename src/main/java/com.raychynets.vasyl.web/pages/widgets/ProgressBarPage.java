package com.raychynets.vasyl.web.pages.widgets;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.pages.BaseModulePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgressBarPage extends BaseModulePage {

    private final PageElement progressBar = new PageElement(el -> {
        el.setName("Progress bar");
        el.setLocator(By.id("progressBar"));
        el.setHasScroll(true);
    });
    private final PageElement progressBarScale = new PageElement(el -> {
        el.setName("Progress bar");
        el.setLocator(By.cssSelector("#progressBar>[role='progressbar']"));
        el.setHasScroll(true);
    });
    private final PageElement btnStart = new PageElement(el -> {
        el.setName("Start button");
        el.setLocator(By.xpath("//button[text()='Start']"));
        el.setHasScroll(false);
    });
    private final PageElement btnStop = new PageElement(el -> {
        el.setName("Stop button");
        el.setLocator(By.xpath("//button[text()='Stop']"));
        el.setHasScroll(false);
    });
    private final PageElement btnReset = new PageElement(el -> {
        el.setName("Reset button");
        el.setLocator(By.xpath("//button[text()='Reset']"));
        el.setHasScroll(false);
    });


    public ProgressBarPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Progress Bar";
    }

    @Step
    @Override
    public <T extends BaseModulePage> T waitForPageLoad() {
        super.waitForPageLoad();
        wait.waitToBeVisible(progressBar);
        wait.waitToBeVisible(btnStart);
        return (T) this;
    }

    @Step
    public ProgressBarPage clickOnBtnStart() {
        wait.waitToBeClickable(btnStart);
        action.click(btnStart);
        return this;
    }

    @Step
    public ProgressBarPage clickOnBtnStop() {
        wait.waitToBeClickable(btnStop);
        action.click(btnStop);
        return this;
    }

    @Step
    public ProgressBarPage clickOnBtnReset() {
        wait.waitToBeClickable(btnReset);
        action.click(btnReset);
        return this;
    }

    @Step
    public ProgressBarPage stopProgressBarAtTheMark(int mark) {
        this.waitUntilProgressBarWillBeAtTheMark(mark);
        this.clickOnBtnStop();
        return this;
    }

    @Step
    public ProgressBarPage validateThatProgressBarAtMark(int expectedMark) {

        int actualMark = Integer.parseInt(action.getText(progressBar).replaceAll("%", "").trim());
        assertThat(actualMark)
                .as("Expected load progress and actual should be same!!!")
                .isBetween(expectedMark, expectedMark + 1);
        return this;
    }

    @Step
    public ProgressBarPage waitUntilProgressBarWillBeAtTheMark(int mark) {
        if (mark <= 0 || mark > 100) {
            throw new IllegalArgumentException("Mark can't be 0 or more than 100 !!!");
        }
        wait.waitForAttributeValue(progressBarScale, "aria-valuenow", String.valueOf(mark));
        return this;
    }
}
