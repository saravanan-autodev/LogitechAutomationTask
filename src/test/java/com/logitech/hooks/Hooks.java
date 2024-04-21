package com.logitech.hooks;

import com.google.inject.Inject;
import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class Hooks {

    private WebDriver driver;

    @Inject
    private BrowserHelper browserHelper;

    @Inject
    DriverHelper helper;


    @Before
    public void init() {
        driver.manage().window().maximize();
    }


    @After
    public void afterHook(Scenario scenario) {
        browserHelper.takeScreenshotOnFailure(scenario);
        driver.quit();
    }

}
