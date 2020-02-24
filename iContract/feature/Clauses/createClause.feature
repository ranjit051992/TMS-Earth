Feature: Create clause

Background: login To application
    Given user is logged in to the application
    And User fetches the language
  
  
@tag4
Scenario: Create clause based on user given data
  Given User is on the clauses tab
  When user initiates create clause flow
  And User enter all details on the transition page of clause creation
  Then Clause is created with default details
  