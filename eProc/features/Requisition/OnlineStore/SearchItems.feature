Feature: OnlineStore


@Non-COA @L1 @autox
  Scenario: To verify that user is able to select an item from Catalog and add it as my Favourite.
  Given I am logged in eProc
  And I remove items from favorites
  When I search and add "1" "SEARCH_ITEM_NONSTOCK" items as Favourite
  Then I should see all the added Items to favorite can be viewed from 'My Favorites' tab


@Non-COA @L1 @autox
  Scenario: To verify that user is able to Sort every column in basket
  Given I am logged in eProc
  And I navigate to Shopping Basket Page

  When I click on basket name sorting option

  Then I should see all baskets sorted from basket name


@Non-COA @L1 @autox
  Scenario: To verify that user is able to search a particular item or service.
  Given I am logged in eProc

  When I search for "1" "ITEM_NAME_FOR_SEARCHING" items

  Then I should see all the matching items for "ITEM_NAME_FOR_SEARCHING" on Listing


@Non-COA @L1 @autox
  Scenario: To verify that user is able to add an item from Hosted Catalog to the Cart.
  Given I am logged in eProc

  When I add "2" "ITEM_NAME_FOR_SEARCHING" items to cart

  Then I should see "2" "ITEM_NAME_FOR_SEARCHING" items in Cart


@Non-COA @L1 @autox
  Scenario: To verify that user is be able to compare items within a catalog
  Given I am logged in eProc

  When I search for "1" "SEARCH_ITEM_NONSTOCK" items
  And I select multiple catalog items
  And I click on compare items
  Then I should see the selected items compared against multiple parameters name, price, currency, UOM, Supplier



# @Non-COA @L1
#   Scenario: To verify that user is able to discard the punchout items in a requisition
#   Given I am logged in eProc
#   And I navigate to Punchout with name

#   When I add a punchout item added to the 'Review items' page
#   And I delete punchout item from cart
#   And I select Yes in the confirmation pop up

#   Then I should see 'No Results Found' in the  Review Items page.


# @Non-COA @L1
#   Scenario: To verify that user is able to suggest a supplier for free text item
#   Given I am logged in eProc

#   When I Navigate to Guided Page
#   And I add short description
#   And I add qty and price
#   And I add Sourcing status
#   And I save it
#   And I select supplier from the Suggested Supplier dropdown.

#   Then I should see supplier gets added into Requester suggested supplier






