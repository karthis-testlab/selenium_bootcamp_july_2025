package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/test/java/features/saucedemo.feature:8",
		          glue = {"step.definitions", "hooks"},
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-report/result.html",
		        		  "rerun:cucumber-report/failed-scenario.txt"
		          },
		          publish = true
		          //tags = "@smoke"
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}