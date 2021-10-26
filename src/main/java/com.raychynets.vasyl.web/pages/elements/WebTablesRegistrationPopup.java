package com.raychynets.vasyl.web.pages.elements;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.models.elements.WebTablesUser;
import com.raychynets.vasyl.web.pages.BaseWebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WebTablesRegistrationPopup extends BaseWebPage {

    private final PageElement actualLabel = new PageElement(el -> {
        el.setName("Label Registration Form");
        el.setLocator(By.id("registration-form-modal"));
        el.setHasScroll(false);
    });
    private final PageElement fldFirstName = new PageElement(el -> {
        el.setName("First Name");
        el.setLocator(By.id("firstName"));
        el.setHasScroll(false);
    });
    private final PageElement fldLastName = new PageElement(el -> {
        el.setName("Last Name");
        el.setLocator(By.id("lastName"));
        el.setHasScroll(false);
    });
    private final PageElement fldEmail = new PageElement(el -> {
        el.setName("Email");
        el.setLocator(By.id("userEmail"));
        el.setHasScroll(false);
    });
    private final PageElement fldAge = new PageElement(el -> {
        el.setName("Age");
        el.setLocator(By.id("age"));
        el.setHasScroll(false);
    });
    private final PageElement fldSalary = new PageElement(el -> {
        el.setName("Salary");
        el.setLocator(By.id("salary"));
        el.setHasScroll(false);
    });
    private final PageElement fldDepartment = new PageElement(el -> {
        el.setName("Department");
        el.setLocator(By.id("department"));
        el.setHasScroll(false);
    });

    private final PageElement btnSubmit = new PageElement(el -> {
        el.setName("Submit");
        el.setLocator(By.id("submit"));
        el.setHasScroll(false);
    });


    private String expectedLabel = "Registration Form";

    public WebTablesRegistrationPopup(WebDriver driver) {
        super(driver);
    }

    @Step
    public void updateUser(WebTablesUser updateUser) {
        this.fillInAllUserFields(updateUser);
    }

    @Step
    public void fillInAllUserFields(final WebTablesUser user) {
        Objects.requireNonNull(user);

        this
                .waitForPageLoad()
                .enterFirstName(user)
                .enterLastName(user)
                .enterEmail(user)
                .enterAge(user)
                .enterSalary(user)
                .enterDepartment(user);
    }

    @Step
    public void clickBtnSubmit() {
        wait.waitToBeClickable(btnSubmit);
        action.click(btnSubmit);
    }

    @Step
    public WebTablesRegistrationPopup enterFirstName(final WebTablesUser user) {
        if (user.getFirstName() != null) this.enterFirstName(user.getFirstName());
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterLastName(WebTablesUser user) {
        if (user.getFirstName() != null) this.enterLastName(user.getLastName());
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterEmail(WebTablesUser user) {
        if (user.getFirstName() != null) this.enterEmail(user.getEmail());
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterAge(WebTablesUser user) {
        if (user.getFirstName() != null) this.enterAge(user.getAge());
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterSalary(WebTablesUser user) {
        if (user.getFirstName() != null) this.enterSalary(user.getSalary());
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterDepartment(WebTablesUser user) {
        if (user.getFirstName() != null) this.enterDepartment(user.getDepartment());
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterFirstName(final String firstName) {
        wait.waitToBeVisible(fldFirstName);
        action.enterText(fldFirstName, firstName, true);
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterLastName(final String lastName) {
        wait.waitToBeVisible(fldLastName);
        action.enterText(fldLastName, lastName, true);
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterEmail(final String email) {
        wait.waitToBeVisible(fldEmail);
        action.enterText(fldEmail, email, true);
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterAge(final int age) {
        wait.waitToBeVisible(fldAge);
        action.enterText(fldAge, String.valueOf(age), true);
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterSalary(final int salary) {
        wait.waitToBeVisible(fldSalary);
        action.enterText(fldSalary, String.valueOf(salary), true);
        return this;
    }

    @Step
    public WebTablesRegistrationPopup enterDepartment(final String department) {
        wait.waitToBeVisible(fldDepartment);
        action.enterText(fldDepartment, department, true);
        return this;
    }

    @Step
    public WebTablesRegistrationPopup waitForPageLoad() {
        wait.waitToBeVisible(actualLabel);
        wait.waitForTextEqual(actualLabel, expectedLabel);
        return this;
    }
}
