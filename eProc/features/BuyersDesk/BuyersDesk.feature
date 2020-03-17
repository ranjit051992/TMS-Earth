Feature: BuyersDesk


@Non-COA @L1
    Scenario: To verify if Buyer is able to edit the requisition.
    Given I am logged in eProc
    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I Approve "1" Requisitions
    And I navigate to Buyer Desk
    And I edit the requisition

   Then I should be able to view the requisition in edit mode

# @Non-COA @L1
#     Scenario: To verify if buyer is able to convert Requisition to PO based on different criteria 
#     Given I am logged in eProc

#     When I create "2" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
#     And I Approve "2" Requisitions
#     And I navigate to Buyer Desk
#     And I select "2" requisition with same currency, supplier, delivery address from listing page
#     And I convert it to PO from listing

#     Then I should be able to create a PO with multiple requisition merged into one

# @konica
#     Scenario: To verify filters on buyer's desk status filter
#     Given I am logged in eProc

#     When I navigate to Buyer Desk 
#     And I filter with "IN PROCESS" status

    #Then I should be see the data on the page with the filtered status

 @Non-COA @L1
     Scenario: To verify requisition number filter on buyer's desk 
     Given I am logged in eProc

     When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
     And I Approve "1" Requisitions
     And I navigate to Buyer Desk
     And I filter with Requisition number field

     Then I should be see the data on the page on the basis on Requisition number field

 @Non-COA @L1
     Scenario: To verify requisition name filter on buyer's desk 
     Given I am logged in eProc

     When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
     And I Approve "1" Requisitions
     And I navigate to Buyer Desk
     And I filter with requisition name field

     Then I should be see the data on the page on the basis on requisition name field

@Non-COA @L1 @gocd
    Scenario: To verify requestor filter on buyer's desk 
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I Approve "1" Requisitions
    And I navigate to Buyer Desk
    And I filter with Requestor field

    Then I should be see the data on the page on the basis on Requestor field

@Non-COA @L1
    Scenario: To verify Received On filter on buyer's desk 
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I Approve "1" Requisitions
    And I navigate to Buyer Desk
    And I filter with Received on field by "Create Date"

    Then I should be see the data on the page on the basis on Received on field

 @Non-COA @L1
     Scenario: To verify Assigned Buyer filter on buyer's desk 
     Given I am logged in eProc

     When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
     And I Approve "1" Requisitions
     And I navigate to Buyer Desk
     And I filter any buyer "BUYER_NAME"

     Then I should be see the data on the page with the filtered buyer

@Non-COA @L1
    Scenario: To verify Purchase Amount filter on buyer's desk 
    Given I am logged in eProc

    When I navigate to Buyer Desk
    And I filter with Purchase Amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

    Then I should be see the data on the page with the filtered amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

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

    Then I should be see the data on the page on the basis on Requestor field

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

    Then I should be see the data on the page with the filtered buyer

@Non-COA @L1
    Scenario: To verify Purchase Amount filter on Upcoming Requisition
    Given I am logged in eProc

    When I navigate to Upcoming Requisition
    And I filter with Purchase Amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

    Then I should be see the data on the page with the filtered amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

# @Non-COA @L1konica
#     Scenario: To verify that Buyer is able to view ordered requisitions
#     Given I am logged in eProc

#     When I navigate to Buyers Desk
#     And I filter Released requisition
#     And I view any requisition

#     Then I should be able to view the requisition with all details

@Non-COA @L1
    Scenario: To verify that Buyer is able to change buyer
    Given I am logged in eProc

    When I add a catalog item to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level with Buyer
    And I submit requisition
    And I approve the requisition
    And I navigate to Buyer Desk
    And I edit the requisition on Buyers Desk
    And I update Assigned Buyer at  line level for item
    And I save it

    Then I should be able to see the update Buyer for the requisition on Buyer Desk Listing
    And I should be able to see updated Buyer on Requisition page also.

