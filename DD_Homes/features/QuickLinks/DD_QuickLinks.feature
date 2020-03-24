@DD_Homes
Feature: DD_QuickLink
 Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "username" and "password"
        Then I should be logged in


    Scenario: To Verify whether user is able to configure Quick Links

        Given I am on home page
        When I click on QuickLink Dropdown
        When I click "Customize" in Quicklink dropdown
        When I select product "eProc" and modules "Requisitions","Catalog", "P-Card", "Master Data"
         Then I should see selected product "eProc" and modules "Requisitions","Catalog","P-Card","Master Data" in the Quick Link Dropdown

 
    Scenario: To verify whether user is able to navigate to Menu through Quick Link
        Given I am on home page
        # And I have configured "Quick Link" Menus
        When I click on QuickLink Dropdown
        And I click on any 1 "Requisitions" from Quick Link Menus
        Then I should be redirected to the "Requisitions"

    
    Scenario: To Verify the same list is displayed across products for the user
        Given I am on home page
        # Given I have configured "Quick Link" Menus
        When I click on hamburger icon
        When I Navigate to "eProc" "Online Store"
        # And I click on QuickLink Dropdown
        Then I should be see the same "Requisitions" as on Landing Page

    @QuickLinkCheck
    Scenario: To Verify whether admin menus in Quick Links are opened in different tab
       Given I am on home page
        # Given I have configured "AdminMenus" in Quick Link
        When I click on QuickLink Dropdown
        And I click on "Master Data" in Quick Link
        Then I should be redirected to selected "Master Data" in different tab



