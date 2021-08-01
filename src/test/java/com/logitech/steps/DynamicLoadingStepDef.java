package com.logitech.steps;

import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import com.logitech.pages.DynamicLoadingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingStepDef {

    private DynamicLoadingPage dynamicLoadingPage;

    public DynamicLoadingStepDef(DriverHelper helper, DynamicLoadingPage dynamicLoadingPage){
        this.dynamicLoadingPage=dynamicLoadingPage;
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
}
