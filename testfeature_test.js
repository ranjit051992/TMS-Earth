const {LoginPage, LoginBO} = inject();

Feature("TestFeature");

Scenario("Login to eproc @tag1", (I) => {
    // LoginBO.setUsername("auto.zcs1@zycus.com");
    // LoginBO.setPassword("eProc@123");
    LoginPage.loginToEproc();
});

xScenario("Login to eproc2 @tag2", (I) => {
    LoginBO.setUsername("auto.zcs2@zycus.com");
    LoginBO.setPassword("eProc@123");
    LoginPage.loginToEproc(LoginBO);
});
