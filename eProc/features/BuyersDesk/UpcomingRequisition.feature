Feature: UpcomingRequisition

@Non-COA @L1
    Scenario: To verify filters on Upcoming Requisition status filter
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with Requisition number field

    Then I should be see the data on the page on the basis on Requisition number field

@Non-COA @L1
    Scenario: To verify requisition name filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with requisition name field

    Then I should be see the data on the page on the basis on requisition name field

@Non-COA @L1
    Scenario: To verify requestor filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with Requestor field

    Then I should be see the data on the Upcoming Requisition page on the basis on Requestor field

@Non-COA @L1
    Scenario: To verify Submitted On filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with Submitted on field by "Create Date"

    Then I should be see the data on the page on the basis on Submitted on field

@Non-COA @L1
    Scenario: To verify Assigned Buyer filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter any buyer "BUYER_NAME"

    Then I should be see the data on the Upcoming Requisition page with the filtered buyer

@Non-COA @L1
    Scenario: To verify Purchase Amount filter on Upcoming Requisition
    Given I am logged in eProc

    When I navigate to Upcoming Requisition
    And I filter with Purchase Amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

    Then I should be see the data on the page with the filtered amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

@COA @L1
    Scenario: COA>>To verify Requisition number on Upcoming Requisition status filter
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with Requisition number field

    Then I should be see the data on the page on the basis on Requisition number field

@COA @L1
    Scenario: COA>>To verify requisition name filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with requisition name field

    Then I should be see the data on the page on the basis on requisition name field

@COA @L1
    Scenario: COA>>To verify requestor filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with Requestor field

    Then I should be see the data on the Upcoming Requisition page on the basis on Requestor field

@COA @L1
    Scenario: COA>>To verify Submitted On filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter with Submitted on field by "Create Date"

    Then I should be see the data on the page on the basis on Submitted on field

@COA @L1
    Scenario: COA>>To verify Assigned Buyer filter on Upcoming Requisition
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I navigate to Upcoming Requisition
    And I filter any buyer "BUYER_NAME"

    Then I should be see the data on the Upcoming Requisition page with the filtered buyer

#  @COA @L1
#      Scenario: COA>>To verify Purchase Amount filter on Upcoming Requisition
#     Given I am logged in eProc

#     When I navigate to Upcoming Requisition
#     And I filter with Purchase Amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

#     Then I should be see the data on the page with the filtered amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"
