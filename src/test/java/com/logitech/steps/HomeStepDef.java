package com.logitech.steps;

import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import com.logitech.helper.PropertyUtil;
import com.logitech.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.logitech.constants.BootStrapConstants.PAGE_LOAD_WAIT;
import static com.logitech.constants.EnvironmentConstants.HEROKUAPP_URL;

public class HomeStepDef {

    private WebDriver driver;

    private HomePage homePage;

    private BrowserHelper browserHelper;

    private Scenario scenario;


    public HomeStepDef(HomePage homePage, DriverHelper helper, BrowserHelper browserHelper) {
        this.driver = helper.getDriver();
        this.homePage = homePage;
        this.browserHelper = browserHelper;
    }

    @Before
    public void init(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("I invoke Herokuapp URL")
    public void invokeHerokuApp() {
        driver.get(PropertyUtil.getProperty(HEROKUAPP_URL));
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyUtil.getBootStrapProperty(PAGE_LOAD_WAIT)), TimeUnit.MILLISECONDS);
    }

    @When("I click on {string}")
    public void clickHyperLink(String linkText) {
        homePage.clickOnHyperLink(linkText);
    }


    @And("I take screenshot of the page")
    public void takeScreenShot() {
        browserHelper.takeScreenshot(scenario);
    }

}
