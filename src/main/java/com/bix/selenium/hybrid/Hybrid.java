package com.bix.selenium.hybrid;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.pom.FacebookLoginPage;

public enum Hybrid {
	//EnterFirstName	EnterLastname	EnterUsername	EnterLoginPassword	EnterSignupPassword	EnterMobileEmail

	
	EnterFirstName {
		@Override
		public void runHybrid(WebDriver driver, HashMap<String, String> map) {			
			FacebookLoginPage loginPage = new FacebookLoginPage(driver);
			loginPage.enterSignupFirstName(map.get("EnterFirstName"));
		}
	},
	EnterLastname {
		@Override
		public void runHybrid(WebDriver driver, HashMap<String, String> map) {
			FacebookLoginPage loginPage = new FacebookLoginPage(driver);
			loginPage.enterSignupLastName(map.get("EnterLastname"));
		}
	},
	EnterUsername {
		@Override
		public void runHybrid(WebDriver driver, HashMap<String, String> map) {
			FacebookLoginPage loginPage = new FacebookLoginPage(driver);
			loginPage.enterUsername(map.get("EnterUsername"));
		}
	},
	EnterLoginPassword {

		@Override
		public void runHybrid(WebDriver driver, HashMap<String, String> map) {
			// TODO Auto-generated method stub

		}

	},
	EnterSignupPassword {

		@Override
		public void runHybrid(WebDriver driver, HashMap<String, String> map) {
			// TODO Auto-generated method stub

		}

	},
	EnterMobileEmail {

		@Override
		public void runHybrid(WebDriver driver, HashMap<String, String> map) {
			// TODO Auto-generated method stub

		}

	};

	abstract public void runHybrid(WebDriver driver, HashMap<String, String> map);
}
