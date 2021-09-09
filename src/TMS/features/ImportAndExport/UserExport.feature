@UserExport @L2CA
Feature: Import and Export

        @L2 @UserExport
        Scenario: Export User data
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  I am on User listing Page
              And I click on Export User data
              And I click on Bell icon
             Then I should see the export user data under bell icon
             
        @L2 @BulkEditOfUsersAllData
        Scenario: Export User data
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  I am on User listing Page
              And I click on Bulk edit of BulkEditOfUsers
              And I select all data option
              And I click on download excel file for BulkEditOfUsers
              And I click on Bell icon
             Then I should see the export user data under bell icon

        @L2 @BulkEditOfUsersFiltered
        Scenario: Export User data Filtered
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  I am on User listing Page
              And I click on Bulk edit of BulkEditOfUsers
              And I select Filtered list option
              #And I select status
              And I enter Reporting manager
              #And I select Assigned products
              And I click on download excel file for Filtered list
              And I click on Bell icon
             Then I should see the export user data under bell icon

        @L2 @UserUploadDownloadSheet
        Scenario: UploadUsers Download Excel Template
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And I click on Upload Users link
             Then I click on Download Excel Template link for UploadUsers

        #@L2 @UserUpload1
        #Scenario: UploadUsers-Download Excel Template
        #   Given I logged in TMS with user role "CA"
        #   Then Navigate to User Listing "TMS" "TMS"
        #      And I am on User listing Page
        #      And I click on Upload Users link
        #      And I select the file to be uploaded
        #      And I click on upload button
        #     Then I click on Bell icon

        @L2CA @UserMgmActivityUsercsvExport @TMS-5977
        Scenario: Check User Management activity user able to Export User CSV data
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And  I am on User listing Page
              And I click on Export User data
              And I click on Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS
             
        @L2CA @UserMgmActivityUserEditAllExport @TMS-5977
        Scenario: Check User Management activity user able to Export User Edit All data
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And  I am on User listing Page
              And I click on Bulk edit of BulkEditOfUsers
              And I select all data option
              And I click on download excel file for BulkEditOfUsers
              And I click on Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS

        @L2CA @UserMgmActivityuserFilterExport @TMS-5977
        Scenario: Check User Management activity user able to Export User data Filtered
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And  I am on User listing Page
              And I click on Bulk edit of BulkEditOfUsers
              And I select Filtered list option
              #And I select status
              And I enter Reporting manager
              #And I select Assigned products
              And I click on download excel file for Filtered list
              And I click on Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS
