Feature: Filter Invoices
    User can filter invoices based on different parameters.

    Background:
        Given I logged in to the application
        And I navigate to CreditMemo module

    Scenario: Filter credit memo by status
        Given I search for a status
        When I select it
        Then I should be able to see the credit memos with the desired status

    Scenario: Filter credit memo by credit memo number
        Given I search for a credit memo number
        When I apply it
        Then I should be able to see the credit memo with the desired credit memo number

    Scenario: Filter credit memo by supplier
        Given I search for a supplier
        When I select it
        Then I should be able to see the credit memos with the desired supplier

    Scenario: Filter credit memo by reference number
        Given I search for a reference number
        When I apply it
        Then I should be able to see the credit memo with the desired reference number
    
    Scenario: Filter credit memo by credit memo date
        Given I select a credit memo date
        When I apply it
        Then I should be able to see the credit memo with the desired date
