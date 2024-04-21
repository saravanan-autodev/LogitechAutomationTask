package com.logitech.steps;

import com.google.inject.Inject;
import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import com.logitech.pages.LoginPage;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class LoginStepDef {

    @Inject
    private LoginPage loginPage;

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
}
