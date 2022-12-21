Feature: Application Login

Scenario: Home page default login
Given User is on login page
When User login with user name "ashokjare1" and password "JareAshok@11"
Then Home page is populated as "true"
And User deatils are populated on home page

Scenario: User is able to login and navigated to home page
Given User is on login page
When User login with user name "ashokjare2" and password "JareAshok@12"
Then Home page is populated as "false"
And User deatils are populated on home page