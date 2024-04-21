package com.logitech.pages;

import com.google.inject.Inject;
import com.logitech.helper.DriverHelper;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class SecurePage {

    @Inject
    DriverHelper helper;

    private WebDriver driver;

    @FindBy(id = "flash")
    WebElement flashMessage;

    public SecurePage() {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getFlashMessage() {
        return flashMessage.getText().trim();
    }
}
