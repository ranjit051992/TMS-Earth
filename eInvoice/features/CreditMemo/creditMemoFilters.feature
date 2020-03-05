Feature: Filter Credit Memos
    User can filter credit memos based on different parameters.

    Background:
        Given I logged in to the application
        And I navigate to CreditMemo module
    @L1
    Scenario: Filter credit memo by status
        When I filter credit memo by status
        Then I should be able to see the credit memos with the desired status
    @L1
    Scenario: Filter credit memo by credit memo number
        When I filter credit memo by credit memo number
        Then I should be able to see the credit memo with the desired credit memo number
    @L1
    Scenario: Filter credit memo by supplier
        When I filter credit memo by supplier
        Then I should be able to see the credit memos with the desired supplier
    @L1
    Scenario: Filter credit memo by reference number
        When I filter credit memo by reference number
        Then I should be able to see the credit memo with the desired reference number

    Scenario: Filter credit memo by credit memo date
        When I select a credit memo date
        Then I should be able to see the credit memo with the desired date
