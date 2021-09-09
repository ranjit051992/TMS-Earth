@REQ_TMS-5977
Feature: Breaking down company admin functionality

        @TEST_TMS-6075         @L1CA @UserManagementActivityAccess @TMS-5977 @id:1
        Scenario: Check Access of User Management Activity
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of User Management Activity
             Then User Logout From Classic TMS
              
        @TEST_TMS-6074         @L1CA @RoleManagementActivityAccess @TMS-5977 @id:2
        Scenario: Check Access of Role Management Activity
            Given I logged in TMS for Specific user role "RoleManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of Role Management Activity
             Then User Logout From Classic TMS

        @TEST_TMS-6073         @L1CA @AuditPageActivityAccess @TMS-5977 @id:3
        Scenario: Check Access of Audit Activity
            Given I logged in TMS for Specific user role "AuditManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of Audit Management Activity
              And I click on Users
              And I click on UserGroup
              And I click on Role Management
              And I click on Settings
             Then User Logout From Classic TMS

        @TEST_TMS-6071         @L1CA @PreferencesActivityAccess @TMS-5977 @id:4
        Scenario: Check Access of Preferences Activity
            Given I logged in TMS for Specific user role "Preferences"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of Preferences Activity
             Then User Logout From Classic TMS

        @TEST_TMS-6080         @L1CA @ReportsActivityAccess @TMS-5977 @id:5
        Scenario: Check Access of Reports Activity
            Given I logged in TMS for Specific user role "Reports"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of Reports Activity
             Then User Logout From Classic TMS

        # @TEST_TMS-6078         @L1CA @WorkflowActivityAccess @TMS-5977 @id:6
        # Scenario: Check Access of Workflow Activity
        #     Given I logged in TMS for Specific user role "Workflow"
        #       And Navigate to TMS Page "TMS" "TMS"
        #      Then Check Access of Workflow Activity
             
        @TEST_TMS-6076         @MasterDataActivityAccess @TMS-5977 @id:7
        Scenario: Check Access of Master Data Activity
            Given I logged in TMS for Specific user role "MasterData"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of Master Data Activity
             Then User Logout From Classic TMS

        @TEST_TMS-6077         @L1CA @UserandRoleActivityAccess @TMS-5977 @id:8
        Scenario: Check Access of User and Role Activity
            Given I logged in TMS for Specific user role "UserandRole"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of User and Role Activity
             Then User Logout From Classic TMS

        @TEST_TMS-6072         @L1CA @UserManagementActivityFunctionality @TMS-5977 @id:9
        Scenario: Check All Functionality of User Management Activity working properly
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And Check Access of Create User Group
             Then User Logout From Classic TMS

        @TEST_TMS-6079         @L1CA @UserMgmActivityEmailEditExport @TMS-5977 @id:10
        Scenario: Check User Mgm Activity Email Edit Export
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And I click on User Email Edit Export User data
              And I click on Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS

        @TEST_TMS-6111         @L2CA @RoleManagementActivityDynamicExport @TMS-5977 @id:11
        Scenario: Role page activity is able to export dynamic role sheet
            Given I logged in TMS for Specific user role "RoleManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And I should be able to see Add New Role option
              And I click on Assign roles in bulk option link
              And I click on Download Dynamic Excel Template
              And Popup should be seen
             Then User Logout From Classic TMS

        @TEST_TMS-6115         @L1CA @RoleManagementActivityCSVExport @TMS-5977 @id:12
        Scenario: Role page activity is able to export assignment and edit role sheet
            Given I logged in TMS for Specific user role "RoleManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And I should be able to see Add New Role option
              And I click on Assign roles in bulk option link
              And I click on Download Assignment & Edit Role Sheet
              And Popup should be seen
             Then User Logout From Classic TMS
         
        @TEST_TMS-6118         @L1CA @UserGroupActivityaddUG @TMS-5977 @id:13
        Scenario: Check User Group Activity user able to add New UserGroup
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And  Navigate to UserGroup Page
              And I click on Add New UserGroup
              And I enter all the required data
              And I click on CreateNewGroup
              And UserGroup should be created
             Then User Logout From Classic TMS

        @TEST_TMS-6123         @L2CA @UserGroupActivityModifyUG @TMS-5977 @id:14
        Scenario: Check User Group Activity user able to modify UserGroup
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And  Navigate to UserGroup Page
              And I click on Actions
              And I click on Modify
              And I can click on View Selected link
              And I should be able to see users in the UserGroup
             Then User Logout From Classic TMS

        @TEST_TMS-6117         @L1CA @ReportsActivityaccessRep1 @TMS-5977 @id:15
        Scenario: Check Reports Activity user is able to access Report - Rep1
            Given I logged in TMS for Specific user role "Reports"
              And Navigate to TMS Page "TMS" "TMS"
              And I navigate to Reports tab
              And I select-List of users grouped by role name and role type per product
              And I should see List of users grouped by role name and role type per product in TMS report
              And I close report
             Then User Logout From Classic TMS


        @TEST_TMS-6110         @L2CA @ReportsActivityExportExcel @TMS-5977 @id:16
        Scenario: Check Reports Activity user is able to Export Report in Excel
            Given I logged in TMS for Specific user role "Reports"
              And Navigate to TMS Page "TMS" "TMS"
              And I navigate to Reports tab
              And I select-Matrix report detailing number of users in a role per product in TMS Report option
              And I should see Matrix report detailing number of users in a role per product report
              And I Able to export Report in Excel
              And I close report
             Then User Logout From Classic TMS

        @TEST_TMS-6116         @L2CA @ReportsActivityExportPDF @TMS-5977 @id:17
        Scenario: Check Reports Activity user is able to Export Report in PDF
            Given I logged in TMS for Specific user role "Reports"
              And Navigate to TMS Page "TMS" "TMS"
              And I navigate to Reports tab
              And I select-Matrix report detailing number of users in a role per product in TMS Report option
              And I should see Matrix report detailing number of users in a role per product report
              And I Able to export Report in PDF
              And I close report
             Then User Logout From Classic TMS

        @TEST_TMS-6113         @L2CA @PreferencesActivitySecuritychange @TMS-5977 @id:18
        Scenario: Check Preference Activity user able to change Security Settings
            Given I logged in TMS for Specific user role "Preferences"
              And Navigate to TMS Page "TMS" "TMS"
              And Changes Security Policy
              And Security Policy should get updated
             Then User Logout From Classic TMS

        @TEST_TMS-6119         @L1CA @PreferencesActivityDiplaychange @TMS-5977 @id:19
        Scenario: Check Preference Activity user able to change Display Settings
            Given I logged in TMS for Specific user role "Preferences"
              And Navigate to TMS Page "TMS" "TMS"
              And Navigate to Display Settings
              #And Upload New logo - Removed form Classic TMS
              And Changes Company Preferences
              And Display Settings should get updated
             Then User Logout From Classic TMS

        @TEST_TMS-6120         @L1CA @UserManagementActivityDeactivateUser @TMS-5977 @id:20
        Scenario: Check User Management Activity user able to Deactivate user
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And Deactivate User with user mgm activity
              And User should get deactivate
             Then User Logout From Classic TMS

        @TEST_TMS-6112         @L1CA @UserManagementActivityActivateUser @TMS-5977 @id:21
        Scenario: Check User Management Activity user able to Activate user
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And Activate User with user mgm activity
              And User should get activate
             Then User Logout From Classic TMS

        @TEST_TMS-6122         @L1CA @UserManagementActivityResetPassword @TMS-5977 @id:22
        Scenario: Check User Management Activity user able to Reset Password
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And Reset UserPassword with user mgm activity
              And Verify User Password
             #Then User Logout From Classic TMS


        @TEST_TMS-6121         @L2CA @UserManagementActivityEditEmail @TMS-5977 @id:23
        Scenario: Check User Management Activity user able to Edit Email Address
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And I Edited the Email Address
              And Verify the Edited Email address
             Then User Logout From Classic TMS

        @TEST_TMS-6114         @L1CA @UserMgmActivityUploadBlankUserExport @TMS-5977 @id:24
        Scenario: Check User Management activity user able to UploadUsers Download Excel Template
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And I click on Upload Users link
              And I click on Download Excel Template link for UploadUsers
              And I click on Bell icon
              And I should see the export user data under bell icon
             Then User Logout From Classic TMS


              