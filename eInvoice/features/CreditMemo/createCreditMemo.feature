Feature: Credit Memo Creation
    User can create credit memo with or without reference

    Background:
        Given I logged in to the application
        And I navigate to CreditMemo module

    Scenario: Create credit memo against po
        Given I create po in eproc
        And I navigate to Invoice module
        And I create invoice against po
        And I navigate to CreditMemo module
        When I create the credit memo against po invoice
        Then I should be able to see the created credit memo on credit memo listing

    Scenario: Create credit memo against po without item
        Given I create po in eproc
        And I navigate to Invoice module
        And I create invoice against po
        And I navigate to CreditMemo module
        When I create the credit memo against po invoice without item
        Then I should be able to see the created credit memo on credit memo listing

    Scenario: Create credit memo without reference
        Given I fill the credit memo details
        When I submit the credit memo
        Then I should be able to see the created credit memo on credit memo listing

    Scenario: Create credit memo without item
        Given I fill the credit memo details without item
        When I submit the credit memo
        Then I should be able to see the created credit memo on credit memo listing

    Scenario: To verify that the information about the credit memo used against the Invoice is available in its audit trail
        Given I have a PO invoice created
        When I create a credit memo against same PO
        And I adjust that credit memo against invoice
        And I view the invoice to check the audit trail section
        Then I can able to see the entry of adjusted credit memo in audit trail