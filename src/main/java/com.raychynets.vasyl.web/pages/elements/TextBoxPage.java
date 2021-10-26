package com.raychynets.vasyl.web.pages.elements;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.models.elements.TextBoxUser;
import com.raychynets.vasyl.web.pages.BaseModulePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class TextBoxPage extends BaseModulePage {

    private final PageElement fldFullName = new PageElement(el -> {
        el.setName("Input field Full Name");
        el.setLocator(By.cssSelector("#userName-wrapper #userName"));
        el.setHasScroll(false);
    });
    private final PageElement fldEmail = new PageElement(el -> {
        el.setName("Input field Email");
        el.setLocator(By.cssSelector("#userEmail-wrapper #userEmail"));
        el.setHasScroll(false);
    });
    private final PageElement fldCurrentAddress = new PageElement(el -> {
        el.setName("Input field Current Address");
        el.setLocator(By.cssSelector("#currentAddress-wrapper #currentAddress"));
        el.setHasScroll(false);
    });
    private final PageElement fldPermanentAddress = new PageElement(el -> {
        el.setName("Input field Permanent Address");
        el.setLocator(By.cssSelector("#permanentAddress-wrapper #permanentAddress"));
        el.setHasScroll(false);
    });
    private final PageElement btnSubmit = new PageElement(el -> {
        el.setName("Button Submit");
        el.setLocator(By.id("submit"));
        el.setHasScroll(true);
    });
    private final PageElement outputLabelName = new PageElement(el -> {
        el.setName("Output label Name");
        el.setLocator(By.cssSelector("#output #name"));
        el.setHasScroll(false);
    });
    private final PageElement outputLabelEmail = new PageElement(el -> {
        el.setName("Output label Email");
        el.setLocator(By.cssSelector("#output #email"));
        el.setHasScroll(false);
    });
    private final PageElement outputLabelCurrentAddress = new PageElement(el -> {
        el.setName("Output label Current Address");
        el.setLocator(By.cssSelector("#output #currentAddress"));
        el.setHasScroll(false);
    });
    private final PageElement outputLabelPermanentAddress = new PageElement(el -> {
        el.setName("Output label Permanent Address");
        el.setLocator(By.cssSelector("#output #permanentAddress"));
        el.setHasScroll(false);
    });

    public TextBoxPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Text Box";
    }

    @Step
    public TextBoxPage enterAllFields(final TextBoxUser user) {
        if (user != null) {
            this
                    .enterFullName(user)
                    .enterEmail(user)
                    .enterCurrentAddress(user)
                    .enterPermanentAddress(user);
        } else {
            throw new IllegalArgumentException("Input argument can't be null!!!");
        }
        return this;
    }

    @Step
    public TextBoxPage enterFullName(final TextBoxUser user) {
        if (user.getFullName() != null) this.enterFullName(user.getFullName());
        return this;
    }

    @Step
    public TextBoxPage enterEmail(final TextBoxUser user) {
        if (user.getEmail() != null) this.enterEmail(user.getEmail());
        return this;
    }

    @Step
    public TextBoxPage enterCurrentAddress(final TextBoxUser user) {
        if (user.getCurrentAddress() != null) this.enterCurrentAddress(user.getCurrentAddress());
        return this;
    }

    @Step
    public TextBoxPage enterPermanentAddress(final TextBoxUser user) {
        if (user.getPermanentAddress() != null) this.enterPermanentAddress(user.getPermanentAddress());
        return this;
    }

    @Step
    public TextBoxPage enterFullName(final String fullName) {
        wait.waitToBeVisible(fldFullName);
        action.enterText(fldFullName, fullName);
        return this;
    }

    @Step
    public TextBoxPage enterEmail(final String email) {
        wait.waitToBeVisible(fldEmail);
        action.enterText(fldEmail, email);
        return this;
    }

    @Step
    public TextBoxPage enterCurrentAddress(final String currentAddress) {
        wait.waitToBeVisible(fldCurrentAddress);
        action.enterText(fldCurrentAddress, currentAddress);
        return this;
    }

    @Step
    public TextBoxPage enterPermanentAddress(final String PermanentAddress) {
        wait.waitToBeVisible(fldPermanentAddress);
        action.enterText(fldPermanentAddress, PermanentAddress);
        return this;
    }

    @Step
    public TextBoxPage validateThatActualAndExpectedUserDataSame(final TextBoxUser user) {
        log.info("Input user {}", user);
        if (user.getFullName() != null) {
            assertThat(this.getOutputName()).isEqualTo(user.getFullName());
        }
        if (user.getEmail() != null) {
            assertThat(this.getOutputEmail()).isEqualTo(user.getEmail());
        }
        if (user.getCurrentAddress() != null) {
            assertThat(this.getOutputCurrentAddress()).isEqualTo(user.getCurrentAddress());
        }
        if (user.getPermanentAddress() != null) {
            assertThat(this.getOutputPermanentAddress()).isEqualTo(user.getPermanentAddress());
        }
        return this;
    }

    @Step
    public String getOutputName() {
        String outputName = action.getText(outputLabelName);
        return this.cutAndGetOutputLabel(outputName);
    }

    @Step
    public String getOutputEmail() {
        String outputName = action.getText(outputLabelEmail);
        return this.cutAndGetOutputLabel(outputName);
    }

    @Step
    public String getOutputCurrentAddress() {
        String outputName = action.getText(outputLabelCurrentAddress);
        return this.cutAndGetOutputLabel(outputName);
    }

    @Step
    public String getOutputPermanentAddress() {
        String outputName = action.getText(outputLabelPermanentAddress);
        return this.cutAndGetOutputLabel(outputName);
    }

    private String cutAndGetOutputLabel(final String textForCut) {
        Pattern pattern = Pattern.compile(":(.+)");
        Matcher matcher = pattern.matcher(textForCut);
        String cutText = null;
        if (matcher.find()) {
            cutText = matcher.group(1);
        }
        log.info("Text <{}> after cutting is <{}>.", textForCut, cutText);
        return Objects.requireNonNull(cutText);
    }

    @Step
    public TextBoxPage clickBtnSubmit() {
        wait.waitToBeClickable(btnSubmit);
        action.click(btnSubmit);
        return this;
    }
}
