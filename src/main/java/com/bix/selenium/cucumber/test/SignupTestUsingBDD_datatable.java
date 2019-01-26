package com.bix.selenium.cucumber.test;

import java.util.List;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SignupTestUsingBDD_datatable extends InitChromeDriver{
	
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
	
	@Then("^User should be able to enter username$")
	public void user_should_be_able_to_enter_username(DataTable arg1) throws Throwable {
		//Lis<String>
		List<List<String>> data = arg1.raw();
		facebookLoginPage.enterUsername(data.get(0).get(0));
	}

	@Then("^able to enter password$")
	public void able_to_enter_password(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		facebookLoginPage.enterUsername(data.get(0).get(0));
	}


}
