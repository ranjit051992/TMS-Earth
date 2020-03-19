Feature: BPOListing

# @Non-COA @L1 @BPO @Pooja
#   Scenario: To verify that user is able to cancel a BPO

#   Given I am logged in eProc
#   And I am on PO listing page
#   And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item
#   And I approve the BPO

#   When I cancel the BPO which is in Parked status

#   Then I should be able to see the BPO in Cancelled status

#  @COA @L1
#    Scenario: COA _ To verify that user is able to cancel a BPO

#    Given I am logged in eProc
#    And I have created and released a BPO

#    When I view the BPO created 
#    And I click on Cancel PO action within Actions tab
#    And I click on Cancel PO button on the confirmation Popup

#    Then I should be able to see the BPO in Cancelled status