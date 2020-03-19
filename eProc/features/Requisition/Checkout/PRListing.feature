Feature: PRListing

@Non-COA @L1  @approval @priyankaNCoa
    Scenario:  To verify that user is able to view approval Status
    Given I am logged in eProc
    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition
    Then I should be able see the status of requisition on the Listing page

@Non-COA @L1 @draft @priyankaNCoa
  Scenario: To verify requisition in draft and actions on it
  Given I am logged in eProc

  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I save requisition in Draft state
  Then I should be able to view the actions for the draft requisition on Listing page
  And I should be able to Edit and submit the Draft requisition
  And I should be able to delete the requisition

@Non-COA @L1 @closeReq @priyankaNCoa
  Scenario: To verify that user is  able to close requisition
  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I close PO

  When I navigate to Requisition Listing page
  And I close the requisition from actions

  Then I should be able to see the status of the requisition changed to Closed

@COA @L1 @coaApproval  @priyankaCOA
    Scenario: COA>> To verify that user is able to view approval Status
    Given I am logged in eProc

    When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
    And I checkout
    And I enter Requisition Name
    And I add Purchase Type
    And I add Settlement Via
    And I add Required By Date
    And I add data in Cost Booking Details section at line level 
    And I submit requisition

    Then I should be able see the status of requisition on the Listing page

@COA @L1 @coaDraft @priyankaCOA
  Scenario: COA>>To verify requisition in draft and actions on it
    Given I am logged in eProc
  When I add 1 "ITEM_NAME_FOR_SEARCHING" items to cart
  And I checkout
  And I enter Requisition Name
  And I add Purchase Type
  And I add Settlement Via
  And I add Required By Date
  And I add data in Cost Booking Details section at line level
  And I save requisition in Draft state
  Then I should be able to view the actions for the draft requisition on Listing page
  And I should be able to Edit and submit the Draft requisition
  And I should be able to delete the requisition

@COA @L1 @closeReqCOA @priyankaCOA
  Scenario: COA>>To verify that user is  able to close requisition
  Given I am logged in eProc
  And I have created a requisition and converted it to PO with 1 "ITEM_NAME_FOR_SEARCHING"
  And I close PO

  When I navigate to Requisition Listing page
  And I close the requisition from actions

  Then I should be able to see the status of the requisition changed to Closed