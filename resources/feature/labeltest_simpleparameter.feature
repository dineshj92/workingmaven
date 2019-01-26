@LabelTest
Feature: Create An Account Label 

Scenario: Validate Create An Account label in sign up page 
	Given User is on Facebook sign-up page 
	When The page is loaded
	Then create account label "Create an account" and welcome label "Facebook helps you connect and share with the people in your life." should be visible 
	
