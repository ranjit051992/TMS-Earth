@MEP @Staging @L2CA
Feature: Manage Email Preference- User Level
        
      #   Background: Given I am logged on to the application and TMS Page
      #       Given   Login as Company Admin
      #         And   Navigate to User Listing "TMS" "TMS"

              
        # @L1
        # Scenario: Check Company admin is able to Manage Email Preference
        #     Given  I navigate to Master tab
        #       And I select Customize
        #       And I select Email Notification
        #       And I select Delivery Notification
        #       And I make necessary changes
        #       And I click on Save Button
              
        @Check @L1
        Scenario: LA
            Given I logged in TMS with user role "CA"
              And Navigate to User Listing "TMS" "TMS"
              And I click on Userlevel MEP
              And I navigate to eProc Settings and make necessary changes
              #And I check whether setting is reflected
            #  Then changes should be saved
              #And User Logout From Classic TMS
              #And Dewdrop Logout

            
        # Scenario: CA
        #       And Login as Company Admin
        #       And Navigate to User Listing "TMS" "TMS"
        #       And I navigate to Master tab after Logging
        #       And I select Customize
        #       And I select Email Notification
        #       And I select Delivery Notification
        #       And I make necessary changes
        #       And I click on Save Button

              
              