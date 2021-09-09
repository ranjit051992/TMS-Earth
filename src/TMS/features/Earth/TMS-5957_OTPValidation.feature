@REQ_TMS-5957
Feature: 2 factor authentication for non DSSO user

        @TEST_TMS-5984         @SSOOTPThroughLogin @id:1 @TMS-5957
        Scenario: Check Login through OTP for SSO
            Given I logged in SSO TMS with OTP enabled User
              And Verify the OTP of the user
             Then Dewdrop Logout
             
        @TEST_TMS-6069         @DSSOOTPThroughLogin @id:2 @TMS-5957
        Scenario: Check Login through OTP for DSSO user who has Login Through Zycus Portal flag Yes
            Given I logged in DSSO TMS with OTP enabled User
              And Verify the OTP of the user
             Then Dewdrop Logout

        @TEST_TMS-6067         @SSOInavlidOTP @id:3 @TMS-5957
        Scenario: Check Login through OTP Invalid for SSO
            Given I logged in SSO TMS with OTP enabled User
             Then Check by entering invalid OTP

        @TEST_TMS-6070         @SSOResendOTPoption @id:4 @TMS-5957
        Scenario: Check Resend OTP option functionality for SSO
            Given I logged in SSO TMS with OTP enabled User
              And Check with Resend OTP option
              And Verify the OTP of the user
             Then Dewdrop Logout

        @TEST_TMS-6068         @TenanatlevelOTPFlagchange @id:5 @TMS-5957
        Scenario: Check Tenanat level OTP flag able to Turn ON and OFF and Audit of it
            Given I logged in SSO TMS with OTP enabled User
              And Verify the OTP of the user
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Security Policy Page
              And Change OTP flag from Yes to No
              And Navigate to Audit Trail Page
              And I click on Settings
              And Verify Audit of OTP flag change
             Then User Logout From Classic TMS

        @TEST_TMS-6066         @LoginafterOTPflagONtoOFF @id:6 @TMS-5957
        Scenario: Check user able to login without OTP
            Given I logged in SSO TMS with OTP enabled User
              And Navigate to User Listing "TMS" "TMS"
              And Navigate to Security Policy Page
              And Change OTP flag from No to Yes
             Then User Logout From Classic TMS