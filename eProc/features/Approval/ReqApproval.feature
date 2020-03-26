Feature: Req Approval

@Non-COA
    Scenario: To verify Requisition details are  properly displayed in approval listing

    Given I am logged in eProc
    And I create requisition with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I have requisition In Approval status
    And I am on requisition approval listing page

    When I search for that requisition name on approval listing

    Then I see the same requester
    And I see the same Received on date
    And I see the same Amount to be approved
    And I see the same status of Requisition

@Non-COA 
    Scenario: To verify that user is able to approve single/multiple Requisition

    Given I am logged in eProc
    And I Create 3 requisitions with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I have 3 Requisitions In Approval status
    And I am on requisition approval listing page

    When I Approve 1 Requisition
    And I Approve 2 Requisitions

    Then I should be able to see the status of all Requisitions as Approved


@Non-COA 
    Scenario: To verify that user is able to reject single/multiple Requisition

    Given I am logged in eProc 
    And I Create 3 requisitions with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I have 3 Requisitions In Approval status
    And I am on requisition approval listing page

    When I Reject 1 Requisition
    And I Reject 2 Requisitions
    
    Then I should be able to see the status of all Requisitions as Rejected


@Non-COA 
    Scenario: To verify that user is able to delegate single/multiple Requisition

    Given I am logged in eProc
    And I Create 3 requisitions with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I have 3 Requisitions In Approval status
    And I am on requisition approval listing page

    When I Delegate 1 Requisition
    And I Delegate 2 Requisitions 

    Then I should be able to see the status of all Requisitions as Delegated