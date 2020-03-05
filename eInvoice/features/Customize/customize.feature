Feature: Setup customize settings
    I will be able to modify customize settings

    Background:
        Given I logged in to the application
        And I navigate to setup module
   @L1
    Scenario: modify configuration settings
        Given I navigate to customize
        When I modify the settings for invoice
        Then I should be able to see the updated configuration settings
 
   @L1
    Scenario: modify matching setting
        Given I navigate to customize
        When I modify matching settings
        Then I should be able to see the updated matching setting
