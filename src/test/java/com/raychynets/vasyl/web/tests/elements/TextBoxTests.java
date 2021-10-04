package com.raychynets.vasyl.web.tests.elements;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.pages.HomePage;
import com.raychynets.vasyl.web.pages.elements.ElementsPage;
import com.raychynets.vasyl.web.pages.elements.TextBoxPage;
import com.raychynets.vasyl.web.retry_analyzer.RetryAnalyzer;
import com.raychynets.vasyl.web.tests.BaseTest;
import com.raychynets.vasyl.web.models.elements.TextBoxUser;
import com.raychynets.vasyl.web.models.elements.TextBoxUserFactory;
import org.testng.annotations.Test;

import static com.raychynets.vasyl.web.pages.HomePage.HomeNavigationMenu.ELEMENTS;
import static com.raychynets.vasyl.web.pages.navigation_menu.ElementsMenu.ElementsNavigationMenu.TEXT_BOX;

public class TextBoxTests extends BaseTest {

    @Inject
    private HomePage homePage;
    @Inject
    private ElementsPage elementsPage;
    @Inject
    private TextBoxPage textBoxPage;

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validateTextBoxFields() {

        final TextBoxUser user = new TextBoxUserFactory().create();

        super.openSite();

        homePage
                .waitForPageLoad()
                .hideCommercialBanner();
        homePage.navigateTo(ELEMENTS);

        elementsPage.waitForPageLoad();
        elementsPage
                .navigationMenu
                .elementsMenu
                .select(TEXT_BOX);
        textBoxPage.waitForPageLoad();
        textBoxPage.validateThatActualTitleAndExpectedAreSame();
        textBoxPage
                .enterAllFields(user)
                .clickBtnSubmit()
                .validateThatActualAndExpectedUserDataSame(user);
    }
}
