package cucumberoption;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature",glue="",monochrome = true)

public class TestRunner {
}
