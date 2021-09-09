@ExceptioCase
Feature: DSSO Irequest  link Issue

        @OktaiRequestLoginSuccess @DSSO
        Scenario: DSSOLoginSuccess
             When User hits DSSO Octa Irequest link
              And User Redirect to okta Login Page
              And Login thorugh Octa creds "OctaIrequestUser"
             # And Login thorugh okta "admin.zcssp@zycus.com","Pass@12345" creds
             Then Dewdrop Login Successful
              And Dewdrop Logout


        @ADFSiRequestLoginSuccess @DSSO
        Scenario: DSSOLoginSuccess
             When User hits DSSO ADFS Irequest link
              And User Redirect to ADFS Login Page
              And Login thorugh ADFS creds "ADFSIrequestUser"
             # And Login thorugh ADFS "ankit.pandey@zycus.com","pass@222" creds
             Then Dewdrop Login Successful
              And Dewdrop Logout

     #   @ADFSPurelyIDPLoginSuccess only for US PROD
      #  Scenario: DSSOLoginSuccess
       #      When User hits "https://adfs.zycus.com/adfs/ls/IdpInitiatedSignOn.aspx?LogintoRP=https://zauth-admin.zycus.com/auth/realms/ZycusRealm" DSSO Link
     #      When User hits PurelyIDP link
        #      And User Redirect to ADFS Login Page
         #     And Login thorugh ADFS "ankit.pandey@zycus.com","pass@222" creds
           #   And Login thorugh ADFS creds "ADFSIrequestUser"
          #   Then Dewdrop Login Successful

      #  @ADFS1iRequestLoginSuccess only for SG PROD
       # Scenario: DSSOLoginSuccess
        #     When User hits ADFS1iRequestLoginSuccess DSSO Link
         #     And User Redirect to ADFS Login Page
          #    And Login thorugh ADFS "ankit.pandey@zycus.com","pass@222" creds
           #   And Login thorugh ADFS creds "ADFSIrequestUser"
            # Then Dewdrop Login Successful
             # And Dewdrop Logout
        