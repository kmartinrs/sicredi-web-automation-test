package features;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.TestContext;
import framework.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepdefinition")
public class Runner {
	@AfterClass
	public static void teardown() {
		if (TestContext.getDriver() != null)
			TestContext.getDriver().quit();
		Report.close();
	}
}