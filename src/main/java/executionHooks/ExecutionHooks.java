package executionHooks;

import com.thoughtworks.gauge.*;

public class ExecutionHooks
{
    @BeforeSuite
    public void BeforeSuite()
    {
        // Code for before suite
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
    public void BeforeScenario() {
        // Code for before scenario
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
