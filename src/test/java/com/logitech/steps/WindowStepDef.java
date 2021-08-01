package com.logitech.steps;

import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import com.logitech.helper.PropertyUtil;
import com.logitech.pages.WindowPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.logitech.constants.BootStrapConstants.PAGE_LOAD_WAIT;

public class WindowStepDef {

    private WebDriver driver;

    private WindowPage windowPage;

    private BrowserHelper browserHelper;

    public WindowStepDef(DriverHelper helper, WindowPage windowPage, BrowserHelper browserHelper){
        this.driver = helper.getDriver();
        this.windowPage=windowPage;
        this.browserHelper=browserHelper;
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
}
