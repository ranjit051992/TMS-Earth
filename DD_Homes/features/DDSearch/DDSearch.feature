@DD_Homes
Feature: DDSearch

    Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "username" and "password"
        Then I should be logged in


    Scenario Outline: To verify whether on Home Page load, frequently accessed list is displayed and user is able to navigate to the product
        Given I am on home page
        And I see Frequently accessed list
        When I click on link "<Frequent Link>"
        Then I should able to navigate to "<Frequent Link>"
        Examples:
            | Frequent Link                  |
            | View Upcoming Requisitions     |
            | View Savings Project Approvals |



    Scenario: To verify whether user is able to search supplier and land in OneView Page , if he has access to OneView

        Given I am on home page
        When I search "PEGDUMMY28" in home search box
        Then I should able to land to One View page



   # Scenario: To verify whether frequently accessed list is updated based on user search
     #   Given I am on home page
     #   When I search "Create New Recurring Contract" in home search box
       # Then I should be able to see "Create New Recurring Contract" in Frequently accessed list

    Scenario: To verify whether On search respective results to be displayed in different buckets- View All
        Given I am on home page
        When I search "Search Contracts" of type VIEW ALL in home search box
        Then I should be able to see "Search Contracts" search results in View All bucket

@vv
    Scenario: To verify whether On search respective results to be displayed in different buckets- Supplier in One View
        Given I am on home page
        When I search "PEGDUMMY28" of type SUPPLIERS IN ONE VIEW in home search box
        Then I should be able to see "PEGDUMMY28" search results in SUPPLIERS IN ONE VIEW bucket


    Scenario: To verify whether On search respective results to be displayed in different buckets- Create

        Given I am on home page
        When I search "Upload New Contract" of type CREATE in home search box
        Then I should be able to see "Upload New Contract" search results in CREATE bucket


    # Scenario: To verify whether On search respective results to be displayed in different buckets- Configured
    #     Given I am on home page
    #     When I search "Configure Potential Supplier Pre-Qualification" of type CONFIGURE in home search box
    #     Then I should be able to see "Configure Potential Supplier Pre-Qualification" search results in CONFIGURE bucket



