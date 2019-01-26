@login
Feature: Login Action 

@Regression @E2E
Scenario: Successful Login with Valid Credentials 
	Given User is on Home Page 
	When User Navigate to LogIn Page 
	Then User should be able to enter username 
		| Username 	 |
		| testuser_1 |
		| testuser_2 |
		| testuser_3 |
		| testuser_4 |
	And able to enter password 
		| Password |
		| Test@153 |
		
@E2E		
Scenario: Successful page loading 
	Given User is on Home Page 
	When User Navigate to LogIn Page 
	Then URL should be 
		| https://www.facebook.com/ |
		
@E2E		
Scenario: Successful page welcome text 
	Given User is on Home Page 
	When User Navigate to LogIn Page 
	Then Welcome Text should be 
		| Facebook helps you connect and share with the people in your life. |
	