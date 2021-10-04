package com.raychynets.vasyl.web.tests.elements;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.constants.elements.WebTablesUserFields;
import com.raychynets.vasyl.web.models.elements.WebTablesUser;
import com.raychynets.vasyl.web.models.elements.WebTablesUserFactory;
import com.raychynets.vasyl.web.pages.HomePage;
import com.raychynets.vasyl.web.pages.elements.ElementsPage;
import com.raychynets.vasyl.web.pages.elements.WebTablesPage;
import com.raychynets.vasyl.web.retry_analyzer.RetryAnalyzer;
import com.raychynets.vasyl.web.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.raychynets.vasyl.web.pages.HomePage.HomeNavigationMenu.ELEMENTS;
import static com.raychynets.vasyl.web.pages.navigation_menu.ElementsMenu.ElementsNavigationMenu.WEB_TABLES;

public class WebTablesTests extends BaseTest {

    @Inject
    private HomePage homePage;
    @Inject
    private ElementsPage elementsPage;
    @Inject
    private WebTablesPage webTablesPage;

    @BeforeMethod
    public void openSite() {
        super.openSite();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addUserTest() {

        final WebTablesUser user = new WebTablesUserFactory().create();

        homePage
                .waitForPageLoad()
                .hideCommercialBanner();
        homePage.navigateTo(ELEMENTS);

        elementsPage
                .waitForPageLoad()
                .navigationMenu
                .elementsMenu
                .select(WEB_TABLES);

        webTablesPage
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
        webTablesPage
                .clickOnBtnAddUser()
                .addUser(user);
        webTablesPage
                .validateThatUserPresentInTheUsersList(user)
                .deleteUser(user);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void updateUserTest() {

        final WebTablesUser user = new WebTablesUserFactory().create();
        final WebTablesUser updateUser = new WebTablesUserFactory().create();

        homePage
                .waitForPageLoad()
                .hideCommercialBanner();
        homePage.navigateTo(ELEMENTS);

        elementsPage
                .waitForPageLoad()
                .navigationMenu
                .elementsMenu
                .select(WEB_TABLES);

        webTablesPage
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
        webTablesPage
                .clickOnBtnAddUser()
                .addUser(user);
        webTablesPage
                .validateThatUserPresentInTheUsersList(user)
                .clickOnBtnUpdateUser(user)
                .updateUser(updateUser);
        webTablesPage
                .validateThatUserPresentInTheUsersList(updateUser)
                .deleteUser(updateUser);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void deleteUserTest() {

        final WebTablesUser user = new WebTablesUserFactory().create();

        homePage
                .waitForPageLoad()
                .hideCommercialBanner();
        homePage.navigateTo(ELEMENTS);

        elementsPage
                .waitForPageLoad()
                .navigationMenu
                .elementsMenu
                .select(WEB_TABLES);

        webTablesPage
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
        webTablesPage
                .clickOnBtnAddUser()
                .addUser(user);
        webTablesPage
                .validateThatUserPresentInTheUsersList(user)
                .deleteUser(user);
        webTablesPage.validateThatUserNotPresentInTheUsersList(user);
    }

    @DataProvider
    public Object[][] fields() {
        return new Object[][]{
                {WebTablesUserFields.FIRST_NAME},
                {WebTablesUserFields.LAST_NAME},
                {WebTablesUserFields.EMAIL},
                {WebTablesUserFields.AGE},
                {WebTablesUserFields.SALARY},
                {WebTablesUserFields.DEPARTMENT}
        };
    }

    @Test(dataProvider = "fields", retryAnalyzer = RetryAnalyzer.class)
    public void searchUserTest(WebTablesUserFields field) {

        final WebTablesUser user = new WebTablesUserFactory().create();

        homePage
                .waitForPageLoad()
                .hideCommercialBanner();
        homePage.navigateTo(ELEMENTS);

        elementsPage
                .waitForPageLoad()
                .navigationMenu
                .elementsMenu
                .select(WEB_TABLES);

        webTablesPage
                .waitForPageLoad()
                .validateThatActualTitleAndExpectedAreSame();
        webTablesPage
                .clickOnBtnAddUser()
                .addUser(user);
        webTablesPage
                .searchUserBy(user, field)
                .validateThatUserPresentInTheUsersList(user)
                .deleteUser(user);
    }
}
