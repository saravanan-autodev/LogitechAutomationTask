package com.logitech.pages;

import com.google.inject.Inject;
import com.logitech.helper.DriverHelper;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class LoginPage {

    @Inject
    DriverHelper helper;

    private WebDriver driver;

    @FindBy(name = "username")
    WebElement userNameTxtBx;

    @FindBy(name = "password")
    WebElement passwordTxtBx;

    @FindBy(xpath = "//*[normalize-space(text())=\"Login\"]/parent::button")
    WebElement loginBtn;

    @FindBy(xpath = "//h4/em[1]")
    WebElement userNameValue;

    @FindBy(xpath = "//h4/em[2]")
    WebElement passwordValue;


    public LoginPage() {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getUserNameValue() {
        return userNameValue.getText();
    }

    public String getPasswordValue() {
        return passwordValue.getText();
    }

    public void enterUserName() {
        userNameTxtBx.sendKeys(userNameValue.getText());
    }

    public void enterPassword() {
        passwordTxtBx.sendKeys(passwordValue.getText());
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
