package runner.setupRunner;

import controller.BaseController;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import listener.TestListeners;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(TestListeners.class)
public class BaseTestNgCucumberTest extends CustomNGCucumberTestsRunner {

    @DataProvider
    public Object[][] features() {
        return super.scenarios();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass(final ITestContext context) throws Exception {
        super.setUpClass(context);
        System.out.println("Set up Class.");
        BaseController.instance.start();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        super.tearDownClass();
        System.out.println("Tear Down Class.");
        BaseController.instance.quit();
    }
}
