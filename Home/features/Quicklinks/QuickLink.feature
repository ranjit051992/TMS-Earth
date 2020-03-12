Feature: DD_QuickLink

Backgroud: Given I am logged into the application

Scenario: To Verify whether user is able to configure Quick Links

    Given I am on Landing Page
    When I click on "Quick Link" Dropdown
    And I click on "Customize"
    And I select "Quick Link Menus" "Menu1", "Menu2", "Menu3"
    And I click on "Apply"
    Then I should see selected "Quick Link Menus" in the Quick Link Dropdown

Scenario: To verify whether user is able to navigate to Menu through Quick Link

    Given I am on Landing Page
    And I have configured "Quick Link" Menus
    When I click on "Quick Link" Dropdown
    And I click on any 1 "Menu" from "Quick Link Menus"
    Then I should be redirected to the "Menu"

Scenario: To Verify the same list is displayed across products for the user

    Given I have configured "Quick Link" Menus
    When I Navigate to "Product1"
    And I click on "Quick Link" Dropdown
    Then I should be see the same "Quick Link Menus" as on Landing Page


Scenario: To Verify whether admin menus in Quick Links are opened in different tab

    Given I have configured "AdminMenus" in Quick Link
    When I click on "Quick Link" Dropdown
    And I click on "Admin Menu" in "Quick Link"
    Then I should be redirected to selected "Admin Menu" in different tab
