Feature: Login Action 

Scenario: Successful Login with Valid Credentials 
	Given User is on Home Page 
	When User Navigate to LogIn Page 
	Then User should be able to enter username 
		| Username   |
		| testuser_1 |
	And able to enter password 
		| Password   |
		| Test@153 |