package runner.setupRunner;

import io.cucumber.testng.Pickle;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomNGCucumberTestsRunner {

    private static int browserCount;
    private TestNGCucumberRunner testNGCucumberRunner;
    private int threadCount;

    public CustomNGCucumberTestsRunner() {
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) throws Exception {
        threadCount = context.getCurrentXmlTest().getSuite().getTests().get(0).getThreadCount();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void runScenario(Pickle pickle) throws Throwable {
        testNGCucumberRunner.runScenario(pickle);

    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }
}
