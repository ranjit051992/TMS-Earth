Feature: CreateBOR

 @Non-COA @L1 @Pooja
   Scenario: To verify that user is able to create PO releases against Blanket PO

   Given I am logged in eProc
   And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it

   When I create Release of the BPO

   Then I should be able to view the proper details in Release Order


 @Non-COA @L1 @Pooja
   Scenario: To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"

   Given I am logged in eProc
   And I Create Blanket po with 1 "ITEM_NAME_FOR_SEARCHING" item and approve it

   When I create Release of the BPO

   Then I should be able to view released order against the BPO


#  @COA @L1
#    Scenario: COA _ To verify that user is able to create PO releases against Blanket PO

#    Given I am logged in eProc
#    And I have created a Blanket PO with a catalog item

#    When I click on Create Release action against the BPO created
#    And I fill the accounting details against the item
#    And I submit the Release
#    And I view the release created

#    Then I should be able to view the details filled in Release (Supplier, item name, item price, GL Account)


#  @COA @L1
#    Scenario: COA _ To verify that user is able to view all the released orders generated against a  BPO on a new tab called "Release Orders"

#    Given I am logged in eProc
#    And I have created a Blanket PO with a catalog item
#    And I have created a release against the BPO.

#    When I view the BPO
#    And I navigate to Release orders tab 

#    Then the Release created against the BPO should be listed there