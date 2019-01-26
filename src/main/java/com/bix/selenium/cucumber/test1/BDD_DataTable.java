package com.bix.selenium.cucumber.test1;

import org.junit.Assert;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDD_DataTable extends InitChromeDriver{
	FacebookLoginPage facebookLoginPage;
	

	/*@Given("^User is on Home Page$")
	public void _user_is_on_Home_Page(int arg1) throws Throwable {
		
	}

	@When("^User Navigate to LogIn Page$")
	public void _user_Navigate_to_LogIn_Page(int arg1) throws Throwable {
		facebookLoginPage = new FacebookLoginPage(driver);
	}

	@Then("^User should be able to enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void _user_should_be_able_to_enter_and(String arg2, String arg3) throws Throwable {
	    facebookLoginPage.enterUsername(arg2);
	    facebookLoginPage.enterPassword(arg3);
	}*/
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		init();
		driver.get(TestConstants.URL);
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		facebookLoginPage = new FacebookLoginPage(driver);
	}

	@Then("^User should be able to enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_be_able_to_enter_and(String arg1, String arg2) throws Throwable {
		facebookLoginPage.enterUsername(arg1);
	    facebookLoginPage.enterPassword(arg2);
	}



}
