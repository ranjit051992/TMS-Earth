@ZAViewAuditTrail
Feature: View Audit Trail for ZA

    #     @L1ZA @CompanyAuditPageAccess
    #     Scenario: Company Audit Trail page viewable for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to ZA Audit Trail Page
    #           And Company AuditTrail page should be accessible
    #          Then User Logout From Classic TMS

    #     @L1ZA @CompanyCreateAudit
    #     Scenario: Craete Company Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And User on Create Company Page
    #           And I Fill Basic Information
    #           And I Fill Component Selection & Product Allocation
    #           And I Fill Company Admin Details
    #           And I Fill Preferences
    #           And Define Company
    #           And Company Creation Success Popup should be seen
    #           And Company is shown on Company Listing Page
    #           And Navigate to ZA Audit Trail Page
    #           And Check Audit of Company created by ZA
    #          Then User Logout From Classic TMS

    #     @L1ZA @CompanyUpdateAudit
    #     Scenario: Update Company Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Go to the Edit Company Summary Page
    #           And Update I Fill UpdateComponent Selection & Product Allocation
    #           And Update Company
    #           And Company Creation Success Popup should be seen
    #           And Navigate to ZA Audit Trail Page
    #           And Check Audit of Upadte Company by ZA
    #          Then User Logout From Classic TMS

    #     @L1ZA @CompanyActivateAudit
    #     Scenario: Company Activate Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And I activate Company
    #           And Company should get activate
    #           And Navigate to ZA Audit Trail Page
    #           And Check Audit of Activate Company by ZA
    #          Then User Logout From Classic TMS

    #     @L1ZA @CompanyDeActivateAudit
    #     Scenario: Company DeActivate Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And I deactivate Company
    #           And Company should get deactivate
    #           And Navigate to ZA Audit Trail Page
    #           And Check Audit of DeActivate Company by ZA
    #          Then User Logout From Classic TMS



    #     @L1ZA @ActivityPageAccess
    #     Scenario: Activity Audit Trail page viewable for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to ZA Audit Trail Page
    #           And Activity AuditTrail page should be accessible
    #          Then User Logout From Classic TMS

    #     @L1ZA @ActivityCreateAudit
    #     Scenario: Create Activity Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to Product Tab
    #           And Navigate to Create Activity page
    #           And Create Activity
    #           And Navigate to ZA Audit Trail Page
    #           And Activity AuditTrail page should be accessible
    #           And Check Audit of Activity created by ZA
    #          Then User Logout From Classic TMS

    #     @L1ZA @ActivityUpdateAudit
    #     Scenario: Update Activity Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to Product Tab
    #           And Navigate to Create Activity page
    #           And Update Activity
    #           And Navigate to ZA Audit Trail Page
    #           And Activity AuditTrail page should be accessible
    #           And Check Audit of update Activity by ZA
    #          Then User Logout From Classic TMS
              

    #     @L1ZA @ActivityGroupPageAccess
    #     Scenario: Activity Group page accessible for for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to ZA Audit Trail Page
    #           And Activity Group Audit trail page should be accessible
    #          Then User Logout From Classic TMS

    #     @L1ZA @ActivityGroupCreateAudit
    #     Scenario: Create Activity Group Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to Product Tab
    #           And Navigate to Create Activity page
    #           And I add new Activity group
    #           And Navigate to ZA Audit Trail Page
    #           And Activity Group Audit trail page should be accessible
    #           And Check audit of ActivityGroup Created
    #          Then User Logout From Classic TMS

             
    #     @L1ZA @ActivityGroupUpdateAudit
    #     Scenario: Check Audit of Update Activity Group Name for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to Product Tab
    #           And Navigate to Create Activity page
    #           And UpdateActivity Group Name
    #           And Navigate to ZA Audit Trail Page
    #           And Activity Group Audit trail page should be accessible
    #           And Check audit of ActivityGroup Updated
    #          Then User Logout From Classic TMS


    #     @L1ZA @ProductAuditPageAcces
    #     Scenario: Check Product Audit page is accessible for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to ZA Audit Trail Page
    #           And Product audit page is accessible
    #          Then User Logout From Classic TMS

    #     @L1ZA @ProductCreateAudit
    #     Scenario: Check Create Product Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And I navigate to Products tab
    #           And I click on Add new Product
    #           And I fill all Product Information
    #           And I click on Save
    #           And I add newActivitygroup
    #           And I add Activity
    #           And I click on Done
    #           And I click on Done at the summary page
    #           And Navigate to ZA Audit Trail Page
    #           And Product audit page is accessible
    #           And Create Product should get Audited by ZA
    #          Then User Logout From Classic TMS

    #     @L1ZA @ProductUpdateAudit
    #     Scenario: Check Update Product Audited for Zycus Admin
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And I navigate to Products tab
    #           And I edit the product Created
    #           And Navigate to ZA Audit Trail Page
    #           And Product audit page is accessible
    #           And UpdateProduct should get Audited
    #          Then User Logout From Classic TMS


    #     @L1ZA @ZARoleAudit
    #     Scenario: Role Audit page accessible for ZA
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to ZA Audit Trail Page
    #           And ZA roleaudit page is accessible
    #          Then User Logout From Classic TMS

    #     @L1ZA @ZARoleAuditCreate
    #     Scenario: Cearte Role Audited for ZA
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to Role Listing Page
    #           And I click on Add New Role
    #           And I Fill all the data for role details
    #           And I assign activities
    #           And I click on done
    #           And Navigate to ZA Audit Trail Page
    #           And ZA roleaudit page is accessible
    #           And I should see records performed by Zycusadmin for Role
    #          Then User Logout From Classic TMS

    #    # @L1ZA @ZARoleAuditUpdate
    #     #Scenario: Update Role Audited for ZA
    #      #   Given I logged in TMS with user role "ZA"
    #       #   Then Navigate to Company Listing
    #        #   And Navigate to Role Listing Page
    #         #  And I fetch the role
    #            #And I edited the Role
    #         #  And I make necessary changes for ZA Role
    #          # And Role should be updated for ZA
    #          # And Navigate to ZA Audit Trail Page
    #          # And ZA roleaudit page is accessible
    #          # And I should see records performed by Zycusadmin for Role
    #          #Then User Logout From Classic TMS

    #     @L1ZA @ZARoleAuditDeActivte
    #     Scenario: ZA Role Deactivate Check
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to Role Listing Page
    #           And ZA level role deactivation
    #          # And Role should be deactivated ZA level
    #           And Navigate to ZA Audit Trail Page
    #           And ZA roleaudit page is accessible
    #           And I should see records performed by Zycusadmin for Deactivate Role
    #          Then User Logout From Classic TMS

    #     @L1ZA @ZARoleAuditActivte
    #     Scenario: ZA Role activate Check
    #         Given I logged in TMS with user role "ZA"
    #          Then Navigate to Company Listing
    #           And Navigate to Role Listing Page
    #           And I activate static Role ZA level
    #         #  And Role should be activated ZA level
    #           And Navigate to ZA Audit Trail Page
    #           And ZA roleaudit page is accessible
    #           And I should see records performed by Zycusadmin for Activate Role
    #          Then User Logout From Classic TMS