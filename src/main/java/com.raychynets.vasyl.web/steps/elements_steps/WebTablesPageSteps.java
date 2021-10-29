package com.raychynets.vasyl.web.steps.elements_steps;

import com.raychynets.vasyl.web.models.elements.WebTablesUser;
import com.raychynets.vasyl.web.models.elements.WebTablesUserFactory;
import com.raychynets.vasyl.web.pages.PageManager;
import com.raychynets.vasyl.web.pages.elements.WebTablesPage;
import com.raychynets.vasyl.web.pages.elements.WebTablesRegistrationPopup;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTablesPageSteps {

    private PageManager pageManager;
    private WebTablesPage webTablesPage;
    private WebTablesRegistrationPopup webTablesRegistrationPopup;

    private WebTablesUser validUser = new WebTablesUserFactory().create();

    public WebTablesPageSteps(PageManager pageManager) {
        this.pageManager = pageManager;
        this.webTablesPage = pageManager.getPageInstance(WebTablesPage.class);
        this.webTablesRegistrationPopup = pageManager.getPageInstance(WebTablesRegistrationPopup.class);
    }

    @DataTableType
    public WebTablesUser mapDataTableToWebTablesUser(Map<String, String> entry) {
        return WebTablesUser.builder()
                .withFirstName(entry.get("firstName"))
                .withLastName(entry.get("lastName"))
                .withEmail(entry.get("email"))
                .withAge(Integer.parseInt(entry.get("age")))
                .withSalary(Integer.parseInt(entry.get("salary")))
                .withDepartment(entry.get("department"))
                .build();
    }

    @When("click on the add user button")
    public void clickOnTheAddUserButton() {
        webTablesPage.clickOnBtnAddUser();
    }

    @When("web tables registration popup is displayed")
    public void webTablesRegistrationPopupIsDisplayed() {
        webTablesRegistrationPopup.waitForPageLoad();
    }

    @When("fill in web table user fields")
    public void fillInWebTableUserFields(final WebTablesUser user) {
        webTablesRegistrationPopup.fillInAllUserFields(user);
    }

    @When("click on the submit button in the web table page")
    public void clickOnTheSubmitButtonInTheWebTablePage() {
        webTablesRegistrationPopup.clickBtnSubmit();
    }

    @Then("validate that user is present in the users list")
    public void validateThatUserIsPresentInTheUsersListWebTablesUser(final WebTablesUser user) {
        webTablesPage.validateThatUserPresentInTheUsersList(user);
    }

    @When("delete user")
    public void deleteUser(final WebTablesUser user) {
        webTablesPage.deleteUser(user);
    }

    @Then("validate that user is not present in the users list")
    public void validateThatUserNotPresentInTheUsersList(final WebTablesUser user) {
        webTablesPage.validateThatUserNotPresentInTheUsersList(user);
    }

    @When("^search user by field (FIRST_NAME|LAST_NAME|EMAIL|AGE|SALARY|DEPARTMENT)$")
    public void searchUserByField(final WebTablesPage.WebTablesUserFields field, final WebTablesUser user) {
        webTablesPage.searchUserBy(user, field);
    }

    @And("click on the update user button")
    public void clickOnTheUpdateUserButton(final WebTablesUser user) {
        webTablesPage.clickOnBtnUpdateUser(user);
    }
}
