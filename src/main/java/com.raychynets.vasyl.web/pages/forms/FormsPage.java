package com.raychynets.vasyl.web.pages.forms;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.pages.BaseModulePage;
import org.openqa.selenium.WebDriver;

public class FormsPage extends BaseModulePage {

    @Inject
    public FormsPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Forms";
    }

}
