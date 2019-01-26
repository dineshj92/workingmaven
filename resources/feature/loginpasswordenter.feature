Feature: Login Action
 
Scenario Outline: Successful Login with Valid Credentials
 Given User is on Home Page
 When User Navigate to LogIn Page
 Then User should be able "<username>" and "<password>"
Examples:
    | username   | password |
    | testuser_1 | Test@153 |