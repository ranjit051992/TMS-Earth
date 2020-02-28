Feature: invoice features
    I can see all the invoice functionality

    Background:
        Given I logged in to the application
        And   I navigate to einvoice module

    Scenario: early payment discounts are applied on the invoice total
        Given I navigate to the setup customize settings
        And   I modify the setting to yes for early payment discounts
        When  I create invoice
        Then  I see early payment discounts should be applied on the invoice total

    Scenario: details of the invoice should be visible in audit trail
        Given I navigates to the invoice listing
        And   I submit the nonpo invoice
        When  I approve the invoice
        And   I view the audit trail
        Then  I should able to see all the actions performed on the invoice

    Scenario: add Self-assessed tax to header level Non PO invoice
        Given I create an invoice with self-assessed tax to the header level
        When  I view the created invoice
        Then  I should be able to see the correct calculations for taxes

    Scenario: add Self-assessed tax to header level CM without reference
        Given I create CM without reference with Self-assessed tax to the header level
        When  I view the CM without reference
        Then  I should be able to see the correct calculations for taxes

    Scenario: market price of item is by default while flipping PO into invoice
        Given I create standard po in eproc
        And   I navigate to the einvoice
        When  I create po invoice
        Then  I should be able to see market price of item is by default from po