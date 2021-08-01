package com.logitech.steps;

import com.logitech.helper.*;
import com.logitech.pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.logitech.constants.BootStrapConstants.PAGE_LOAD_WAIT;
import static com.logitech.constants.EnvironmentConstants.*;

public class StepDef {

    private Response response;

    private WebDriver driver;

    private HomePage homePage;

    private WindowPage windowPage;

    private JavaScriptAlertsPage javaScriptAlertsPage;

    private LoginPage loginPage;

    private SecurePage securePage;

    private DragAndDropPage dragAndDropPage;

    private BrowserHelper browserHelper;

    private Scenario scenario;

    private DynamicLoadingPage dynamicLoadingPage;

    private FramesPage framesPage;


    public StepDef(HomePage homePage, DriverHelper helper, BrowserHelper browserHelper, DragAndDropPage dragAndDropPage, DynamicLoadingPage dynamicLoadingPage, FramesPage framesPage, JavaScriptAlertsPage javaScriptAlertsPage, LoginPage loginPage, SecurePage securePage, WindowPage windowPage) {
        this.driver = helper.getDriver();
        this.homePage = homePage;
        this.browserHelper = browserHelper;
        this.dragAndDropPage = dragAndDropPage;
        this.dynamicLoadingPage = dynamicLoadingPage;
        this.framesPage = framesPage;
        this.javaScriptAlertsPage = javaScriptAlertsPage;
        this.loginPage = loginPage;
        this.securePage = securePage;
        this.windowPage = windowPage;
    }

    @Before
    public void init(Scenario scenario) {
        this.scenario = scenario;
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

    @Given("I invoke Herokuapp URL")
    public void invokeHerokuApp() {
        driver.get(PropertyUtil.getProperty(HEROKUAPP_URL));
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyUtil.getBootStrapProperty(PAGE_LOAD_WAIT)), TimeUnit.MILLISECONDS);
    }

    @When("I click on {string}")
    public void clickHyperLink(String linkText) {
        homePage.clickOnHyperLink(linkText);
    }

    @Then("I click on {string} on windows page")
    public void clickOnClickHere(String linkText) {
        windowPage.clickOnClickHere();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyUtil.getBootStrapProperty(PAGE_LOAD_WAIT)), TimeUnit.MILLISECONDS);
    }

    @And("I log the URL of the newly opened tab")
    public void printURLOfNewTab() {
        System.out.println("URL of the New Tab: " + browserHelper.getTheUrlOfNewTab());
    }

    @And("I close the new tab")
    public void closeNewTab() {
        browserHelper.closeTheNewTab();
    }

    @And("I log the title of the current page")
    public void logTitle() {
        System.out.println("Title of the Current Window: " + driver.getTitle());
    }

    @Then("I click on {string} button")
    public void clickOnJsBtn(String btnName) {
        javaScriptAlertsPage.clickOnJsConfirmBtn(btnName);
    }

    @And("I cancel the Alert")
    public void cancelAlert() {
        browserHelper.cancelAlert();
    }

    @Then("I validate the alert cancelled message as {string}")
    public void validateAlertCancelMessage(String expectedMsg) {
        Assert.assertEquals(expectedMsg, javaScriptAlertsPage.getMessage());
    }

    @Then("I extract the username and password from the text")
    public void extractCredentials() {
        System.out.println("Extracted UserName: " + loginPage.getUserNameValue());
        System.out.println("Extracted Password: " + loginPage.getPasswordValue());
    }

    @And("I enter the extracted username")
    public void enterUserName() {
        loginPage.enterUserName();
    }

    @And("I enter the extracted password")
    public void enterPassword() {
        loginPage.enterPassword();
    }

    @And("I click on Login button")
    public void clickOnLoginBtn() {
        loginPage.clickLoginBtn();
    }

    @And("I validate the flash message as {string}")
    public void validateFlashMessage(String expectedMsg) {
        Assert.assertTrue(securePage.getFlashMessage().contains(expectedMsg));
    }

    @And("I take screenshot of the page")
    public void takeScreenShot() {
        browserHelper.takeScreenshot(scenario);
    }

    @Then("I drag box A to box B")
    public void dragAtoB() {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        browserHelper.dragAndDropElements(dragAndDropPage.BoxA, dragAndDropPage.BoxB);
    }

    @And("I validate the header of box B should be {string}")
    public void validateTheHeader(String expectedValue) {
        Assert.assertEquals(expectedValue, dragAndDropPage.getValueOfBoxB());
    }

    @Then("I click on {string} in Dynamic Loading page")
    public void clickOnExample2(String link) {
        dynamicLoadingPage.clickOnExample2();
    }

    @And("I click on start button")
    public void clickStart() {
        dynamicLoadingPage.clickOnStartBtn();
    }

    @And("I validate the progress bar is displayed")
    public void validateProgressBar() {
        Assert.assertTrue(dynamicLoadingPage.isProgressBarDisplayed());
    }

    @And("I wait for the progress bar to complete")
    public void waitForProgressBarToComplete() {
        dynamicLoadingPage.waitForProgressBarToComplete();
    }

    @And("I validate the message as {string}")
    public void validateTheMsg(String msg) {
        Assert.assertEquals(msg, dynamicLoadingPage.getFinishMessage());
    }

    @Then("I click on iFrame")
    public void clickOnIframe() {
        framesPage.clickOnIFrame();
    }

    @Then("I clear the default text from the text area")
    public void clearDefaultText() {
        browserHelper.switchToFrame(framesPage.iFrame);
        framesPage.clearTextFromiFrameTxtArea();
    }

    @Then("I enter the text {string} in the frame text box")
    public void enterTextInFrameTxtArea(String text) {
        framesPage.enterTextInFrameTextArea(text);
    }

    @And("I make the entered text as Bold")
    public void makeTextAsBold() {
        browserHelper.selectAllText(framesPage.iFrameTextArea);
        browserHelper.switchToDefault();
        framesPage.clickOnBoldBtn();
    }
}
