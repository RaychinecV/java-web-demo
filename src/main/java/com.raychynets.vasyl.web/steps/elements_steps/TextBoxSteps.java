package com.raychynets.vasyl.web.steps.elements_steps;

import com.raychynets.vasyl.web.models.elements.TextBoxUser;
import com.raychynets.vasyl.web.pages.PageManager;
import com.raychynets.vasyl.web.pages.elements.TextBoxPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class TextBoxSteps {

    private TextBoxPage textBoxPage;
    private PageManager pageManager;

    public TextBoxSteps(PageManager pageManager) {
        this.pageManager = pageManager;
        textBoxPage = pageManager.getTextBoxPage();
    }

    @DataTableType
    public TextBoxUser mapDataTableToTextBoxUser(Map<String, String> entry) {
        return TextBoxUser.builder()
                .withFullName(entry.get("fullName"))
                .withEmail(entry.get("email"))
                .withCurrentAddress(entry.get("currentAddress"))
                .withPermanentAddress(entry.get("permanentAddress"))
                .build();
    }

    @When("^fill in user fields$")
    public void fillInUserFields(TextBoxUser user) {
        textBoxPage.enterAllFields(user);
    }

    @When("click on the submit button")
    public void clickOnTheSubmitButton() {
        textBoxPage.clickBtnSubmit();
    }

    @Then("validate that user is created")
    public void validateThatUserIsCreated(TextBoxUser user) {
        textBoxPage.validateThatActualAndExpectedUserDataSame(user);
    }
}
