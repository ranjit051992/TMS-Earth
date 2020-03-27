Feature: PRToReturnNote

@L1 @Non-COA @Pooja
    Scenario: To verify that requester is able to save as draft a return note for a PO

    Given I am logged in eProc
    And I create a requisition to PO with 1 "ITEM_NAME_FOR_SEARCHING" item
  
    When I navigate to PO listing
    And I search for the reqToPO
    And I view the created PO
    And I create a receipt
    And I click on the Create return note option
    And I select the items
    And I enter quantity same as ordered quantity
    And I enter Reason for Return
    And I enter Return Method
    And I save the return note as draft

    Then I should be able to see the return note in draft status


@L1 @Non-COA @Pooja
    Scenario: To verify that requester is able to create a return note for a PO

    Given I am logged in eProc
    And I create a requisition to PO with 1 "ITEM_NAME_FOR_SEARCHING" item
  
    When I navigate to PO listing
    And I search for the reqToPO
    And I view the created PO
    And I create a receipt
    And I click on the Create return note option
    And I select the items
    And I enter quantity same as ordered quantity
    And I enter Reason for Return
    And I enter Return Method
    And I submit the return note

    Then I should be able to see the return note created


@L1 @Non-COA @Pooja
    Scenario: To verify that requester is able to delete the return note which is in draft state

    Given I am logged in eProc
     And I create a requisition to PO with 1 "ITEM_NAME_FOR_SEARCHING" item
  
    When I navigate to PO listing
    And I search for the reqToPO
    And I view the created PO
    And I create a receipt
    And I click on the Create return note option
    And I select the items
    And I enter quantity same as ordered quantity
    And I enter Reason for Return
    And I enter Return Method
    And I save the return note as draft
    And I delete the return note in draft status

    Then I should be able to delete the return note in draft state