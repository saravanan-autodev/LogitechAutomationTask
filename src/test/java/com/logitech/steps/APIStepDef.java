package com.logitech.steps;

import com.google.inject.Inject;
import com.logitech.helper.DriverHelper;
import com.logitech.helper.PropertyUtil;
import com.logitech.helper.RestUtil;
import com.logitech.helper.UrlUtil;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.logitech.constants.BootStrapConstants.PAGE_LOAD_WAIT;
import static com.logitech.constants.EnvironmentConstants.BANNERS_SERVICE;
import static com.logitech.constants.EnvironmentConstants.NAUKRI_URL;

@ScenarioScoped
public class APIStepDef {

    @Inject
    DriverHelper driverHelper;

    private WebDriver driver;

    private Response response;

    public APIStepDef(){
        this.driver = driverHelper.getDriver();
    }

    @Given("I invoke Nakuri URL")
    public void invokeNaukriStep() {
        driver.get(PropertyUtil.getProperty(NAUKRI_URL));
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyUtil.getBootStrapProperty(PAGE_LOAD_WAIT)), TimeUnit.MILLISECONDS);
    }

    @Then("I hit the banners api to get the details of window popups")
    public void getDetailsFromBannersApiStep() {
        response = RestUtil.getRequest(PropertyUtil.getProperty(BANNERS_SERVICE));
        Assert.assertEquals(200, response.getStatusCode());
    }

    @And("I validate count be should matched between UI and API")
    public void validateTheCountBetweenUIAndAPI() {
        String jsonPath = "211.popUps.popUpUrl";
        Assert.assertEquals("Window Count doesn't match", response.jsonPath().getList(jsonPath).size(), driver.getWindowHandles().size() - 1);
    }

    @And("I validate the company name in the UI with api response")
    public void validateCompanyName() throws MalformedURLException {
        String jsonPath = "211.popUps.popUpUrl";
        List<String> companyNames = new ArrayList<>();
        for (Object url : response.jsonPath().getList(jsonPath)) {
            companyNames.add(UrlUtil.getPath(url.toString()).split("/")[2]);
        }
        System.out.println("All Company names from API Response:-->" + companyNames);
        String selectedCompanyName = companyNames.get(0);
        System.out.println("Selected Company Name->" + selectedCompanyName);
        boolean isAvailable = false;
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            System.out.println("UI Title: " + driver.getTitle());
            if (driver.getTitle().replace(" ", "").equalsIgnoreCase(selectedCompanyName)) {
                isAvailable = true;
                driver.switchTo().window(handle).close();
                break;
            }
        }
        Assert.assertTrue("None of the popup window title matches with API Response" + "Company Name from API Response-" + companyNames, isAvailable);
    }
}
