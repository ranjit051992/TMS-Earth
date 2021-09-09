@UserEmailExport @L2CA
Feature: Import and Export of Email

        @EmailExport
        Scenario: Export User Email Edit file
            Given I logged in TMS with user role "CA"
             Then Navigate to User Listing "TMS" "TMS"
              And I am on User listing Page
              And I click on User Email Edit Export User data
              And I click on Bell icon
             Then I should see the export user data under bell icon