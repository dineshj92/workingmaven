package com.bix.selenium.cucumber.test;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SignupTestUsingBDD extends InitChromeDriver{
	
	FacebookLoginPage facebookLoginPage;
	
	@Given("^User is on Facebook sign-up page$")
	public void user_is_on_Facebook_sign_up_page() throws Throwable {
		init();
		driver.get(TestConstants.URL);
	}

	@When("^The page is loaded$")
	public void the_page_is_loaded() throws Throwable {
	    facebookLoginPage = new FacebookLoginPage(driver);
	}

	@Then("^'Create An Account' label should be visible$")
	public void create_An_Account_label_should_be_visible() throws Throwable {
		String actual = facebookLoginPage.getCreateAccountLabel();
		String expected = "Create an account";
		Assert.assertEquals(expected, actual);
	    
	}
	
	@Then("^create account label \"([^\"]*)\" and welcome label \"([^\"]*)\" should be visible$")
	public void create_account_label_and_welcome_label_should_be_visible(String arg1, String arg2) throws Throwable {
		String actualcreate = facebookLoginPage.getCreateAccountLabel();
		String actualwelcome = facebookLoginPage.getWelcomeText();
		Assert.assertEquals(arg1, actualcreate);
		Assert.assertEquals(arg2, actualwelcome);
	}

}
