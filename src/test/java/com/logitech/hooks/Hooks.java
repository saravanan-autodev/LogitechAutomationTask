package com.logitech.hooks;

import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    private BrowserHelper browserHelper;

    public Hooks(DriverHelper helper, BrowserHelper browserHelper) {
        this.driver = helper.getDriver();
        this.browserHelper = browserHelper;
    }

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
