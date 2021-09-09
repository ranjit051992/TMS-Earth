@AuditExport @L2CA
Feature: Audit Trail Export

        @UserAuditExport
        Scenario: User Audit Trail Export Data
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Audit Trail Page
             # And I click on Users
              And I click on AuditExport
              And I click on Audit Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS
             
        @UserAuditGroupExport
        Scenario: User Group Audit Trail Export Data
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Audit Trail Page
              And I click on UserGroup
              And I click on AuditExport
              And I click on Audit Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS

        @UserAuditRoleExport
        Scenario: Role Audit Trail Export Data
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Audit Trail Page
              And I click on Role Management
              And I click on AuditExport
              And I click on Audit Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS

        @UserAuditSettingExport
        Scenario: Settings Audit Trail Export Data
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Audit Trail Page
              And I click on Settings
              And I click on AuditExport
              And I click on Audit Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS