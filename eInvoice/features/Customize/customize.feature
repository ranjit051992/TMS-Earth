Feature: Setup customize settings
    I will be able to modify customize settings

    Background:
        Given I log in to the application
        And   I navigate to setup module

    Scenario: modify configuration settings
        Given I navigate to customize
        When  I modify the settings for invoice
        Then  I should be able to see the updated configuration settings

    Scenario: modify email notifications settings
        Given I navigate to customize
        When  I modify Email notifications settings
        Then  I should be able to see the updated email notifications settings

    Scenario: modify matching setting
        Given I navigate to customize
        When  I modify matching setting settings
        Then  I should be able to see the updated matching setting
