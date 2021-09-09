@REQ_TMS-5970 @CreateRole @Staging
Feature: Role edit: submit to view

        @TEST_TMS-5981 @EditRole @L2CA @TMS-5970 @id:1
        Scenario: Edit Role
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Role Listing Page
              And I click on Add New Role
              And I Fill all the data for role details
              And  I assign activities
              And  I click on done
              #And role should be added
              And I fetch the role
              And I make Role update necessary changes
              And Role should be updated
              And Navigate to Audit Trail Page
              And I click on Role Management
              And I should see update record in audit trail
              And Navigate to Role Listing Page
              And I deactivate Role
             Then User Logout From Classic TMS

        # @TEST_TMS-5982 @CreateNewRole @TMS-5970 @id:2 @L2CA Covered in @L2 @AuditUpdateRole @L2CA on Audit trail page
        # Scenario: Add New Role and assign to user
        #     Given I logged in TMS with user role "CA"
        #       And Navigate to User Listing "TMS" "TMS"
        #       And  Navigate to Role Listing Page
        #       And I click on Add New Role
        #       And I Fill all the data for role details
        #       And  I assign activities
        #       And  I click on done
        #       And role should be added
        #       And I should be able to assign the role to user
        #       And I deactivate Role
        #      Then User Logout From Classic TMS