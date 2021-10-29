package com.raychynets.vasyl.web.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "com.raychynets.vasyl.web.listener.CucumberListener",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        features = {"src/main/java/com.raychynets.vasyl.web/features"},
        glue = {"com.raychynets.vasyl.web.steps"},
        tags = "@homepage",
        monochrome = true
)
public class HomePageTestRunner extends AbstractTestNGCucumberTests {

}