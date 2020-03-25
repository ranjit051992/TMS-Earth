@DD_Homes @Login
Feature: Login 


Scenario: verify Login with valid credential.
Given I navigate to the login page
And user enter valid "username","password" credentials
Then login must be successful

Scenario: verify Login with Invalid credential.
Given I navigate to the login page
And user enter invalid "username","NuIuRuDaLaAaPoLiPeViQeWoXa21$3" credentials
Then login must give validation error


