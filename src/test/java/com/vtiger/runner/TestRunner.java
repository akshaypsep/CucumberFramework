package com.vtiger.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "com.vtiger.stepdefinitions",
        dryRun = false,
        tags = "@lead",
        plugin = {
                "pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber-report.json",
                "junit:target/cucumber.xml"
        },
        monochrome = true



)
public class TestRunner {
}
