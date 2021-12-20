import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/GetNumViews.feature",
        publish = true , tags = "@API_Testing")
class runGetFeature {
}
