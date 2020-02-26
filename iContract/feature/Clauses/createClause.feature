Feature: Create clause

Background: login To application
    Given user is logged in to the application
    Then User is landed on common landing page
    # Given User is on the clauses tab
  
@tag4
Scenario: Create clause based on default data

  Given User is on the clauses tab
  When user initiates create clause flow
  And User enter default details on the transition page of clause creation
#   Then Clause is created with default details
  