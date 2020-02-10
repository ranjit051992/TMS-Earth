package eProc.pages.login;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import eProc.keywords.OnlineStoreFlow;
import eProc.pages.onlineStore.OnlineStoreImpl;
import eProc.pages.pageNavigation.Navigation;
import eProc.productUtilities.constants.Constants;
import eProc.productUtilities.userListing.UserBO;
import eProc.productUtilities.userListing.UserListing;
import framework.action.ActionBot;
import framework.reporting.TestReportingBO;
import framework.utilities.GlobalVariable;
import framework.utilities.driverFactory.DriverSelector;
import framework.utilities.screenshot.Screenshot;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.openqa.selenium.WebDriver;

public class LoginImpl implements ILogin {
    public static Logger logger = Logger.getLogger(LoginImpl.class);

    @Step("Login to DDS application in browser <driver> for  User <user>")
    public static UserBO login(WebDriver driver, UserBO user) throws Exception {
        String username = null;
        String password = null;

        try {
            if ("Local".equalsIgnoreCase(GlobalVariable.RUN_ON)) {


                user.setUsername(GlobalVariable.USER_NAME);
                user.setPassword(GlobalVariable.PASSWORD);

                username = user.getUsername();
                password = user.getPassword();

            }

            if (username != null || password != null) {

                if (!GlobalVariable.LOGIN_WITH_PASSWORD_MANAGER) {
                    login(driver, username, password, "login case");
                } else {
                    //loginWithPasswordManager(driver, testcase, user);
                }
            } else {

        /*        if ("Grid".equalsIgnoreCase(GlobalVariable.RUN_ON))
                {
                    logger.info("releasing user from login method else block ");
                    UserListing.releaseUser(driver, testcase, user);
                    user = null;
                }
                logger.error("Unable to login 'Username or Password is null'");
                throw new Exception("username or password is null");
            }*/

            }
        } catch (Exception e) {


            throw e;
        }
        return user;
    }

    @Step("Login to DDS application in browser <driver> with UserName <username>, Password <password> for TestCase <testcase> ")
    public static void login(WebDriver driver, String username, String password, String testcase) throws Exception {
        try {
            logger.info("Navigating to url : " + Constants.profileConfig.get("URL"));

            Navigation.navigateToProductUrl(driver, testcase);

             ActionBot.waitUntilVisible(driver, USER_ID_CLICK);
            ActionBot.click(driver, USER_ID_CLICK);

            ActionBot.sendKeys(driver, USER_ID_TEXTBOX, username);
            logger.info("Enterd user name : " + username);

            ActionBot.click(driver, PASSWORD_CLICK);
            ActionBot.sendKeys(driver, PASSWORD_TEXTBOX, password);
            logger.info("Entered password  : " + password);

            Screenshot.captureScreenshot(driver, testcase, "Entered user name and password");

            ActionBot.click(driver, LOGIN_BUTTON);
            ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_WAIT);
            logger.info("navigating to dewdrops url : " + Constants.profileConfig.get("DEW_DROP_URL"));

            Navigation.navigateToOnlineStore(driver, testcase);

            ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_WAIT);

            OnlineStoreImpl.waitForOnlineStoreToLoad(driver, testcase);

            Screenshot.captureScreenshot(driver, testcase, "navigated to dew drop url");

        } catch (Exception e) {
            throw e;
        }
    }

    @Step("Login to application with driver <driverKey>")
    public static void startCase(String testcaseName) throws Exception {
        UserBO ub = null;
        DataStore userStore = DataStoreFactory.getSuiteDataStore();
        ub = (UserBO) userStore.get("UserBO");

        System.out.println("heyyyyyyyy : "+ ub.getUsername());
        WebDriver driver = DriverSelector.getDriver();

        DataStore driverStore = DataStoreFactory.getSuiteDataStore();
        driverStore.put(testcaseName,driver);
        //driver = (WebDriver)driverStore.get("WebDriver");

        System.out.println("heyyyyyyyy : "+ub.getUsername());
        LoginImpl.login(driver,ub);
    }

}
