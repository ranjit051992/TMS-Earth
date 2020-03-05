Feature: Credit Memo Listing

 Background:
    Given I logged in to the application
@cmlisting
 Scenario: Verify that the user is able to view all the invoices on listing page
    Given I navigate to CreditMemo module
    When I am on the credit memo listing
    Then I should be able to view all the credit memos