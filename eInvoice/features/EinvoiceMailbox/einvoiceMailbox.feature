Feature: verfying eInvoice mailbox functionality
    I will be able to see all the einvoice mailbox functionality


    Background:
        Given I logged in to the ZSN
        And I navigate to the invoice creation

    Scenario: nonpo invoices that are received from ZSN are sent to eInvoice Mailbox
        Given I submitted the invoices in ZSN
        And I logged out from ZSN
        When I logged in to the dewdrop application
        And I navigated to the einvoice mailbox
        Then I am able to see the invoice created in the ZSN

    Scenario: invoices that are received from ZSN can be edited
        Given I submitted the invoices in ZSN
        And I logged out from ZSN
        When I logged in to the dewdrop application
        And I navigates to the einvoice mailbox
        And I edited and submit the invoice
        Then I am able to see the invoice in invoice listing

    Scenario: invoices that are received from ZSN are sent to einvoice mailbox
        Given I submitted the invoices in ZSN
        And I logged out from ZSN
        When I logged in to the dewdrop application
        And I navigated to the einvoice mailbox
        And I returned the received invoice
        Then I should not be able to see the invoice in Mailbox

    Scenario: PO invoices that are received from ZSN are sent to einvoice listing
        Given I submitted the PO invoices in ZSN
        And I logged out from ZSN
        When I logged in to the dewdrop application
        And I navigated to the invoice listing
        Then I should be able to see the invoice in listing

    Scenario: add Self-assessed tax to invoices Memos received from Supplier (ZSN)
        Given I submitted the PO invoices in ZSN
        And I logged out from ZSN
        When I logged in to the dewdrop application
        And I navigate to the invoice mailbox
        And I should be able to add the Self-assessed tax to invoice
        Then I should be able to submit the invoices
        And I should be able to see the correct calculations for taxes

    Scenario: add Self-assessed tax to Credit memos received from Supplier (ZSN)
        Given I submitted the credit memo in ZSN
        And I logged out from ZSN
        When I logged in to the application
        And I navigate to the invoice mailbox
        And I should be able to add the Self-assessed tax to credit memo
        Then I should be able to submit the credit memo
        And I should be able to see the correct calculations for taxes