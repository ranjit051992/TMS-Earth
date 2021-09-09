@Users @L2 @L2CA
Feature: User L2 Page

        @UserAddPage1
        Scenario: Verify CA Able to fill add User Page 1 data
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And User on Create User Page
              And User able to fill data on page 1
             Then Data should be seen on page 1

        @MasterDataonPage1
        Scenario: Verify CA Able to fill add User Page 1 Master data
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And User on Create User Page
              And User able to fill Master Data
             Then Master data should be seen on page 1

        @MandatoryCheckonPage1
        Scenario: Verify Error should be seen for Mandatory Field
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And User on Create User Page
              And Try to Navigate to Page 2
             Then Proper Error should be seen on page 1

        # @Productcheck
        # Scenario: Verify All Company Product should be seen on Product assignment page to User
        #     Given User on Create User Page
        #      When I Fill all the data and Create User 1
        #      Then All product should be seen

        # @ProductAssignAndunassign
        # Scenario: Verify All Company Product should be seen on Product assignment page to User
        #     Given User on Create User Page
        #      When I Fill all the data and Create User 1
        #      Then Product Should get assign and unassigned

        @Proceedtostep3Users
        Scenario: User Procced to step 3 - role page
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And User on Create User Page
              And I Fill all the data for role page check on Create User 1
              And I Fill all the data and Create User 2
             Then User lands on step 3 page role page

        # @AllProductRoletobeseen
        # Scenario: All Role to be seen on step 3
        #     Given User on Create User Page
        #      When I Fill all the data and Create User 1
        #      When I Fill all the data and Create User 2
        #      Then Role should be seen for all product

        # @RoleAssignAndunassign
        # Scenario: Verify All Company Product should be seen on Product assignment page to User
        #     Given User on Create User Page
        #      When I Fill all the data and Create User 1
        #      When I Fill all the data and Create User 2
        #      Then Role should be assigned or unassigned

        @ErrorShownSameScopetypeassigned
        Scenario: Verify All Scope Available seen to User
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And User on Create User Page
              And I Fill all the data for scope page check on Create User 1
              And I Fill all the data and Create User 2
              And I Fill all the data and Create User 3
             Then Error should be shown Multiple same scope type is assigned

        # @ScopeAssignmenttoUsers
        # Scenario: Verify All Scope Available seen to User
        #     Given User on Create User Page
        #      When I Fill all the data and Create User 1
        #       And I Fill all the data and Create User 2
        #       And I Fill all the data and Create User 3
        #      Then Assign Multiple Scope to Users