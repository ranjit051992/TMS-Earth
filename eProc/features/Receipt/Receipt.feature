Feature: Receipt

@L1 @Non-COA
    Scenario: To verify that buyer is able to save as draft or create a receipt for the items received

    Given I am logged in eProc
    And I Create Standard po with 1 "Catalog" item

    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I save the receipt as draft

    Then I should be able to see the status of reciept created as Draft

    
# @L1 @Non-COA
#     Scenario: To verify that requester is able to save a receipt as draft for the items received

#     Given I am logged in eProc
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I click on Create receipt action
#     And I select the items at item level on receipt creation page
#     And I save the receipt as draft

#     Then I should be able to see the status of reciept created as Draft



@L1 @Non-COA
    Scenario: To verify that buyer is able to create a receipt for the partial items received

    Given I am logged in eProc
    And I Create Standard po with 2 "Catalog" item

    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I update the quantity
    And I click on Create Receipt button
   
    Then I should be able to see the status of receipt as confirmed on Receipt Listing


# @L1 @Non-COA
#     Scenario: To verify that requester is able to create a receipt for the partial items received

#     Given I am logged in eProc
#     And I have created a Req-PO with catalog item with 2 items
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I click on Create receipt action
#     And I select the items at item level on receipt creation page
#     And I update the quantity
#     And I click on Create Receipt button
   
#     Then I should be able to see the status of receipt as confirmed on Receipt Listing

# @L1 @Non-COA 
#     Scenario: To verify that requester is able to cancel a receipt created

#     Given I am logged in eProc
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I click on Create receipt action against the PO created 
#     And I select the items at item level on receipt creation page
#     And I enter received qty same as ordered qty
#     And I submitted the receipt
#     And I checked the status of receipt created
#     And I navigate to My Purchase Orders listing
#     And I view the PO created
#     And I navigate to Receipt subtab
#     And I cancelled the receipt created
#     And I checked the status of that receipt again

#     Then I should be able to see the status of reciept as cancelled


@L1 @Non-COA
    Scenario: To verify that buyer is able to delete the receipt which is in draft state

    Given I am logged in eProc
    And I Create Standard po with 1 "Catalog" item

    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I save the receipt as draft
    And I delete the receipt in draft status from receipt listing page

    Then I should be able to delete the receipt in draft status


# @L1
#     Scenario: To verify that requester is able to delete the receipt which is in draft state

#     Given I am logged in eProc
#     And I have submitted a Req-PO with a catalog item
#     And I have approved the PO to release it

#     When I navigate to PO listing
#     And I search for the created po
#     And I view the created PO
#     And I navigate to Receipt tab
#     And I click on Create receipt action
#     And I select the items at item level on receipt creation page
#     And I save the receipt as draft
#     And I delete the receipt in draft status from receipt listing page

#     Then I should be able to delete the receipt in draft status

