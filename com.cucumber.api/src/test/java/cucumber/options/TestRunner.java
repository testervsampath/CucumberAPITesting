package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFiles", plugin = {"pretty" ,
"json:target/jsonReports/cucumber.json"}, glue =  {"StepDefinitions"} )
public class TestRunner {

}
