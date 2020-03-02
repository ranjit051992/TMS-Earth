Feature: Invoice Listing

    Background:
        Given User logged in to the application

    Scenario: Verify that the user is able to view all the invoices on listing page
        Given I navigate to Invoice module
        When I am on the invoice listing page
        Then I should be able to view all the invoices

    Scenario: Save filter
        Given I navigate to Invoice module
        And I filter invoice
        When I save view
        Then I should be able to save and see the desired invoices on invoice listing

    Scenario: To verify that I as a user should be able to navigate to any page no. for the search results
        Given I am on invoice listing
        When I provide any specific page no. in GoTopage field
        Then I should be able to navigate to the given page
