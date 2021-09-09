@CreateRole @Staging
Feature: Create Role

        @L2 @ViewRoleCreate @L1CA
        Scenario: Verify CA is able to view Add Role option
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Role Listing Page
              And I should be able to see Add New Role option
             Then User Logout From Classic TMS

        @L1 @CreateNewRole @L1CA
        Scenario: Add New Role and assign to user
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And  Navigate to Role Listing Page
              And I click on Add New Role
              And I Fill all the data for role details
              And  I assign activities
              And  I click on done
              And role should be added
              And I should be able to assign the role to user
              And I deactivate Role
             Then User Logout From Classic TMS

        @L1 @AssignRole @L2CA
        Scenario: Assign role to user
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Role Listing Page
              And I should be allowed to assign static role to user
             Then User Logout From Classic TMS

        @L2CA @ChangeRoleStatus
        Scenario: Change role status Activate/Deactivate
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Role Listing Page
              And I change role status
             #Then Role status should be changed
             Then User Logout From Classic TMS
             
        #@L1 @EditRole -  covered in @TEST_TMS-5981 @L1 @EditRole @L2CA @id:2 @TMS-5970
       # Scenario: Edit Role
        #    Given I logged in TMS with user role "CA"
        #      And Navigate to User Listing "TMS" "TMS"
        #      And Navigate to Role Listing Page
        #      And I click on Add New Role
        #      And I Fill all the data for role details
        #      And  I assign activities
        #      And  I click on done
        #      #And role should be added
        #      And I fetch the role
        #      And I make Role update necessary changes
        #      And Role should be updated
        #      And Navigate to Audit Trail Page
        #      And I click on Role Management
        #      And I should see update record in audit trail
        #      And Navigate to Role Listing Page
        #      And I deactivate Role
        #     Then User Logout From Classic TMS


        # @L1CA @RoleManagementActivityCreateRole @TMS-5977
        # Scenario: Check role activity user is able to Add New Role and assign to user
        #     Given I logged in TMS for Specific user role "RoleManagement"
        #       And Navigate to TMS Page "TMS" "TMS"
        #       And I click on Add New Role
        #       And I Fill all the data for RoleActivity role details
        #       And  I assign all TMS Activities
        #       And  I click on done
        #       And  New role through Rolemgmact should be added
        #       And I should be able assign rolecreated through rolemgmact to the user
        #       And I deactivate NewRole
        #      Then User Logout From Classic TMS

        @L1CA @RoleManagementActivityChangeRole @TMS-5977
        Scenario: Check role activity user is able to change status of role
            Given I logged in TMS for Specific user role "RoleManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And I change role status
             #Then Role status should be changed
             Then User Logout From Classic TMS
       
