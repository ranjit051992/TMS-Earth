@Test10
Feature: MenuNavigation

Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "username" and "password"
        Then I should be logged in
@tag56
Scenario: To check product navigation via menu
    Given I am on Home page
    When I click on hamburger icon
    Then I should be redirected to selected  product page