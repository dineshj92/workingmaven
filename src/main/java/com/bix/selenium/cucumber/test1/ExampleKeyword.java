package com.bix.selenium.cucumber.test1;

import java.util.List;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExampleKeyword extends InitChromeDriver{
	
	FacebookLoginPage facebookLoginPage;
	
	@Given("^User is on Home Page_usingDT$")
	public void user_is_on_Home_Page_usingDT() throws Throwable {
		init();
		driver.get(TestConstants.URL);
	}

	@When("^User Navigate to LogIn Page_usingDT$")
	public void user_Navigate_to_LogIn_Page_usingDT() throws Throwable {
		facebookLoginPage = new FacebookLoginPage(driver);
	}

	@Then("^User should be able to enter username_usingDT$")
	public void user_should_be_able_to_enter_username_usingDT(DataTable arg1) throws Throwable {
		//List<String> - represent a row in a test step
		//List<List<Strng>  - rep. list of rows under a test step
		List<List<String>> data = arg1.raw();
		for (List<String> dataRow : data) {
			facebookLoginPage.enterUsername(dataRow.get(0));
			driver.getCurrentUrl().contains(data.get(1).toString());
		}
	}

	@Then("^able to enter password_usingDT$")
	public void able_to_enter_password_usingDT(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		facebookLoginPage.enterPassword(data.get(0).get(0));
	}



}
