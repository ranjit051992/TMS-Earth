Feature: DD_SideMenu

Backgroud: Given I am logged into the application

Scenario: To Verify whether Home, My Desk and My Approval menu are displayed for the user

    Given I am Logged into application
    When I click on Hamburgermenu
    Then I should see "Home" "MyDesk" "My Approval"


Scenario: To Verify whether user is able to navigate to product from side Menu

    Given I am Logged into application 
    And "Product" product assigned to Me
    When I click on Hamburgermenu
    And Click on "Product"
    Then I should be redirected to selected "Product"

Scenario: To Verify whether admin products are opened in different tab

    Given I am Logged into application 
    And "Admin Product" assigned to Me
    When I click on "Admin Product"
    Then I should be redirected to selected "Admin Product" in new tab

Scenario: To Verify whether admin menus are opened in different tab

    Given I am Logged into application 
    And Roles to access "Admin Menu" assigned to Me
    When I click on "Admin Menu" of "Product"
    Then I should be redirected to selected "Admin Menu" in new tab