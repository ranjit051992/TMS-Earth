Feature:Credit Memo Listing

 Background:
    Given I logged in to the application

 Scenario: Verify that the user is able to view all the invoices on listing page
    Given I navigates to CreditMemo module
    When I on the credit memo listing page
    Then I should be able to view all the credit memos