package com.raychynets.vasyl.web.pages.allerts_frame_window;

import com.google.inject.Inject;
import com.raychynets.vasyl.web.pages.BaseModulePage;
import org.openqa.selenium.WebDriver;

public class AlertsFrameWindowPage extends BaseModulePage {

    @Inject
    public AlertsFrameWindowPage(WebDriver driver) {
        super(driver);
        expectedTitle = "Alerts, Frame & Windows";
    }

}
