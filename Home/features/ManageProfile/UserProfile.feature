Feature: UserProfile

    Backgroud: Given I am logged on to the application


    Scenario: To verify whether user is able to upload the profile picture

        Given I am on home page
        When I click Profile button on home page
        And I click Manage Profile
        And I click Upload
        And I upload photo
        Then photo should be set as profile picture


    Scenario: To verify whether user is able to change password
        Given I am on home page
        When I click Profile button on home page
        And I click Manage Profile
        And I click Change Password
        And I enter updated password details
        Then I should be able to login to application by new password


    Scenario: To verify whether user is able to change mobile pin
        Given I am on home page
        When I click Profile button on home page
        And I click Manage Profile
        And I click Change Pin
        And I enter updated pin details
        Then updated pin should be saved successfully


    Scenario: To verify whether user is able to change user level setting
        Given I am on home page
        When I click Profile button on home page
        And I click Manage Profile
        And I update location details
        Then updated location details should be saved successfully

    
