@RoleExport @L2CA
Feature: Export Role

        @L2 @DynamicRoleSheet
        Scenario: Verify CA is able to export dynamic role sheet
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Role Listing Page
              And I should be able to see Add New Role option
              And I click on Assign roles in bulk option link
              And I click on Download Dynamic Excel Template
              And Popup should be seen
             Then User Logout From Classic TMS

        @L2 @EditRoleSheet
        Scenario: Verify CA is able to export assignment and edit role sheet
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Role Listing Page
              And I should be able to see Add New Role option
              And I click on Assign roles in bulk option link
              And I click on Download Assignment & Edit Role Sheet
              And Popup should be seen
             Then User Logout From Classic TMS