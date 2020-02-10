package framework.executionHooks;

import com.thoughtworks.gauge.*;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import eProc.pages.login.LoginImpl;
import eProc.productUtilities.userListing.UserBO;
import framework.reporting.TestReportingBO;
import framework.startup.Startup;
import framework.utilities.driverFactory.DriverSelector;
import org.openqa.selenium.WebDriver;

public class ExecutionHooks
{
    @BeforeSuite
    public void BeforeSuite() throws Exception {
        Startup.startup();
    }

    @AfterSuite
    public void AfterSuite() {
        // Code for after suite
    }

    @BeforeSpec
    public void BeforeSpec() {
        // Code for before spec
    }

    @AfterSpec
    public void AfterSpec() {
        // Code for after spec
    }

    @BeforeScenario
    public void BeforeScenario() throws Exception {

    }

    @AfterScenario
    public void AfterScenario() {
        // Code for after scenario
    }

    @BeforeStep
    public void BeforeStep() {
        // Code for before step
    }

    @AfterStep
    public void AfterStep() {
        // Code for after step
    }
}
