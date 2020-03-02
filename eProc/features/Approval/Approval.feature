Feature: Approval

@L1
    Scenario: To verify Requisition details are  properly displayed in approval listing

    Given I am logged in eProc
    And I create requisition with "1" "ITEM_NAME_FOR_SEARCHING" item
    And I have requisition In Approval status
    And I am on requisition approval listing page

    When I search for that requisition name on approval listing

    Then I see the same requester
    And I see the same Received on date
    And I see the same Amount to be approved
    And I see the same status of Requisition

    


@L1 @Run
    Scenario: To verify Purchase Order details are properly displayed in approval listing

    Given I am logged in eProc
    And I Create Standard po with "1" "ITEM_NAME_FOR_SEARCHING" item
    And I have PO with In Approval status
    And I am on PO approval listing page

    When I search for that PO name on PO approval listing

    Then I see the same Buyer name displayed for the corresponding PO number
    And I see the same Received on date on PO Approval listing
    And I see the same Amount to be approved on PO Approval listing
    And I see the same status of Requisition on PO Approval listing

@L1
    Scenario: To verify BPO details are properly displayed in approval listing

    Given I am logged in eProc 
    And I have submit the Blanket Purchase order
    And I have BPO In Approval status
    And I am on BPO approval listing page

    When I check the Buyer name displayed for the corresponding BPO number
    And I check the Received on date
    And I check the Amount to be approved
    And I check the status of the BPO

    Then I should get all details, same as what entered while creating that BPO


@L1
    Scenario: To verify that user is able to approve single/multiple Requisition

    Given I am logged in eProc
    And I have submit 3 requisitions
    And I have requisitions In Approval status
    And I am on requisition approval listing page

    When I Approve 1 requisition
    And I Approve another 2 requisitions 
    And I fill in comments within popup
    And I click on Approve
    And I search for all the requisitions in the search filter

    Then the status of all the requisitions should be displayed as Approved


@L1
    Scenario: To verify that user is able to reject single/multiple Requisition

    Given I am logged in eProc 
    And I have submit 3 requisitions 
    And I have requisitions In Approval status
    And I am on requisition approval listing page

    When I Reject 1 requisition
    And I fill in comments within popup
    And I click on Reject
    And I Reject another 2 requisitions 
    And I fill in comments within popup
    And I click on Reject
    And I search for all the requisitions in the search filter

    Then the status of all the requisitions should be displayed as Rejected


@L1
    Scenario: To verify that user is able to delegate single/multiple Requisition

    Given I am logged in eProc
    And I have submit 3 requisitions 
    And I have requisitions In Approval status
    And I am on requisition approval listing page

    When I Delegate 1 requisition
    And I fill in comments within popup
    And I click on Delegate
    And I Delegate another 2 requisitions 
    And I fill in comments within popup
    And I click on Delegate
    And I search for all the requisitions in the search filter

    Then the status of all the requisitions should be displayed as Delegated


@L1 @Run2
    Scenario: To verify that user is able to approve single/multiple PO

    Given I am logged in eProc
    And I Create 3 Standard po with "1" "ITEM_NAME_FOR_SEARCHING" item
    And I have 3 POs In Approval status
    And I am on PO approval listing page

    When I Approve 1 PO
    And I Approve 2 POs

    Then I should be able to see the status of all POs as Approved


@L1
    Scenario: To verify that user is able to reject single/multiple PO

    Given I am logged in eProc 
    And I Create 3 Standard po with "1" "ITEM_NAME_FOR_SEARCHING" item
    And I have 3 POs In Approval status
    And I am on PO approval listing page

    When I Reject 1 PO
    And I Reject 2 POs

    Then I should be able to see the status of all POs as Rejected


@L1
    Scenario: To verify that user is able to delegate single/multiple PO

    Given I am logged in eProc 
    And I Create 3 Standard po with "1" "ITEM_NAME_FOR_SEARCHING" item
    And I have 3 POs In Approval status
    And I am on PO approval listing page

    When I Delegate 1 PO
    And I Delegate 2 POs

    Then I should be able to see the status of all POs as Delegated


@L1
    Scenario: To verify that user is able to approve single/multiple BPO

    Given I am logged in eProc
    And I have submit 3 BPOs
    And I have POs In Approval status
    And I am on PO approval listing page

    When I Approve 1 BPO
    And I fill in comments within popup
    And I click on Approve
    And I Approve another 2 BPOs
    And I fill in comments within popup
    And I click on Approve
    And I search for all the BPOs in the search filter

    Then the status of all the BPOs should be displayed as Approved


@L1
    Scenario: To verify that user is able to reject single/multiple BPO

    Given I am logged in eProc 
    And I have submit 3 BPOs
    And I have POs In Approval status
    And I am on BPO approval listing page

    When I Reject 1 BPOs
    And I fill in comments within popup
    And I click on Reject
    And I Reject another 2 BPOs
    And I fill in comments within popup
    And I click on Reject
    And I search for all the BPOs in the search filter

    Then the status of all the BPOs should be displayed as Rejected


@L1
    Scenario: To verify that user is able to delegate single/multiple BPO

    Given I am logged in eProc 
    And I have submit 3 BPOs
    And I have BPOs In Approval status
    And I am on BPO approval listing page

    When I Delegate 1 BPO
    And I fill in comments within popup
    And I click on Delegate
    And I Delegate another 2 BPOs
    And I fill in comments within popup
    And I click on Delegate
    And I search for all the BPOs in the search filter

    Then the status of all the BPOs should be displayed as Delegated