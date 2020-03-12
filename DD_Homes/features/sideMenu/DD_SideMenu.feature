@DD_Homes
Feature: DD_SideMenu



Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
        Then I should be logged in

Scenario: To Verify whether Home, My Desk and My Approval menu are displayed for the user
   
   
    Given I am on home page
    When I click on Hamburgermenu
    Then I should see "Home" "My Desk" "My Approvals"


Scenario: To Verify whether user is able to navigate to product from side Menu

   Given I am on home page
    And "Product" product assigned to Me
    When I click on Hamburgermenu
    And I Navigate to "eProc" "Online Store"
    Then I should be redirected to selected "eproc"

@NewTab
Scenario: To Verify whether admin products are opened in different tab

  Given I am on home page
    When I click on Hamburgermenu
    And I Navigate to "TMS"
    Then I should be redirected to selected "userListings.tms" in new tab

@NewTab
Scenario: To Verify whether admin menus are opened in different tab
   Given I am on home page
    And Roles to access "Admin Menu" assigned to Me
     When I click on Hamburgermenu
    And I Navigate to "iPerform" "Settings" "Product Configurations"
    Then I should be redirected to selected "displayListClientSettings" in new tab