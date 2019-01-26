package com.bix.selenium.cucumber.test;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SignupTestUsingBDD_examplekeyword extends InitChromeDriver{
	
	FacebookLoginPage facebookLoginPage;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		init();
		driver.get(TestConstants.URL);
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		facebookLoginPage = new FacebookLoginPage(driver);
	}

	@Then("^User should be able \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_be_able_and(String arg1, String arg2) throws Throwable {
		facebookLoginPage.enterUsername(arg1);
		facebookLoginPage.enterPassword(arg2);
	}

}
