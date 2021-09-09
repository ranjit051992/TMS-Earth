@ViewAuditTrail
Feature: View Audit Trail

        @ViewUserAudit @ViewAllAuditPage @L0 @L0CA @L1CA
        Scenario: Audit Trail view for Company Admin - Users
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Audit Trail Page
              And I click on Users
             Then Users AuditTrail page should be accessible
             Then User Logout From Classic TMS

        @ViewUGAudit @ViewAllAuditPage @L1 @L1CA
        Scenario: Audit Trail view for Company Admin - UserGroup
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Audit Trail Page
              And I click on UserGroup
              And UserGroup AuditTrail page should be accessible
             Then User Logout From Classic TMS

        @ViewRoleAudit @ViewAllAuditPage @L1 @L1CA
        Scenario: Audit Trail view for Company Admin - Role Mgmt
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Audit Trail Page
              And I click on Role Management
              And Role AuditTrail page should be accessible
             Then User Logout From Classic TMS
 
        @ViewSettingsAudit @ViewAllAuditPage @L1 @L1CA
        Scenario: Audit Trail view for Company Admin - Settings
            Given I logged in TMS with user role "CA"
             Then Navigate to User Listing "TMS" "TMS"
              And Navigate to Audit Trail Page
              And I click on Settings
              And Settings AuditTrail page should be accessible
             Then User Logout From Classic TMS
          
      #Audit Trail for Admin Activities.

        @ViewAdminActUser @L1 @L1CA
        Scenario: Audit Trail view of Zycus Admin - Users
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Audit Trail Page
              And I click on Users
              And I search for Admin activity-Users
              And I should see records performed by Zycus admin for Role
             Then User Logout From Classic TMS
             
        @ViewAdminActUG
        Scenario: Audit Trail view of Zycus Admin - UserGroup
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Audit Trail Page
              And I click on UserGroup
              And I search for Admin activity-UserGroup
              And I should see records performed for UG by Zycus admin
             Then User Logout From Classic TMS
        
        @ViewAdminActRole
        Scenario: Audit Trail view of Zycus Admin - Role Mgmt
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Audit Trail Page
              And I click on Role Management
              And I search for Admin activity-Role
              And I should see records performed by Zycus admin for Role
             Then User Logout From Classic TMS
 
        # @ViewAdminActSet @L1
        # Scenario: Audit Trail view of Zycus Admin- Settings
        #     Given  Navigate to Audit Trail Page
        #       And I click on Settings
        #       And I search for Admin activity-Settings
        #      Then I should see records performed by Zycus admin for Settings
        

        @AuditDeactivateUser @L2 @L2CA
        Scenario: Check User Deactivate Scenario
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And I deactivate User
              And User should get deactivate
              And  Navigate to Audit Trail Page
              And I click on Users
              #And Users AuditTrail page should be accessible
            #  And I select DeactivateUser option in audit page
              And deactivated record should be visible in audit
             Then User Logout From Classic TMS

        @AuditActivateUser @L2 @L2CA
        Scenario: Check User Activate Scenario
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And I activate User
              And User should get activate
              And  Navigate to Audit Trail Page
              And I click on Users
              #And Users AuditTrail page should be accessible
              #And I select ActivateUser option in audit page
              And Activated record should be visible in audit
             Then User Logout From Classic TMS

        @AuditResetUserPassword  @L2CA
        Scenario: Check User Password Reset
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And Reset User Password
              And Verify User Password
              And  Navigate to Audit Trail Page
              And I click on Users
              And Users AuditTrail page should be accessible
              #And I select ResetUserPassword option in audit page
              And ResetUserPassword record should be visible in audit
             Then User Logout From Classic TMS
             
      #  @AuditUpdateUser @L1
       # Scenario: Edit User Basic Details
        #    Given I logged in TMS with user role "CA"
         #    Then   Navigate to User Listing "TMS" "TMS"
          #    And Go to the Edit User Summary Page
           #   And Update User Basic Details
            #  And Update User
            #  And Popup should be seen
            #  And Navigate to Audit Trail Page
            #  And I click on Users
            #  And I select user updated option for audit
            #  And I should see records of user updated in audit
            # Then User Logout From Classic TMS


        @L2 @AuditRoleCreated @L2CA
        Scenario: Verify CA is able to view Add Role option
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to Role Listing Page
              And I click on Add New Role
              And I Fill all the data for role details
              And  I assign activities
              And  I click on done
              And role should be added
              And  Navigate to Audit Trail Page
              And I click on Role Management
              And Role AuditTrail page should be accessible
              And I should see role created in role audit page
             Then User Logout From Classic TMS

        #@L2 @AuditUpdateRole @L2CA  ---------------  Covered in @TEST_TMS-5981 @L1 @EditRole @L2CA @id:2 @TMS-5970
        #Scenario: Verify update role audit
        #    Given I logged in TMS with user role "CA"
        #     Then   Navigate to User Listing "TMS" "TMS"
        #      And Navigate to Role Listing Page
        #      And I fetch the role
        #      And I make necessary changes
        #      And Role should be updated
        #      And Navigate to Audit Trail Page
        #      And I click on Role Management
              #And I select Role updated option
        #     Then I should see update record in audit trail
          #    Then User Logout From Classic TMS
       
        # @L2 @AuditActivateRole
        # Scenario: Audit Activate role
        #     Given  Navigate to Role Listing Page
        #       And I activate static Role
        #       And Role should be activated
        #       And Navigate to Audit Trail Page
        #       And I click on Role Management
        #       And I select Role Activated option in audit trail
        #      Then I should get the record for activation

     #    @AuditDeactivateRole @L2CA
     #    Scenario: Audit Deactivate role
     #        Given  Navigate to Role Listing Page
     #          And I deactivate static Role
     #          And Role should be deactivated
     #          And Navigate to Audit Trail Page
     #          And I click on Role Management
     #          And I select Role Deactivated option in audit trail
     #         Then I should get the record for deactivation
     #         Then User Logout From Classic TMS

             
      #  @AuditUGCreated @L2 @L2CA   -------   IT IS COVERED IN USERGROUP CREATE SCENARIO IN @addUG
      #  Scenario: Audit Trail view for UserGroup created
      #      Given I logged in TMS with user role "CA"
      #       Then   Navigate to User Listing "TMS" "TMS"
      #        And  Navigate to Audit Trail Page
      #        And I click on UserGroup
      #        #And UserGroup AuditTrail page should be accessible
      #        And I should see the Usergroup that was created
      #       Then User Logout From Classic TMS

        @AuditUpdateUG @L2 @L2CA
        Scenario: Audit Trail view for UserGroup updated
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And  Navigate to UserGroup Page
              And I click on Actions
              And I click on Modify
              And I change the usergroup description
              And I update the usergroup
          #     And Usergroup should be updated
              And  Navigate to Audit Trail Page
              And I click on UserGroup
              #And I select Usergroup updated filter
             Then I should see the Usergroup that was updated
             Then User Logout From Classic TMS

        @L2 @AuditDisplaySetting @L2CA
        Scenario: Check Display Settings Page
            Given I logged in TMS with user role "CA"
             Then   Navigate to User Listing "TMS" "TMS"
              And Navigate to Display Settings
            #   And Upload New logo
              And Changes Company Preferences
              And Display Settings should get updated
              And  Navigate to Audit Trail Page
              And I click on Settings
              And Settings AuditTrail page should be accessible
              #And I select Logo updated option in audit trail
            #   And Settings should be reflected in AuditTrail page
             Then User Logout From Classic TMS

        # @L2 @AuditResetZycusLogo @L2CA - Logo upload removed from Classic TMS
        # Scenario: ResetZycusLogo
        #     Given I logged in TMS with user role "CA"
        #      Then   Navigate to User Listing "TMS" "TMS"
        #       And Navigate to Display Settings
        #       And Upload New logo
        #       And Changes Company Preferences
        #       And Display Settings should get updated
        #       And I click on Reset Logo button
        #       And I confirm for resetting the logo
        #       And zycus logo should be reset
        #       And  Navigate to Audit Trail Page
        #       And I click on Settings
        #       And Settings AuditTrail page should be accessible
        #       #And I select logo reset option of audit
        #       And logo reset record should be there in audit
        #      Then User Logout From Classic TMS
