package com.logitech.pages;

import com.google.inject.Inject;
import com.logitech.helper.DriverHelper;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class JavaScriptAlertsPage {

    @Inject
    DriverHelper helper;

    private WebDriver driver;

    @FindBy(xpath = "//button[text()=\"Click for JS Confirm\"]")
    WebElement clickJsConfirmBtn;

    @FindBy(xpath = "//*[@id=\"result\"]")
    WebElement message;

    public JavaScriptAlertsPage() {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnJsConfirmBtn(String btnName) {
        switch (btnName) {
            case "Click for JS Confirm":
                clickJsConfirmBtn.click();
                break;
            default:
                throw new NoSuchElementException(btnName);
        }
    }

    public String getMessage() {
        return message.getText();
    }
}
