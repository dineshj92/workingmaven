Feature: Login Action
	
Background: Successful Login with Valid Credentials 
	Given User is on Home Page 
	When User Navigate to LogIn Page 
	Then User should be able to enter username 
		| testuser_1 |
	And able to enter password 
		| Test@153 |
		
Scenario: Change Password
	Given User is on account page
	When Click on change Password
	And Enter current and new password
	And Click submit
	But password has not changed
	Then display not sucessful
	
	
Scenario: Successful Login with Valid Credentials 
	Given User is on Home Page 
	When User Navigate to LogIn Page 
	Then User should be able to enter username 
		| testuser_1 |
	And able to enter password 
		| Test@153 |
		
