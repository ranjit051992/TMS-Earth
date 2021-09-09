@SecurityPolicy @L1
Feature: Security Policy

        @Staging @L1CA
        Scenario: Check Display Settings Page
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Security Policy Page
             When Changes Security Policy
             Then Security Policy should get updated

        @L2 @securitypolicydropdown @L2CA
        Scenario: Check Dropdown Security Settings Page
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Security Policy Page
             When Verify all the drop down values on Security Policy
             Then Security Policy should get updated
              And Security Policy Values should get changed
        
        @L2 @ErrorShownWhenDescriptionisMissing @L2CA
        Scenario: Error Message to be seen when Description is missing Security Settings Page
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Security Policy Page
             Then Security Policy Save
