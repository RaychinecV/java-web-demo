package com.raychynets.vasyl.web.steps;

import com.raychynets.vasyl.web.driver.DriverManager;
import com.raychynets.vasyl.web.utils.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Hooks {

    private DriverManager driverManager;

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Step
    @Before
    public void setUp() {
        driverManager.setUp();
    }

    @Step
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                Screenshot.attachScreenshot();
            }
        } finally {
            driverManager.tearDown();
        }
    }
}
