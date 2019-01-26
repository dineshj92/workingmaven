package com.bix.selenium.cucumber.hooks_test3;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks1 {

	@Before("@Regression")
	public void beforeScenario() {
		System.out.println("This will run before the Scenario");
	}

	@After("@Regression")
	public void afterScenario() {
		System.out.println("This will run after the Scenario");
	}
}
