package com.raychynets.vasyl.web.retry_analyzer;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            log.info("!!!!! Retry #{} for case <{}> from class <{}> !!!!!\n",
                    retryCount, result.getMethod().getMethodName(), result.getTestClass().getRealClass().getSimpleName());
            return true;
        }
        return false;
    }
}