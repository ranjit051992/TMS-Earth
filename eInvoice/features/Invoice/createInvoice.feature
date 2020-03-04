Feature:Invoice Creation
    I can create a po/non po invoice.

    Background:
        Given I logged in to the application
        And I navigate to Invoice module

    @sanity
    Scenario: Create non po invoice
        #Given I add non po invoice details
        Given I create an invoice
        And I add supplier information
        And I add basic details
        And I add items
        And I add billing and cost booking details
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