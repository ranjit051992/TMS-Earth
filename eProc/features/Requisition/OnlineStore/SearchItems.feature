Feature: OnlineStore

 Background:
    Given logged in on eproc Page

@tag1
  Scenario: Search an Item on OnlineStore page

  Given i am on Online Store page

  When i search "ITEM_NAME_FOR_SEARCHING"

  Then results for catalog item are displayed

@tag2
  Scenario: Search an Item on OnlineStore page1

  Given i am main page ""


@tag3
  Scenario: Add item to cart

  Given i am on Online Store page

  When cart is empty

  When i search "ITEM_NAME_FOR_SEARCHING"

  When add quantity "2"

  When click on Add to Cart button

  Then item should be added to cart

@tag5
  Scenario: Search an Item on OnlineStore page & verify supplier name

  Given i am on Online Store page

  When i search "ITEM_NAME_FOR_SEARCHING"

  And results for catalog item are displayed

  Then item should have supplier "SUPPLIER_NAME"
