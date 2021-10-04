package com.raychynets.vasyl.web.pages.interactions;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.pages.BaseModulePage;
import org.openqa.selenium.WebDriver;

public class InteractionsPage extends BaseModulePage {

    @Inject
    public InteractionsPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Interactions";
    }

}
