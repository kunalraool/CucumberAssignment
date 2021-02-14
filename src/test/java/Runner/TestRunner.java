package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "C:\\Users\\KunalRaool\\Desktop\\SDET\\Cucumber project\\Cucumber_Assignment\\src\\test\\resources\\FeatureFile" }, 
		glue = {"StepDefinition" }, 
		monochrome = true, 
		dryRun = false, 
		strict = true,
		plugin = {"html:testoutput/testoutput.html","junit:testoutput/cucumber.xml","junit:json/cucumber2.json"}

)
public class TestRunner {

}