@Non-COA @L1
    Scenario: To verify that user(buyer) is not allowed to modify the requisition.
    Given I am logged in eProc

 
    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I Approve "1" Requisitions
    And I navigate to Buyer Desk
    And I return the requisition on Buyers Desk
    And I allow requestor to resubmit the requisition

    Then I should see the requisition In Returned for Amendment State on Requisition Listing

@Non-COA @L1konica
    Scenario: To verify that user(buyer) is not allowed to modify the requisition.
    Given I am logged in eProc

    When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
    And I Approve "1" Requisitions
    And I navigate to Buyer Desk
    And I return the requisition on Buyers Desk
    And I do not allow requestor to resubmit the requisition

    Then I should  see the requisition In Rejected State on Requisition Listing

# @Non-COA @L1
#     Scenario: To verify that user(buyer) is not allowed to modify the requisition.
#     Given I am logged in eProc

#     When I add "1" "ITEM_NAME_FOR_SEARCHING" items to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level
#     And I add GL account Details
#     And I submit requisition
#     And I approve the requisition
#     And I navigate to Buyer Desk
#     And I filter with requisition name field
#     And I edit the requisition
#     And I convert the requisition PO on Buyers Desk
#     And I navigate to Purchase Order
#     And I cancel the Purchase Order when it is in Parked status

#     Then I should not be see the requisition in Pending Order state on Buyers desk


#  @COA @L1
#    Scenario: COA>>To verify if Buyer is able to edit the requisition.


#     Given I am logged in eProc
#     When I create "1" requisition with "1" "ITEM_NAME_FOR_SEARCHING"
#     And I Approve "1" Requisitions
#     And I navigate to Buyer Desk
#     And I edit the requisition

#    Then I should be able to view the requisition in edit mode 

# @COA @L1
#     Scenario: COA>>To verify if buyer is able to convert Requisition to PO based on different criteria 
#     Given I am logged in eProc

#     When I navigate to Buyers Desk
#     And I select multiple requisition with same currency, supplier, delivery address from listing page
#     And I convert it to PO from listing

#     Then I should be able to create a PO with multiple requisition merged into one

# @COA @L1
#     Scenario: COA>>To verify filters on buyer's desk status filter
#     Given I am logged in eProc

#     When I navigate to Buyer Desk
#     And I filter any status

#     Then I should be see the data on the page with the filtered status

# @COA @L1
#     Scenario: COA>>To verify requisition number filter on  buyer's desk 
#     Given I am logged in eProc

#     When I navigate to Buyer Desk
#     And I filter with Requisition number field

#     Then I should be see the data on the page on the basis on Requisition number field

# @COA @L1konica
#     Scenario: COA>>To verify requisition name filter on buyer's desk 
#     Given I am logged in eProc

#     When I navigate to Buyer Desk
#     And I filter with requisition name field

#     Then I should be see the data on the page on the basis on requisition name field

# @COA @L1
#     Scenario: COA>>To verify requestor filter on buyer's desk 
#     Given I am logged in eProc

#     When I navigate to Buyer Desk
#     And I filter with Requestor field

#     Then I should be see the data on the page on the basis on Requestor field

# @COA @L1
#     Scenario: COA>>To verify Received On filter on buyer's desk 
#     Given I am logged in eProc

#     When I navigate to Buyer Desk
#     And I filter with Received on field

#     Then I should be see the data on the page on the basis on Received on field

# @COA @L1
#     Scenario: COA>>To verify Assigned Buyer filter on buyer's desk 
#     Given I am logged in eProc

#     When I navigate to Buyer Desk
#     And I filter any buyer "BUYER_NAME"

#     Then I should be see the data on the page with the filtered buyer

# @COA @L1
#     Scenario: COA>>To verify Purchase Amount filter on buyer's desk 
#     Given I am logged in eProc

#     When I navigate to Buyer Desk
#     And I filter with Purchase Amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

