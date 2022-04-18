package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources"},
        glue = "steps")
public class BookingTest extends AbstractTestNGCucumberTests {
}