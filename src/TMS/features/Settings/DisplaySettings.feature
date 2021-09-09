
@DisplaySettings @L1
Feature: Display Settings

        @DisplaySettings @L1 @Staging @L1CA
        Scenario: Check Display Settings Page
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Display Settings
              # And Upload New logo - Removed from Classic TMS
              And Changes Company Preferences
             Then Display Settings should get updated

        # @L2 @ResetZycusLogo @L2CA - Removed from Classic TMS
        # Scenario: ResetZycusLogo
        #     Given I logged in TMS with user role "CA"
        #       And Navigate to User Listing "TMS" "TMS"
        #       And Navigate to Display Settings
        #       And Upload New logo
        #       And Changes Company Preferences
        #       And Display Settings should get updated
        #       And I click on Reset Logo button
        #       And I confirm for resetting the logo
        #      Then zycus logo should be reset
             
        # @L2 @UploadCustomLogo @L2CA - Removed from Classic TMS
        # Scenario: Check Display Settings Page
        #     Given I logged in TMS with user role "CA"
        #       And Navigate to User Listing "TMS" "TMS"
        #       And Navigate to Display Settings
        #      When Upload New logo
        #       And Display Settings should get updated

        # @L2 @UploadZycusLogo @L2CA - Removed from Classic TMS
        # Scenario: Check Display Settings Page
        #     Given I logged in TMS with user role "CA"
        #       And Navigate to User Listing "TMS" "TMS"
        #       And Navigate to Display Settings
        #       And Reset Zycus logo
        #      Then Display Settings should get updated
