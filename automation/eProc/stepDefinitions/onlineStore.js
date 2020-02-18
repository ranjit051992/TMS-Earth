const { I } = inject();
Given('logged in on eproc Page',()=>
{
  
    I.amOnPage('https://login-rp.zycus.com/sso/login');
});

Given(/^i am on login page "(.*?)"$/,(name)=>
{

    I.assertEqual(1, 1);
    console.log("hey "+name+" i am on login page");
});

Given(/^i am main page "(.*?)"$/,(name)=>
{

    I.assertEqual('given','given');
    console.log("hey "+name+" i am main page");
});
