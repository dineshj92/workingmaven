package com.bix.selenium.cucumber.test2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HashMap_Parameter extends InitChromeDriver{
	
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
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String, String>> dataMap = arg1.asMaps(String.class, String.class);
		for (Map<String, String> dataRow : dataMap) {
			facebookLoginPage.enterUsername(dataRow.get("Username"));
		}
	}

	@Then("^able to enter password$")
	public void able_to_enter_password(DataTable arg1) throws Throwable {
		List<Map<String, String>> dataMap = arg1.asMaps(String.class, String.class);
		for (Map<String, String> dataRow : dataMap) {
			facebookLoginPage.enterPassword(dataRow.get("Password"));
		}
	}

}
