@DD_Homes
Feature: ManageProfile



 Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
        Then I should be logged in

@Upload
    Scenario: To verify whether user is able to upload the profile picture

       Given I am on Home page
        When I navigate to Manage Profile
        When I reset profile picture
        When I upload photo
        Then photo should be set as profile picture


    # Scenario: To verify whether user is able to change password
    #     Given I login to the application with user "GDQA-P2P@zycus.com" and password "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
    #     When I navigate to Manage Profile
    #     When I change password
    #     Then I should be able to see Password updated success message


    Scenario: To verify whether user is able to change mobile pin
    
   
      Given I am on Home page
        When I navigate to Manage Profile
        When I Change Pin
        Then I should be able to see Pin updated success message


    Scenario: To verify whether user is able to change user level setting
       Given I am on Home page
        When I navigate to Manage Profile
        When I update location details
        Then updated location details should be saved successfully

    
