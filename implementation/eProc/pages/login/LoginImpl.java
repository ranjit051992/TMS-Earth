package eProc.pages.login;

import com.thoughtworks.gauge.Step;
import eProc.keywords.OnlineStoreFlow;
import eProc.pages.onlineStore.OnlineStoreImpl;
import eProc.pages.pageNavigation.Navigation;
import eProc.productUtilities.constants.Constants;
import eProc.productUtilities.userListing.UserBO;
import eProc.productUtilities.userListing.UserListing;
import framework.action.ActionBot;
import framework.reporting.TestReportingBO;
import framework.utilities.GlobalVariable;
import framework.utilities.screenshot.Screenshot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginImpl implements ILogin
{
    public static Logger logger = Logger.getLogger(LoginImpl.class);

    @Step("Login to DDS application in browser <driver> for TestCase <testcase> and User <user>")
    public static UserBO login(WebDriver driver, TestReportingBO testcase, UserBO user) throws Exception
    {
        String username = null;
        String password = null;

        try
        {
            if ("Grid".equalsIgnoreCase(GlobalVariable.RUN_ON))
            {

                user = UserListing.beforeLogin(driver, testcase);

                username = user.getUsername();
                password = user.getPassword();

            }
            else if ("Local".equalsIgnoreCase(GlobalVariable.RUN_ON))
            {

                if (user.getRole().equals("Admin_Role"))
                {
                    user.setUsername(GlobalVariable.ADMIN_USERNAME);
                    user.setPassword(GlobalVariable.ADMIN_PASSWORD);
                }
                else
                {
                    user.setUsername(GlobalVariable.USER_NAME);
                    user.setPassword(GlobalVariable.PASSWORD);
                }

                username = user.getUsername();
                password = user.getPassword();

            }

            if (username != null || password != null)
            {

                if (!GlobalVariable.LOGIN_WITH_PASSWORD_MANAGER)
                {
                    login(driver, username, password, testcase);
                }
                else
                {
                    //loginWithPasswordManager(driver, testcase, user);
                }
            }
            else
            {

                if ("Grid".equalsIgnoreCase(GlobalVariable.RUN_ON))
                {
                    logger.info("releasing user from login method else block ");
                    UserListing.releaseUser(driver, testcase, user);
                    user = null;
                }
                logger.error("Unable to login 'Username or Password is null'");
                throw new Exception("username or password is null");
            }
        }
        catch (Exception e)
        {

            if ("Grid".equalsIgnoreCase(GlobalVariable.RUN_ON))
            {
                logger.info("releasing user from login method catch block " + e);
                UserListing.releaseUser(driver, testcase, user);
                user = null;
            }

            throw e;
        }
        return user;
    }

    @Step("Login to DDS application in browser <driver> with UserName <username>, Password <password> for TestCase <testcase> ")
    public static void login(WebDriver driver,String username,String password,TestReportingBO testcase) throws Exception
    {
        try
        {
            logger.info("Navigating to url : " + Constants.profileConfig.get("URL"));

            Navigation.navigateToProductUrl(driver, testcase.getTestCaseName());

            ActionBot.waitUntilVisible(driver,USER_ID_CLICK);
            ActionBot.click(driver,USER_ID_CLICK);

            ActionBot.sendKeys(driver,USER_ID_TEXTBOX,username);
            logger.info("Enterd user name : " + username);

            ActionBot.click(driver,PASSWORD_CLICK);
            ActionBot.sendKeys(driver,PASSWORD_TEXTBOX,password);
            logger.info("Entered password  : " + password);

            Screenshot.captureScreenshot(driver, testcase.getTestCaseName(), "Entered user name and password");

            ActionBot.click(driver,LOGIN_BUTTON);
            ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
            logger.info("navigating to dewdrops url : " + Constants.profileConfig.get("DEW_DROP_URL"));

            Navigation.navigateToOnlineStore(driver,testcase.getTestCaseName());

            ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);

            OnlineStoreImpl.waitForOnlineStoreToLoad(driver, testcase.getTestCaseName());

            Screenshot.captureScreenshot(driver, testcase.getTestCaseName(), "navigated to dew drop url");

        }
        catch (Exception e)
        {
            throw e;
        }
    }

}
