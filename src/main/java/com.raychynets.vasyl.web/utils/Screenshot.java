package com.raychynets.vasyl.web.utils;

import com.raychynets.vasyl.web.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        byte[] screenshotAs = null;
        try {
            screenshotAs = ((TakesScreenshot) new DriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenshotAs;
    }
}
