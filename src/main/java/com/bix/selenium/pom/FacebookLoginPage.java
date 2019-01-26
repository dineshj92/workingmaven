package com.bix.selenium.pom;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//this class not contains any test logics, only webelement identification parts.
public class FacebookLoginPage {
	
	WebDriver driver;
	
	//annotation - java
	//@annotationName -syntax
	//Pagefactory which provides @FindBy annotation
	// https://github.com/SeleniumHQ/selenium/blob/master/java/client/src/org/openqa/selenium/support/FindBy.java
	
	//WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='email']"))
	@FindBy(xpath="//input[@name='email']")
	WebElement loginUserNameTextBox;
	
	@FindBy(id="pass")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement signUpFirstNameTextBox;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement signUpLastNameTextBox;
	
	@FindBy(xpath="//div[@class='mbs _52lq fsl fwb fcb']/span")
	WebElement createAccountLabel;
	
	@FindBy(xpath="//span[@id='u_0_z']/span/label") 
	List<WebElement> genderTypes;
	
	@FindBy(xpath="//div[@class='_5iyx']")
	WebElement welcomeText;
	
	public FacebookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getCreateAccountLabel() {
		return createAccountLabel.getText();
	}
	
	public String getWelcomeText() {
		return welcomeText.getText();
	}
	
	public String[] getGenderTypes() {
		String[] gender = new String[2];
		for(int i=0; i<genderTypes.size(); i++) {
			gender[i] = genderTypes.get(i).getText();
		}
		return gender;
	}
	
	public void enterUsername(String user) {
		loginUserNameTextBox.clear();
		loginUserNameTextBox.sendKeys(user);
	}
	
	public void enterPassword(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}
	
	public void enterSignupFirstName(String firstName) {
		signUpFirstNameTextBox.clear();
		signUpFirstNameTextBox.sendKeys(firstName);
	}
	
	public void enterSignupLastName(String lastName) {
		signUpLastNameTextBox.clear();
		signUpLastNameTextBox.sendKeys(lastName);
	}
	
	
 
}
