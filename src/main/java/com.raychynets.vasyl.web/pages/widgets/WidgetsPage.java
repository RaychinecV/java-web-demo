package com.raychynets.vasyl.web.pages.widgets;

import com.raychynets.vasyl.web.pages.BaseModulePage;
import org.openqa.selenium.WebDriver;

public class WidgetsPage extends BaseModulePage {

    public WidgetsPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Widgets";
    }

}
