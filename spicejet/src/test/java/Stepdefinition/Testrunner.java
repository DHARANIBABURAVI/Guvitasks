package Stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@tag12",
		features="src/test/resources/feature", glue={"Stepdefinition"}, plugin= {"pretty", "html:target/WebAutomationReport.html"},publish=true,monochrome=true,dryRun=false)

public class Testrunner {
	
}
