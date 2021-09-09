@UserProfileUpdate @Staging @L2CA
Feature: User Profile in Classic

        @ViewUserProfilePage @L1
        Scenario: View User Profile Page
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And Navigate to User Profile Page
             Then User Lands on User Profile Page

        @UpdateUserProfilePage @L1
        Scenario: Update User Profile Page
            Given   I logged in TMS with user role "CA"
              And   Navigate to User Listing "TMS" "TMS"
              And Navigate to User Profile Page
              And User Lands on User Profile Page
              And Update User Details On profile
             Then User Profile data Should be saved