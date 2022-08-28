package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Feature Files",
		glue = { "stepDefinition" },
		dryRun = false,
		monochrome = true,
		plugin = { "pretty",
				"junit:Reports/JUnitReports/JUnitReport.xml",
				"json:Reports/JSonReports/JSonReport.json",
				"html:Reports/HTMLReports/HtmlReport.html"
			}
		)
public class TestRunner {

}
