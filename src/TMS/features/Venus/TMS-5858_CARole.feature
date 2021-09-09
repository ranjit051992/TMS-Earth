@REQ_TMS-5858
Feature: Role's activities view for Company admin

        @TEST_TMS-5927         @L2CA @ViewDefaultRoleCA @TMS-5858 @id:1
        Scenario: Add New Default Role and assign to user
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Role Listing Page
              And I click on Roletype DD and select it as Default Roletype
             Then I should be able to view role
             
        @TEST_TMS-5928         @L2CA @ViewGlobalRoleCA @TMS-5858 @id:2
        Scenario: Add New Global Role and assign to user
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Role Listing Page
              And I click on Roletype DD and select it as Global Roletype
             Then I should be able to view role