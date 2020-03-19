Feature: Spo Approval

@Non-COA 
    Scenario: To verify Purchase Order details are properly displayed in approval listing

    Given I am logged in eProc
    And I Create Standard po with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I have PO with In Approval status
    And I am on PO approval listing page

    When I search for that PO name on PO approval listing

    Then I see the same Buyer name displayed for the corresponding PO number
    And I see the same Amount to be approved on PO Approval listing
    And I see the same status of SPO on PO Approval listing
    And I see the same Received on date on PO Approval listing

@Non-COA 
    Scenario: To verify that user is able to approve single/multiple PO

    Given I am logged in eProc
    And I Create 3 Standard po with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I am on PO approval listing page

    When I Approve 1 PO
    And I Approve 2 POs

    Then I should be able to see the status of all POs as Approved


@Non-COA 
    Scenario: To verify that user is able to reject single/multiple PO

    Given I am logged in eProc 
    And I Create 3 Standard po with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I am on PO approval listing page

    When I Reject 1 PO
    And I Reject 2 POs

    Then I should be able to see the status of all POs as Rejected


@Non-COA 
    Scenario: To verify that user is able to delegate single/multiple PO

    Given I am logged in eProc 
    And I Create 3 Standard po with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I am on PO approval listing page

    When I Delegate 1 PO
    And I Delegate 2 POs

    Then I should be able to see the status of all POs as Delegated
