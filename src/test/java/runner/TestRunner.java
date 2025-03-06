package runner;

import io.cucumber.testng.CucumberOptions;
import runner.setupRunner.BaseTestNgCucumberTest;

@CucumberOptions(features = "src/test/resources/feature/clients.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/cucumber-html-report", "json:cucumber.json"})
public class TestRunner extends BaseTestNgCucumberTest {
}
