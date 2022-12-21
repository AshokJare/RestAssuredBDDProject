package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "", 
	features = {"src/test/java/com/features/GoogleMapAddPlace.feature"},
	plugin="json:target/jsonReports/cucumber-report.json",
	glue = {"com.stepdefinations"}
)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}