Feature: SPO

 Background:
    Given logged in on eproc Page

@tag3
  Scenario: Create Standard PO

  Given i am on purchase order listing Page
    
  And I Create Standard po
  
  