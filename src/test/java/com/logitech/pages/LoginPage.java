package com.logitech.pages;

import com.logitech.helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

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


    public LoginPage(DriverHelper helper) {
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
