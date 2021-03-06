package com.logitech.pages;

import com.logitech.helper.DriverHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class JavaScriptAlertsPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()=\"Click for JS Confirm\"]")
    WebElement clickJsConfirmBtn;

    @FindBy(xpath = "//*[@id=\"result\"]")
    WebElement message;

    public JavaScriptAlertsPage(DriverHelper helper) {
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
