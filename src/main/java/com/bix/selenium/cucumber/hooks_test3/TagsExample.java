package com.bix.selenium.cucumber.hooks_test3;

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
import junit.framework.Assert;

public class TagsExample extends InitChromeDriver{
	
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
	
	@Then("^URL should be$")
	public void url_should_be(DataTable arg1) throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), arg1.raw().get(0).get(0).toString());
	}
	
	@Then("^Welcome Text should be$")
	public void Welcome_Text_should_be(DataTable arg1) throws Throwable {
		Assert.assertEquals(facebookLoginPage.getWelcomeText(), arg1.raw().get(0).get(0).toString());
	}
	


}
