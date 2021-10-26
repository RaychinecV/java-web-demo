package com.raychynets.vasyl.web.pages.interactions;

import com.raychynets.vasyl.web.pages.BaseModulePage;
import org.openqa.selenium.WebDriver;

public class InteractionsPage extends BaseModulePage {

    public InteractionsPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Interactions";
    }

}
