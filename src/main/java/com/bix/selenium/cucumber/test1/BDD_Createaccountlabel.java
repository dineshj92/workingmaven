package com.bix.selenium.cucumber.test1;

import org.junit.Assert;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDD_Createaccountlabel extends InitChromeDriver{
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

	/*@Then("^Create account label should be visible$")
	public void create_account_label_should_be_visible() throws Throwable {
		String actual = facebookLoginPage.getCreateAccountLabel();
		String expected = "Create an account";
		Assert.assertEquals(expected, actual);
	}*/

	@Then("^\"([^\"]*)\" label should be visible$")
	public void label_should_be_visible(String expected) throws Throwable {
		String actual = facebookLoginPage.getCreateAccountLabel();
		Assert.assertEquals(expected, actual);
	}

}
