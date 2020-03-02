Feature: Credit Memo Actions

 Background:
    Given I logged in to the application
    And I Navigate to CreditMemo module

 Scenario: Edit Credit Memo in Draft stage
    Given I fill the credit memo details
    And I save as draft
    When I edit the credit memo
    And I save the credit memo
    Then I should be able to update and save the changes
    
