package com.bix.selenium.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, features = "resources/feature4",
glue = { "com.bix.selenium.cucumber.hooks_test3" },
format= {"html:resources"}, tags= {"@E2E","@Regression"} ) 
//format={html:path_to_report}
public class TestRunner {

}