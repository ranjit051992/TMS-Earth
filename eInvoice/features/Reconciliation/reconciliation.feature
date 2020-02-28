Feature: Uploads functiobality
    I will be able to reconcile new statement.

    Background:
        Given I logged in to the application
        And   I navigate to Uploads module

    Scenario: Reconcile new statement
        Given I update the details for reconciliation of new statement
        When  I upload and reconcile
        Then  I should be able to see the status of reconcile statement
