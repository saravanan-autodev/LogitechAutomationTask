package com.logitech.steps;

import com.google.inject.Inject;
import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import com.logitech.pages.SecurePage;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class SecureStepDef {

    @Inject
    private SecurePage securePage;


    @And("I validate the flash message as {string}")
    public void validateFlashMessage(String expectedMsg) {
        Assert.assertTrue(securePage.getFlashMessage().contains(expectedMsg));
    }
}
