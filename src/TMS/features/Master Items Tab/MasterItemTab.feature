@MasterItemsTab @L1CA @Staging
Feature: View Master and Items Tab

        @ViewMasterTab @L0CA @L1CA
        Scenario: Master Data view for Company Admin
            Given I logged in TMS with user role "CA"
             Then Navigate to User Listing "TMS" "TMS"
              And Navigate to Master Data Tab
             Then Master Data page should be accessible

      #  @ViewItemsTab @L1 @Staging @L1CA
      #  Scenario: Items Data view for Company Admin
      #      Given I logged in TMS with user role "CA"
      #       Then Navigate to User Listing "TMS" "TMS"
      #       When Navigate to Items Data Tab
      #       Then Items Data page should be accessible

        # @WorkFlowTab
        # Scenario: WorkFlow Tab view for Company Admin
        #     Given I logged in TMS with user role "CA"
        #      Then Navigate to User Listing "TMS" "TMS"
        #       And Navigate to Workflow Tab
        #      Then Workflow page should be accessible
