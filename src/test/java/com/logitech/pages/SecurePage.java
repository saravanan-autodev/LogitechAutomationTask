package com.logitech.pages;

import com.logitech.helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage {

    private WebDriver driver;

    @FindBy(id = "flash")
    WebElement flashMessage;

    public SecurePage(DriverHelper helper) {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getFlashMessage() {
        return flashMessage.getText().trim();
    }
}
