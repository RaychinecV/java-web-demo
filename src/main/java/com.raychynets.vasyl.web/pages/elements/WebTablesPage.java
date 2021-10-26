package com.raychynets.vasyl.web.pages.elements;

import com.raychynets.vasyl.web.models.PageElement;
import com.raychynets.vasyl.web.models.elements.WebTablesUser;
import com.raychynets.vasyl.web.pages.BaseModulePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


@Log4j2
public class WebTablesPage extends BaseModulePage {

    private final PageElement btnAdd = new PageElement(el -> {
        el.setName("Button Add");
        el.setLocator(By.id("addNewRecordButton"));
        el.setHasScroll(true);
    });
    private final PageElement fldSearch = new PageElement(el -> {
        el.setName("Field Search");
        el.setLocator(By.id("searchBox"));
        el.setHasScroll(false);
    });
    private final PageElement existUserRows = new PageElement(el -> {
        el.setName("Exist user rows");
        el.setLocator(By.cssSelector(".rt-tbody .rt-tr:not(.-padRow)"));
        el.setHasScroll(false);
    });


    public WebTablesPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Web Tables";
    }

    @Step
    public WebTablesRegistrationPopup clickOnBtnAddUser() {
        wait.waitToBeClickable(btnAdd);
        action.click(btnAdd);
        return new WebTablesRegistrationPopup(driver);
    }

    @Step
    public WebTablesPage searchUserBy(final WebTablesUser user, final WebTablesUserFields field) {
        wait.waitToBeVisible(fldSearch);
        action.enterText(fldSearch, this.getSearchedUserDataByField(user, field), true);
        return this;
    }

    @Step
    private String getSearchedUserDataByField(final WebTablesUser user, final WebTablesUserFields field) {
        switch (field) {
            case FIRST_NAME:
                return user.getFirstName();
            case LAST_NAME:
                return user.getLastName();
            case EMAIL:
                return user.getEmail();
            case AGE:
                return String.valueOf(user.getAge());
            case SALARY:
                return String.valueOf(user.getSalary());
            case DEPARTMENT:
                return user.getDepartment();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Step
    public WebTablesPage validateThatUserPresentInTheUsersList(final WebTablesUser searchedUser) {
        List<WebTablesUser> existUsers = getExistUsers();
        assertThat(existUsers)
                .as(String.format("User %s is not presented in the users list %s !!!", searchedUser.toString(), existUsers.toString()))
                .anyMatch(user -> user.equals(searchedUser));
        return this;
    }

    @Step
    public WebTablesPage validateThatUserNotPresentInTheUsersList(final WebTablesUser searchedUser) {
        List<WebTablesUser> existUsers = getExistUsers();
        assertThat(existUsers)
                .as(String.format("User %s is presented in the user list %s !!!", searchedUser.toString(), existUsers.toString()))
                .noneMatch(user -> user.equals(searchedUser));
        return this;
    }

    private List<WebTablesUser> getExistUsers() {

        List<WebTablesUser> users = new ArrayList<>();
        List<WebElement> rows = element.findAll(existUserRows);

        rows.forEach(row -> {
            WebTablesUser user = WebTablesUser.builder()
                    .withFirstName(row.findElement(By.xpath("./div[@class='rt-td'][1]")).getText())
                    .withLastName(row.findElement(By.xpath("./div[@class='rt-td'][2]")).getText())
                    .withAge(Integer.parseInt(row.findElement(By.xpath("./div[@class='rt-td'][3]")).getText()))
                    .withEmail(row.findElement(By.xpath("./div[@class='rt-td'][4]")).getText())
                    .withSalary(Integer.parseInt(row.findElement(By.xpath("./div[@class='rt-td'][5]")).getText()))
                    .withDepartment(row.findElement(By.xpath("./div[@class='rt-td'][6]")).getText())
                    .build();

            users.add(user);

            log.info("Added user <{}> to users collection.", user);

        });
        return users;
    }

    @Step
    public WebTablesRegistrationPopup clickOnBtnUpdateUser(final WebTablesUser searchedUser) {
        WebElement btnEditUser = this.getRowForUser(searchedUser);
        log.info("Clicking on the button <Update> for user <{}>.", searchedUser);
        btnEditUser.findElement(By.xpath(".//span[@title='Edit']")).click();
        return new WebTablesRegistrationPopup(driver);
    }

    @Step
    public WebTablesRegistrationPopup deleteUser(final WebTablesUser searchedUser) {
        WebElement btnEditUser = this.getRowForUser(searchedUser);
        log.info("Clicking on the button <Delete> for user <{}>.", searchedUser);
        btnEditUser.findElement(By.xpath(".//span[@title='Delete']")).click();
        return new WebTablesRegistrationPopup(driver);
    }

    @Step
    private WebElement getRowForUser(final WebTablesUser searchedUser) {
        List<WebElement> rows = element.findAll(existUserRows);
        WebElement searchedUserRow = rows.stream()
                .filter(row ->
                        row.findElement(By.xpath("./div[@class='rt-td'][1]")).getText().equals(searchedUser.getFirstName()) &&
                                row.findElement(By.xpath("./div[@class='rt-td'][2]")).getText().equals(searchedUser.getLastName()) &&
                                Integer.parseInt(row.findElement(By.xpath("./div[@class='rt-td'][3]")).getText()) == searchedUser.getAge() &&
                                row.findElement(By.xpath("./div[@class='rt-td'][4]")).getText().equals(searchedUser.getEmail()) &&
                                Integer.parseInt(row.findElement(By.xpath("./div[@class='rt-td'][5]")).getText()) == searchedUser.getSalary() &&
                                row.findElement(By.xpath("./div[@class='rt-td'][6]")).getText().equals(searchedUser.getDepartment()))
                .findFirst().get();

        return searchedUserRow;
    }

    public enum WebTablesUserFields {
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        AGE,
        SALARY,
        DEPARTMENT;
    }
}
