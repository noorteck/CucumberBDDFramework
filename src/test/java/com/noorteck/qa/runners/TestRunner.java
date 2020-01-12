package com.noorteck.qa.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/Campaings.feature", glue = "com.noorteck.qa.steps", plugin = {
		"pretty", "html:target/cucumberReport", "json:target/cucumber.json",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html" }, monochrome = true, tags = {
				"@SmokeTest" })

public class TestRunner {

}
