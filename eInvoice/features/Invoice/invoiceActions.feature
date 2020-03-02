Feature: Invocie Actions

   Background:
      Given I logged in to the application
      And I Navigates to Invoice module

   Scenario: Edit Invoice in Draft stage
      Given I fill the invoice details
      And I save as draft
      When I edit the invoice
      And I save the invoice
      Then I should be able to update and save the changes

   Scenario: Copy non po Invoice
      Given I create an invoice
      When I copy invoice
      And I submit the invoice
      Then I should be able to copy and see the created invoice on invoice listing

   Scenario: To verify that I should be able to confirm and match submitted invoice.
      Given I navigate to Setup Customize
      And I changed the settings for submitted invoice
      When I create an invoice
      And I confirm and match the invoice from actions in listing
      Then I should be able to see the status change of invoice from submitted to in approval on invoice listing

   Scenario: To verify that I should be able to Recall the invoice once submitted
      Given I created an invoice
      When I see invoice went to in approval state
      And I click on actions to recall the invoice from invoice listing
      Then I should see that invoice is recalled successfully
      And I confirmed that invoice status should changed to draft

   Scenario: To verify that I as a user should be able to Return the invoice once submitted
      Given I created an invoice in submitted state
      When I return the invoice from actions in listing
      Then I should see that invoice should be returned successfully

   Scenario: To verify that I as a user should be able to Void the invoice once submitted
      Given I created an invoice in submitted state
      When I void the invoice from actions in listing
      Then I should see that invoice should be voided successfully
   
   Scenario: To verify that the submitted credit memo status should be ready for apportionment under PO tabs
        Given I created a credit memo against PO
        When I created a credit memo successfully
        Then I should see that credit memo status is ready for apportionment in PO subtab