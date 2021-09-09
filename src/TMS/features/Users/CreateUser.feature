@User @Staging
Feature: User Page

        @L1 @L1CA
        @CreateandUpdateUser
        Scenario: Create User
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And User on Create User Page
              And I Fill all the data and Create User 1
              And I Fill all the data and Create User 2
              And I Fill all the data and Create User 3
              And I Fill all the data and Create User 4
              And I Fill all the data and Create User 5
              And Define User
              And Popup should be seen
              And User is shown on User Listing Page
              And Verify Data intrgration of Create User 1
              And Verify Data intrgration of Create User 2
              And Verify Data intrgration of Create User 3
              And Verify Data intrgration of Create User 4
              And Verify Data intrgration of Create User 5
       # @EditUser @L1 @Staging @L1CA @21dec20
       # Scenario: Edit User Basic Details
        #    Given I logged in TMS with user role "CA"
         #     And Navigate to User Listing "TMS" "TMS"
              And User is shown on User Listing Page
              And UpdateUser Basic Details1
              And UpdateUser Basic Details2
              And UpdateUser Basic Details3
              And UpdateUser Basic Details4
              And UpdateUser Basic Details5
              And Update User
              And Popup should be seen
              And User is shown on User Listing Page
              #And User is shown on User Listing Page
              And Verify Update user details1
              And Verify Update user details2
              And Verify Update user details3
              And Verify Update user details4
              And Verify Update user details5
             Then Mark User Inactive

        @DeactivateUser @L1 @L1CA
        Scenario: Check User Deactivate Scenario
            Given   I logged in TMS with user role "CA"
              And  Navigate to User Listing "TMS" "TMS"
              And I deactivate User
             Then User should get deactivate

        @ActivateUser @L1 @L1CA
        Scenario: Check User Activate Scenario
            Given   I logged in TMS with user role "CA"
              And  Navigate to User Listing "TMS" "TMS"
              And I activate User
             Then User should get activate
           # Then Activation Email should get trigger to User

        @ResetUserPassword @L1 @L2CA @ranjit006
        Scenario: Check User Password Reset
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And Reset User Password
             Then Verify User Password

        @UserEditEmailAddress @L1CA
        Scenario: Edit Email Address
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And I Edited the Email Address
             Then Verify the Edited Email address

        @CopyUser @L1 @L2CA
        Scenario: Copy User
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And I click on CopyUser
              And I enter the details
              And I click on submit button
              And New User should be created
              And Mark User Inactive
             Then User Logout From Classic TMS


        @L2CA @UserManagementActivityCreateUser @TMS-5977
        Scenario: Check User Management Activity user able to Create and Update User
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And User on Create User Page
              And I Fill all the data and Create User 1
              And I Fill all the data and Create User 2
              And I Fill all the data and Create User 3
              And I Fill all the data and Create User 4
              And I Fill all the data and Create User 5
              And Define User
              And Popup should be seen
              And User is shown on User Listing Page
              And UpdateUser Basic Details of user
              And Update User
              And Popup should be seen
             Then User Logout From Classic TMS

        @L2CA @UserManagementActivityCopyUser @TMS-5977
        Scenario: Check User Management Activity user able to Copy User
            Given I logged in TMS for Specific user role "UserManagement"
              And Navigate to TMS Page "TMS" "TMS"
              And I click on CopyUser
              And I enter the details
              And I click on submit button
              And New User should be created
              And Mark User Inactive
             Then User Logout From Classic TMS


        