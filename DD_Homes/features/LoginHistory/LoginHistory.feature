@DD_Homes
Feature: LoginHistory

    Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "username" and "password"
        Then I should be logged in
        
    Scenario: To verify whether user is able to view the login History
       Given I am on Home page
       When I navigate to Login History
       Then I should be able to see user's login time and IP
       

    #Scenario: To verify whether date and time is displayed as per user preference
       # Given I am on Home page
      #  And  I navigate to manage profile
     #   And I see date and time preference
     #   When I Select Login history from user profile
     #   Then I am able to see login history popup containing date and time as per my preference
