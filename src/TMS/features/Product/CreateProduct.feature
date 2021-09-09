@ProdTab
Feature: Create New Product

        @CreateProd @L1
        Scenario: Creation of new product
            Given I logged in TMS with user role "ZA"
              And   Navigate to Company Listing
              And Navigate to Product Tab
              And I click on Add new Product
              And I fill all Product Information
              And I click on Save
              And I add new Activity group
              And I add Activity
              And I click on Done
              And I click on Done at the summary page
              And product should be able to be assigned to company
             Then User Logout From Classic TMS

     #    @EditProd @L1
     #    Scenario: Updating product
     #         When Navigate to Product Tab
     #    # /*      And I click on Add new Product
     #    #       And I fill all Product Information
     #    #       And I click on Save
     #    #       And I add new Activity group
     #    #       And I add Activity
     #    #       And I click on Done
     #    #       And I click on Done at the summary page
     #    # */
     #          And I edit the product Created
     #         Then changes should be reflected

