Feature: CreatePR

@Non-COA @L1 @copy @priyankaNCoa
    Scenario: To verify that user is able to copy any requisition and modify it to create a new requisition.
    Given I am logged in eProc

    When I create requisition with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I copy that requisition
    And I fetch Requisition Name
    And I modify the field quantity
    And I add Tax Details at line level
    And I save it
    And I submit requisition

    Then I should be able to see submitted requisition with updated details

@Non-COA @L1 @multipleCostCenter @priyankaNCoa
    Scenario: To verify that user is able to create requisition for multiple items with multiple cost center for each item
    Given I am logged in eProc

    When I add 2 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add Costing split at header level by Percentage into 2 splits
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able to view the requisition with multiple items
    And I should see split cost center added to each item at header level 
    And I should be able to see split cost center added to each item at line level

@Non-COA @L1 @taxes @priyankaNCoa
    Scenario: To verify that user is able to add taxes at line item level in a requisition for catalog item
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I add Tax Details at line level
    And I save it
    And I submit requisition

    Then I should be able see the taxes added on view requisition

@Non-COA @L1 @freeTextItem @priyankaNCoa
  Scenario: To verify that user is able to add taxes at line item level in a requisition for free-text item 
  Given I am logged in eProc

  When I add 1 free text item "SEARCH_GUIDED_ITEM" to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  And I add Tax Details at line level
  And I save it
  And I submit requisition

  Then I should be able see the taxes added on view requisition

@Non-COA @L1 @multiItemTaxes @priyankaNCoa
  Scenario: To verify that user is able to add taxes at line item level in a requisition for catalog,punchout & free-text item
  Given I am logged in eProc
  # And I navigate to punchout site

  # When I add a punchout item to cart
  
  When I add taxes to requition for 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item
 
  Then I should be able see the taxes added for multiple items on view requisition


@Non-COA @L1 @priyankaNCoa @deliverySplit
  Scenario: To verify that user is able to create requisition with conditions of delivery address
  Given I am logged in eProc

  When I add a catalog item "ITEM_NAME_FOR_SEARCHING" with quantity 2 to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add Delivery split at line level into 2 splits
  And I change the address for split 2
  And I save it
  And I add data in Cost Booking Details section at line level 
  And I submit requisition

  Then I should be able to view the requisition with the delivery split
  And I should see that the address is updated for split 2



@COA @L1 @coaCopy @priyankaCOA
    Scenario: COA>>To verify that user is able to copy any requisition and modify it to create a new requisition.
    Given I am logged in eProc

    When I create requisition with 1 "ITEM_NAME_FOR_SEARCHING" item
    And I copy that requisition
    And I modify the field quantity
    And I add Tax Details at line level
    And I save it
    And I submit requisition

    Then I should be able to see submitted requisition with updated details

@COA @L1 @coaTaxes @priyankaCOA
    Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for catalog item
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I add Tax Details at line level
    And I save it
    And I submit requisition

    Then I should be able see the taxes added on view requisition

@COA @L1 @coafreeTextItem @priyankaCOA
  Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for free-text item 
  Given I am logged in eProc

  When I add 1 free text item "SEARCH_GUIDED_ITEM" to cart
  And I checkout
  And I add Purchase Type
  And I add Required By Date
  And I add data in Cost Booking Details section at line level 
  And I add Tax Details at line level
  And I save it
  And I submit requisition

  Then I should be able see the taxes added on view requisition

@COA @L1 @coaMultiItemTaxes @priyankaCOA
  Scenario: COA>>To verify that user is able to add taxes at line item level in a requisition for catalog,punchout & free-text item
  Given I am logged in eProc
  # And I navigate to punchout site

  # When I add a punchout item to cart
  # And I add a free text item to cart
  # And I add a catalog item to cart
  And I add taxes to requition for 1 "ITEM_NAME_FOR_SEARCHING" and 1 free text item
 
  Then I should be able see the taxes added for multiple items on view requisition

@COA @L1 @priyankaCOA @coaDeliverySplit
  Scenario: COA>>To verify that user is able to create requisition with conditions of delivery address
  Given I am logged in eProc

  When I add a catalog item "ITEM_NAME_FOR_SEARCHING" with quantity 2 to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add Delivery split at line level into 2 splits
  And I change the address for split 2
  And I save it
  And I add data in Cost Booking Details section at line level 
  And I submit requisition

  Then I should be able to view the requisition with the delivery split
  And I should see that the address is updated for split 2