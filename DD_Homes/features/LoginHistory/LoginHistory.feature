@DD_Homes
Feature: LoginHistory

    Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
        Then I should be logged in
        
    Scenario: To verify whether user is able to view the login History
       Given I am on Home page
       When I navigate to Login History
       Then I should be able to see user's login time and IP
       

    Scenario: To verify whether date and time is displayed as per user preference
       Given I am on Home page
       And  I navigate to manage profile
       And I fetch Timezone under User preferences
       When I navigate to Login History
       Then I should be able to see Timezone as per my preference
