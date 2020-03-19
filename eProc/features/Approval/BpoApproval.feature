Feature: Bpo Approval

@Non-COA 
    Scenario: To verify BPO details are properly displayed in approval listing

    Given I am logged in eProc 
    And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I have BPO with In Approval status
    And I am on Blanket PO approval listing page

    When I search for that BPO name on BPO approval listing
    
    Then I see the same Buyer name displayed for the corresponding BPO number
    And I see the same Amount to be approved on BPO Approval listing
    And I see the same status of BPO on BPO Approval listing
    And I see the same Received on date on BPO Approval listing

@Non-COA 
    Scenario: To verify that user is able to approve single/multiple BPO

    Given I am logged in eProc
    And I Create 3 Blanket POs with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I am on Blanket PO approval listing page

    When I Approve 1 BPO
    And I Approve 2 BPOs

    Then I should be able to see the status of all BPOs as Approved


@Non-COA 
    Scenario: To verify that user is able to reject single/multiple BPO

    Given I am logged in eProc
    And I Create 3 Blanket POs with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I am on Blanket PO approval listing page

    When I Reject 1 BPO
    And I Reject 2 BPOs

    Then I should be able to see the status of all BPOs as Rejected


@Non-COA 
    Scenario: To verify that user is able to delegate single/multiple BPO

    Given I am logged in eProc
    And I Create 3 Blanket POs with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I am on Blanket PO approval listing page

    When I Delegate 1 BPO
    And I Delegate 2 BPOs

    Then I should be able to see the status of all BPOs as Delegated