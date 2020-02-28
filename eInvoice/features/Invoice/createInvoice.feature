Feature:Invoice Creation
    User can create a po/non po invoice.

    Background:
        Given I logged in to the application
        And I navigate to Invoice module

    Scenario: Create non po invoice
        Given I fill the invoice details
        When I submit the invoice
        Then I should be able to see the created invoice on invoice listing

    Scenario: Create po invoice
        Given I create po in eproc
        And I navigate to Invoice module
        When I create the invoice against po
        Then I should be able to see the created invoice on invoice listing

    Scenario: Create bpo invoice
        Given I create bpo in eproc
        And I navigate to Invoice module
        When I create the invoice against bpo
        Then I should be able to see the created invoice on invoice listing