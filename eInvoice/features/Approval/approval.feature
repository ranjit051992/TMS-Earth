Feature: Approval

    Background:
        Given I logged in to the application

    Scenario: To verify that the user is able to view the approval list of invoices
        Given I navigate to Approval module
        When I am on approval listing
        Then I should be able to see all the invoices with their approval status

    Scenario: Approve Invoice
        Given I navigate to Invoice module
        And I create a invoice
        And I navigate to Approval module
        When I approve the created invoice
        And I navigate to Invoice module
        Then I should be able to see the invoice with approved status

    Scenario: Reject Invoice
        Given I navigate to Invoice module
        And I create a invoice
        And I navigate to Approval module
        When I reject the created invoice
        And I navigate to Invoice module
        Then I should be able to see the invoice with rejected status

    Scenario: Delegate Invoice
        Given I navigate to Invoice module
        And I create a invoice
        And I navigate to Approval module
        When I delegate the created invoice
        Then invoice should be delegated

    Scenario: View Invoice
        Given I navigate to Invoice module
        And I create a invoice
        And I navigate to Approval module
        When I view the created invoice
        Then I should be able to view the invoice

    Scenario: Approve Contract
        Given I navigate to RecurringContract module
        And I create a recurring contract
        And I navigate to Approval module
        When I approve the created recurring contract
        And I navigate to RecurringContract module
        Then I should be able to see the recurring contract with approved status

    Scenario: Reject Contract
        Given I navigate to RecurringContract module
        And I create a recurring contract
        And I navigate to Approval module
        When I reject the created recurring contract
        And I navigate to RecurringContract module
        Then I should be able to see the recurring contract with rejected status

    Scenario: Delegate Contract
        Given I navigate to RecurringContract module
        And I create a recurring contract
        And I navigate to Approval module
        When I delegate the created recurring contract
        Then recurring contract should be delegated

    Scenario: To verify that user is able to edit a rejected invoice and resubmit it for approval
        Given I navigate to Invoice module
        And I create a invoice
        And I navigate to Approval module
        And I reject the created invoice
        And I navigate to Invoice module
        And I edit the created invoice
        When I submit the invoice
        And I navigate to Approval module
        Then I should be able to see the invoice for approval

    Scenario: To verify that the attachments present in po/receipt and return note should be visible in PO invoices
        Given I created a PO with attachments
        And I created a receipt, return note with attachments against that PO
        When I create an invoice against same PO
        And I view the invoice from all requests page
        Then I should able to see the attachments of PO, receipt, return note in invoice

    Scenario: To verify that I as a user should able to set the Out of Office for a particular duration
        Given I am on settings page of approval tab
        When I delegate the approval to another user
        Then I can able to save the settings successfully

