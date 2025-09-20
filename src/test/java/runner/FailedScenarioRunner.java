package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "@cucumber-report/failed-scenario.txt",
		          glue = "step.definitions",		          
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-report/result.html"
		          },
		          publish = true
		        )
public class FailedScenarioRunner extends AbstractTestNGCucumberTests {

}