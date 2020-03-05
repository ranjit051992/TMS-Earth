Feature: Filter Invoices
    I can filter invoices based on different parameters.

    Background:
        Given I logged in to the application
        And I navigate to Invoice module
    @L1
    Scenario: Filter invoice by status
        When I filter invoice by status
        Then I should be able to see the invoices with the desired status
    @L1  
    Scenario: Filter invoice by invoice number
        When I filter invoice by invoice number
        Then I should be able to see the invoice with the desired invoice number
    @L1
    Scenario: Filter invoice by supplier
        When I filter invoice by supplier
        Then I should be able to see the invocies with the desired supplier
    @L1
    Scenario: Filter invoice by reference number
        When I filter invoice by reference number
        Then I should be able to see the invoice with the desired reference number

    Scenario: Filter invoice by invoice date
        Given I select a invoice date
        When I apply it
        Then I should be able to see the invoice with the desired date

    Scenario: Filter invoice by due date
        Given I select a due date
        When I apply it
        Then I should be able to see the invoice with the desired date

    Scenario: Filter invoice by paid amount
        Given I search amount
        When I apply it
        Then I should be able to see the invoice with the paid amount
