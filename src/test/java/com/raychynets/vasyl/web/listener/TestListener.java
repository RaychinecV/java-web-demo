package com.raychynets.vasyl.web.listener;

import com.raychynets.vasyl.web.driver.Driver;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

@Log4j2
public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("##### Case <{}> from class <{}> is STARTED #####\n",
                iTestResult.getMethod().getMethodName(), iTestResult.getTestClass().getRealClass().getSimpleName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("##### Case <{}> from class <{}> is SUCCESS #####\n",
                iTestResult.getMethod().getMethodName(), iTestResult.getTestClass().getRealClass().getSimpleName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("!!!!! Case <{}> from class <{}> is FAILED !!!!!\n",
                iTestResult.getMethod().getMethodName(), iTestResult.getTestClass().getRealClass().getSimpleName());
        attachScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        byte[] screenshotAs = null;
        try {
            screenshotAs = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenshotAs;
    }
}
