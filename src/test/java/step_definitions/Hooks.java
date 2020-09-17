package step_definitions;

import core.DriverFactory;
import core.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private DriverFactory driverFactory = null;

    @Before
    public void initBrowser(){
        driverFactory = new DriverFactory();
        BaseSteps.setDriver(driverFactory.getDriver(TestConfig.getProperty("browser")));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driverFactory.quitDriver();
    }
}
