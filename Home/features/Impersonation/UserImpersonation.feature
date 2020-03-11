Feature: Impersonate User

Background: To Login into Application
Given I navigate to the login page
When I submit username and password
Then I should be logged in


Scenario: To verify whether user is able to impersonate to company admin
Given I am on Home page
And I Select Allow impersonate from user profile
When I select allow company admin to impersonate me
Then I should be able to see success popup alert

@tag4
Scenario: To verify user is able to create and revoke request
Given I am on Home page
And I Select Allow impersonate from user profile
And I select view impersonate request page
And I have active impersonate request from company admin
When I click on revoke and create option
Then I see request status change to revoke state
And I navigate back to create impersonate page

Scenario: To verify user is able to revoke request
Given I am on Home page
And I Select Allow impersonate from user profile
And I select view impersonate request page
And I have active impersonate request from company admin
When I click on revoke option
Then I see request status change to revoke state


Scenario: To verify whether user is able to impersonate to company admin
Given I am on Home page
And I Select Allow impersonate from user profile
When I select allow Support user to impersonate me
And I enter impersonation end date "Date"
Then I should be able to see success popup alert

Scenario: To verify user is able to create and revoke request
Given I am on Home page
And I Select Allow impersonate from user profile
And I select view impersonate request page
And I have active impersonate request from support user
When I click on revoke and create option
Then I see request status change to revoke state
And I navigate back to create impersonate page

Scenario: To verify user is able to revoke request
Given I am on Home page
And I Select Allow impersonate from user profile
And I select view impersonate request page
And I have active impersonate request from support user
When I click on revoke option
Then I see request status change to revoke state