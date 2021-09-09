@AccessAllReports @L1
Feature: Access Report

        @L1 @Rep6 @Staging @L1CA
        Scenario: Check Company admin is able to access Report - Rep1
            Given I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And I navigate to Reports tab
              And I select-List of users grouped by role name and role type per product
              And I should see List of users grouped by role name and role type per product in TMS report
              And I close report
             Then User Logout From Classic TMS

        @L1 @Rep7 @Staging @L1CA
        Scenario: Check Company admin is able to access Report - Rep2
            Given I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And I navigate to Reports tab
              And I select-List of users per product in TMS Report option
              And I should see List of users per product report
              And I close report
             Then User Logout From Classic TMS

        @L1 @Rep8 @Staging @L1CA
        Scenario: Check Company admin is able to access Report - Rep3
            Given I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And I navigate to Reports tab
              And I select-Matrix report detailing number of users in a role per product in TMS Report option
              And I should see Matrix report detailing number of users in a role per product report
              And I close report
             Then User Logout From Classic TMS

        @Rep9 @L2CA
        Scenario: Check Company admin is able to Export Report in Excel
            Given I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And I navigate to Reports tab
              And I select-Matrix report detailing number of users in a role per product in TMS Report option
              And I should see Matrix report detailing number of users in a role per product report
              And I Able to export Report in Excel
              And I close report
             Then User Logout From Classic TMS

        @Rep10 @L2CA
        Scenario: Check Company admin is able to Export Report in PDF
            Given I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And I navigate to Reports tab
              And I select-Matrix report detailing number of users in a role per product in TMS Report option
              And I should see Matrix report detailing number of users in a role per product report
              And I Able to export Report in PDF
              And I close report
             Then User Logout From Classic TMS