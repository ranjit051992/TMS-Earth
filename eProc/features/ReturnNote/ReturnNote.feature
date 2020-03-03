Feature: ReturnNote

# @L1
#     Scenario: To verify that buyer is able to save as draft a return note for a PO

#     Given I am logged in eproc 
#     And I Create Standard po with "2" "ITEM_NAME_FOR_SEARCHING" item
#     And I have approved the PO to release it
    
#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I create a Receipt
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I save the return note as draft

#     Then I should be able to see the return note in draft status


# @L1
#     Scenario: To verify that requester is able to save as draft a return note for a PO

#     Given I am logged in eproc 
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I create a Receipt
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I save the return note as draft

#     Then I should be able to see the return note in draft status


# @L1
#     Scenario: To verify that buyer is able to create a return note for a PO

#     Given I am logged in eproc 
#     And I Create Standard po with "2" "ITEM_NAME_FOR_SEARCHING" item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I create a Receipt
#     And I click on the Create return note option
#      And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I submit the return note

#     Then I should be able to see the return note created


# @L1
#     Scenario: To verify that requester is able to create a return note for a PO

#     Given I am logged in eproc 
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I create a Receipt
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I submit the return note

#     Then I should be able to see the return note created


# @L1
#     Scenario: To verify that buyer is able to delete the return note which is in draft state

#     Given I am logged in eproc 
#     And I Create Standard po with "2" "ITEM_NAME_FOR_SEARCHING" item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I create a Receipt
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I save the return note as draft
#     And I delete the return note in draft status

#     Then I should be able to delete the return note in draft state


# @L1
#     Scenario: To verify that requester is able to delete the return note which is in draft state

#     Given I am logged in eproc 
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I create a Receipt
#     And I click on the Create return note option
#     And I select the items
#     And I enter quantity same as ordered quantity
#     And I enter Reason for Return
#     And I enter Return Method
#     And I save the return note as draft
#     And I delete the return note in draft status

#     Then I should be able to delete the return note in draft state