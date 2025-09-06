package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/test/java/features/saucedemo.feature",
		          glue = "step.definitions",
		          dryRun = false
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}