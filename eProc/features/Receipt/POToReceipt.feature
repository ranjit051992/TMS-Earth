Feature: POToReceipt

@L1 @Non-COA @Pooja
    Scenario: To verify that buyer is able to save as draft or create a receipt for the items received

    Given I am logged in eProc
    And I have created and released a PO

    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I save the receipt as draft

    Then I should be able to see the status of reciept created as Draft


@L1 @Non-COA @Pooja
    Scenario: To verify that buyer is able to create a receipt for the partial items received

    Given I am logged in eProc
    And I have created and released a PO

    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I update the quantity
    And I click on Create Receipt button
   
    Then I should be able to see the status of receipt as confirmed on Receipt Listing


@L1 @Non-COA @Pooja
    Scenario: To verify that buyer is able to delete the receipt which is in draft state

    Given I am logged in eProc
    And I have created and released a PO

    When I navigate to PO listing
    And I search for the po
    And I view the created PO
    And I navigate to Receipt tab
    And I click on Create receipt action
    And I select the items at item level on receipt creation page
    And I save the receipt as draft
    And I delete the receipt in draft status from receipt listing page

    Then I should be able to delete the receipt in draft status


