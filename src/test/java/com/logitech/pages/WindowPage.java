package com.logitech.pages;

import com.logitech.helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WindowPage {

    private WebDriver driver;

    @FindBy(linkText = "Click Here")
    WebElement clickHere;

    public WindowPage(DriverHelper helper) {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnClickHere() {
        clickHere.click();
    }
}
