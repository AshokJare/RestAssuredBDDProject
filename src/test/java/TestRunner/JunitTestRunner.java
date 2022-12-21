package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/features/GoogleMapAddPlace.feature"}, 
		glue = {"com.stepdefinations"}
		)
public class JunitTestRunner {

}
