Feature: Filter Invoices
    I can filter invoices based on different parameters.

    Background:
        Given I logged in to the application
        And I navigate to Invoice module

    @sanity
    Scenario: Filter invoice by status
        Given I search for a status
        When I select it
        Then I should be able to see the invoices with the desired status
        
    @sanity
    Scenario: Filter invoice by invoice number
        Given I search for a invoice number
        When I apply it
        Then I should be able to see the invoice with the desired invoice number

    Scenario: Filter invoice by supplier
        Given I search for a supplier
        When I select it
        Then I should be able to see the invocies with the desired supplier

    Scenario: Filter invoice by reference number
        Given I search for a reference number
        When I apply it
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
