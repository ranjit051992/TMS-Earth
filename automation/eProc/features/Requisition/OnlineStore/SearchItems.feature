Feature: OnlineStore

 Background:
    Given logged in on eproc Page

@tag1
  Scenario: Search an Item on OnlineStore page

  Given i am on Online Store page

  When i search catalog item

  Then results for catalog item are displayed

@tag2
  Scenario: Search an Item on OnlineStore page1

  Given i am main page ""


@tag3
  Scenario: Add item to cart

  Given i am on Online Store page

  When cart is empty

  When i search catalog item

  When add quantity

  When click on Add to Cart button

  Then item should be added to cart