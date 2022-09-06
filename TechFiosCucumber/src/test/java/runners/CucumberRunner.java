package runners;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(  features = ".//Features//Dashboard.feature",
        glue = {"StepDefinitions"}

)

public class CucumberRunner  {

}


