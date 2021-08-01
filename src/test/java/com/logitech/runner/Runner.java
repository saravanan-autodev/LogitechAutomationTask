package com.logitech.runner;

import com.logitech.helper.PropertyUtil;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

import static com.logitech.constants.BootStrapConstants.BOOTSTRAP_PROPERTIES_PATH;
import static com.logitech.constants.EnvironmentConstants.PROPERTIES_PATH;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"com.logitech.steps", "com.logitech.hooks"},
        dryRun = false,
        publish = true,
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"}
)
public class Runner {

    @BeforeClass
    public static void loadProps() throws IOException {
        PropertyUtil.loadProperties(PROPERTIES_PATH);
        PropertyUtil.loadBootstrapProperties(BOOTSTRAP_PROPERTIES_PATH);
    }
}
