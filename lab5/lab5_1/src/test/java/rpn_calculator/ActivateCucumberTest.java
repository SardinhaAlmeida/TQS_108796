package rpn_calculator;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("rpn_calculator")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "rpn_calculator")
public class ActivateCucumberTest {

}