#     Then I should be see the data on the page with the filtered amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

# @COA @L1
#     Scenario: COA>>To verify Requisition number on Upcoming Requisition status filter
#     Given I am logged in eProc

#     When I navigate to Upcoming Requisition
#     And I filter with Requisition number field

#     Then I should be see the data on the page on the basis on Requisition number field

# @COA @L1
#     Scenario: COA>>To verify requisition name filter on Upcoming Requisition
#     Given I am logged in eProc

#     When I navigate to Upcoming Requisition
#     And I filter with requisition name field

#     Then I should be see the data on the page on the basis on requisition name field

# @COA @L1
#     Scenario: COA>>To verify requestor filter on Upcoming Requisition
#     Given I am logged in eProc

#     When I navigate to Upcoming Requisition
#     And I filter with Requestor field

#     Then I should be see the data on the page on the basis on Requestor field

# @COA @L1
#     Scenario: COA>>To verify Submitted On filter on Upcoming Requisition
#     Given I am logged in eProc

#     When I navigate to Upcoming Requisition
#     And I filter with Submitted on field

#     Then I should be see the data on the page on the basis on Submitted on field

# @COA @L1
#     Scenario: COA>>To verify Assigned Buyer filter on Upcoming Requisition
#     Given I am logged in eProc

#     When I navigate to Upcoming Requisition
#     And I filter any buyer "BUYER_NAME"

#     Then I should be see the data on the page with the filtered buyer

#  @COA @L1
#      Scenario: COA>>To verify Purchase Amount filter on Upcoming Requisition
#     Given I am logged in eProc

#     When I navigate to Upcoming Requisition
#     And I filter with Purchase Amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

#     Then I should be see the data on the page with the filtered amount "PURCHASE_AMOUNT_MIN_VALUE" and "PURCHASE_AMOUNT_MAX_VALUE"

# @COA @L1
#     Scenario: COA>>To verify that Buyer is able to view ordered requisitions
#     Given I am logged in eProc

#     When I navigate to Buyers Desk
#     And I filter Released requisition
#     And I view any requisition

#     Then I should be able to view the requisition with all details

# @COA @L1
#     Scenario: COA>>To verify that Buyer is able to change buyer
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level
#     And I submit requisition
#     And I approve the requisition
#     And I navigate to Buyers Desk
#     And I edit the requisition on Buyers Desk
#     And I update Assigned Buyer at  line level for item
#     And I save it

#     Then I should not be see the update Buyer for the requisition on Buyer Desk Listing
#     And I should be able to see updated Buyer on Requisition page also.

# @COA @L1
#     Scenario: COA>>To verify that user(buyer) is not allowed to modify the requisition.
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level
#     And I submit requisition
#     And I approve the requisition
#     And I navigate to Buyers Desk
#     And I return the requisition on Buyers Desk
#     And I allow requestor to resubmit the requisition

#     Then I should not be see the requisition In Returned for Amendment State on Requisition Listing

# @COA @L1
#     Scenario: COA>>To verify that user(buyer) is not allowed to modify the requisition.
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level
#     And I submit requisition
#     And I approve the requisition
#     And I navigate to Buyers Desk
#     And I return the requisition on Buyers Desk
#     And I do not allow requestor to resubmit the requisition

#     Then I should not be see the requisition In Rejected State on Requisition Listing

# @COA @L1
#     Scenario: COA>>To verify that user(buyer) is not allowed to modify the requisition.
#     Given I am logged in eProc

#     When I add a catalog item to cart
#     And I checkout
#     And I add Purchase Type
#     And I add Required By Date
#     And I add data in Cost Booking Details section at line level
#     And I submit requisition
#     And I approve the requisition
#     And I navigate to Buyers Desk
#     And I convert the requisition PO on Buyers Desk
#     And I navigate to Purchase Order
#     And I cancel the Purchase Order when it is in Parked status

#     Then I should not be see the requisition in Pending Order state on Buyers desk

