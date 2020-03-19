Feature: RequisitionView

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

@COA @L1
    Scenario: COA>>To verify that Buyer is able to change buyer
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

