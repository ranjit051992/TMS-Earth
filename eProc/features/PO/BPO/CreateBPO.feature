Feature: CreateBPO

@Non-COA @L1 @Pooja @BPO
   Scenario: To verify that user is able to create a blanket PO with attachments in Zycus P2P

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I add attachment "ATTACHMENT_PATH"
   And I submit the BPO

   Then I should be able to view the BPO with the attachments


 @Non-COA @L1 @Pooja
    Scenario: To verify that user is able to choose a start date and an End Date

    Given I am logged in eProc
    And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I submit the BPO

    Then I should be able to view the BPO with Validity To and From dates selected


 @Non-COA @L1 @Pooja
    Scenario: To verify that user is able to choose a spend limit

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I update the spend limit
   And I submit the BPO

    Then I should be able to view the BPO with Order Value entered


#  @Non-COA @L1 @Pooja
#    Scenario: To verify that user is able to tag a free text item to a particular Blanket PO

#    Given I am logged in eProc
#    And I am on PO listing page 


#    When I click on Create Blanket PO button
#    And I create a BPO with 1 "SEARCH_GUIDED_ITEM" item

#    Then I should be able to view the BPO with free text item added at index 1

 
@COA @L1 
   Scenario: COA _ To verify that user is able to create a blanket PO with attachments in Zycus P2P

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I add attachment "ATTACHMENT_PATH"
   And I submit the BPO

   Then I should be able to view the BPO with the attachments 


@COA @L1 
   Scenario: COA _ To verify that user is able to choose a start date and an End Date

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I submit the BPO

   Then I should be able to view the BPO with Validity To and From dates selected

  
@COA @L1 
   Scenario: COA _ To verify that user is able to choose a spend limit

   Given I am logged in eProc
   And I am on PO listing page

   When I click on Create Blanket PO button
   And I add all required details in BPO with 1 "ITEM_NAME_FOR_SEARCHING" item
   And I update the spend limit
   And I submit the BPO

   Then I should be able to view the BPO with Order Value entered

<<<<<<< HEAD:eProc/features/PO/BPO/CreateBPO.feature
#  @COA @L1
=======

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


# @COA @L1
>>>>>>> Shubham_19Mar_1:eProc/features/PO/BPO/Bpo.feature
#    Scenario: COA _ To verify that user is able to tag a free text item to a particular Blanket PO

#    Given I am logged in eProc
#    And I am on PO listing page 


#    When I click on Create Blanket PO button
#    And I create a BPO with 1 "SEARCH_GUIDED_ITEM" item

#    Then I should be able to view the BPO with free text item added at index 1