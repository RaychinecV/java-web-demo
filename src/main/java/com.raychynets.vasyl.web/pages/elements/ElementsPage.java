package com.raychynets.vasyl.web.pages.elements;

import com.raychynets.vasyl.web.pages.BaseModulePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Getter
@Log4j2
public class ElementsPage extends BaseModulePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Elements";
    }
}
