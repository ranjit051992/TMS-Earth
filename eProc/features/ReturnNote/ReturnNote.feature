Feature: ReturnNote

@L1 @Non-COA
    Scenario: To verify that buyer is able to save as draft a return note for a PO

    Given I am logged in eproc 
    And I have created and released a PO
    
    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I update the quantity
    And I click on Create Receipt button
    And I click on the Create return note option
    And I select the items
    And I enter quantity same as ordered quantity
    And I enter Reason for Return
    And I enter Return Method
    And I save the return note as draft

    Then I should be able to see the return note in draft status


# @L1 @Non-COA
#     Scenario: To verify that requester is able to save as draft a return note for a PO

#     Given I am logged in eproc 
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I have Receipt created
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I save the return note as draft

#     Then I should be able to see the return note in draft status


@L1 @Non-COA
    Scenario: To verify that buyer is able to create a return note for a PO

   Given I am logged in eproc 
    And I have created and released a PO
    
    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I update the quantity
    And I click on Create Receipt button
    And I click on the Create return note option
    And I select the items
    And I enter quantity same as ordered quantity
    And I enter Reason for Return
    And I enter Return Method
    And I submit the return note

    Then I should be able to see the return note created


# @L1 @Non-COA
#     Scenario: To verify that requester is able to create a return note for a PO

#     Given I am logged in eproc 
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I have Receipt created
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I submit the return note

#     Then I should be able to see the return note created


@L1 @Non-COA @Receipt
    Scenario: To verify that buyer is able to delete the return note which is in draft state

    Given I am logged in eproc 
    And I have created and released a PO
    
    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I update the quantity
    And I click on Create Receipt button
    And I click on the Create return note option
    And I select the items
    And I enter quantity same as ordered quantity
    And I enter Reason for Return
    And I enter Return Method
    And I save the return note as draft
    And I delete the return note in draft status

    Then I should be able to delete the return note in draft state


# @L1 @Non-COA
#     Scenario: To verify that requester is able to delete the return note which is in draft state

#     Given I am logged in eproc 
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I have Receipt created
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I save the return note as draft
#     And I delete the return note in draft status

#     Then I should be able to delete the return note in draft state