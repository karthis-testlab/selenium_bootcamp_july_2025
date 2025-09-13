package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/test/java/features/saucedemo.feature",
		          glue = "step.definitions",
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-report/result.html"		        		  
		          },
		          publish = true,
		          tags = "@e2e or @smoke"
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}