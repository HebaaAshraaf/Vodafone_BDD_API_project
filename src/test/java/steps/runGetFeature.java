package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(glue={"GetRequestSteps"},
        features = "src/test/resources/GetNumViews.feature", publish = true)
public class runGetFeature {
}
