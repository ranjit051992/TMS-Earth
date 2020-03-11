@DD_Homes
Feature: DD_QuickLink


 Background: Given I am logged on to the application
        Given I navigate to the login page
        When I submit "GDQA-P2P@zycus.com" and "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
        Then I should be logged in

    @QuickLinkCheck
    Scenario: To Verify whether user is able to configure Quick Links

        Given I am on home page
        When I click on QuickLink Dropdown
        And I click on "Customize" in Quick Link
        And I select "Reports","Catalog", "P-Card", "Online Store"
        Then I should see selected "Reports","Catalog","P-Card","Online Store" in the Quick Link Dropdown

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


    

    Scenario: To Verify whether admin menus in Quick Links are opened in different tab

       Given I am on home page
        # Given I have configured "AdminMenus" in Quick Link
        When I click on QuickLink Dropdown
        And I click on "Admin Tasks" in Quick Link
        Then I should be redirected to selected "Admin Tasks" in different tab



