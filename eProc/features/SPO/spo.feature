Feature: SPO

 Background:
    Given logged in on eproc Page

@tag4
  Scenario: Create Standard PO

  Given i am on purchase order listing Page
    
  And I Create Standard po with "2" "Catalog" item
  
  And i search po by description 




  
  