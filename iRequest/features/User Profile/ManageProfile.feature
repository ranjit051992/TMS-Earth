Feature: Login & Manage Profile

    Background:
        Given logged in on iRequest Page


    Scenario: Save Manage Profile

        Given I see the Username
        And I change data in ManageProfile Section
        Then I can save the updated data


    Scenario: Cancel Manage Profile

        Given I see the UserLogo
        Then I can able to cancel the updated data

    Scenario: Logout

        Given I see UserName
        Then I am logging out
        Then I can able to logout of the application



