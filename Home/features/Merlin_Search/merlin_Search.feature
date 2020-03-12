Feature: Merlin_Search

        Backgroud: Given I am logged on to the application

      Scenario: To verify whether on Home Page load, frequently accessed list is displayed and user is able to navigate to the product

        Given I am on home page
        When I see Frequently accessed list
        And I click on "link"
        Then I should able to navigate to "link"


    Scenario: To erify whether user is able to search supplier and land in OneView Page , if he has access to OneView

        Given I am on home page
        And I have access to Onew View
        When I search "supplier" in home search box
        Then I should able to land to One View page
        And I should be able to search "supplier"

    Scenario: To verify whether frequently accessed list is updated based on user search

        Given I am on home page
        When I search "link" in home search box
        Then I should be able to see "link" in Frequently accessed list

    Scenario: To verify whether On search respective results to be displayed in different buckets. a. View All b. Create c. Configured d. Supplier in One View

        Given I am on home page
        When I search "link" of "type" in home search box
        Then I should be able to see "link" search results in respective "type" bucket







