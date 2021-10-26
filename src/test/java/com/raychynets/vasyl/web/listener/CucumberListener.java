package com.raychynets.vasyl.web.listener;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.cucumber.plugin.event.Status.FAILED;
import static io.cucumber.plugin.event.Status.PASSED;

@Log4j2
public class CucumberListener implements ConcurrentEventListener {

    public void onTestCaseStarted(TestCaseStarted testCaseStarted) {
        log.info("TEST CASE STARTED: " + testCaseStarted.getTestCase().getName());
    }

    public void onTestCaseFinished(TestCaseFinished testCaseSuccess) {
        if (testCaseSuccess.getResult().getStatus() == PASSED) {
            log.info("TEST CASE FINISHED SUCCESS: " + testCaseSuccess.getTestCase().getName());
        }
    }

    public void onTestCaseFailed(TestCaseFinished testCaseFailed) {
        if (testCaseFailed.getResult().getStatus() == FAILED) {
            log.error("TEST CASE FAILED : " + testCaseFailed.getTestCase().getName());
        }
    }

    public void onTestRunStarted(TestRunStarted testRunStarted) {
        log.info("TEST RUN STARTED AT: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }


    public void onTestRunFinished(TestRunFinished testRunFinished) {
        log.info("TEST RUN FINISHED AT: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFailed);
    }
}
