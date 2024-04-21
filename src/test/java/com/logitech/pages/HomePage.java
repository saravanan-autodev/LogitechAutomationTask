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
public class HomePage {

    @Inject
    DriverHelper helper;

    private WebDriver driver;

    @FindBy(linkText = "Form Authentication")
    WebElement formAuthentication;

    @FindBy(linkText = "Dynamic Loading")
    WebElement dynamicLoading;

    @FindBy(linkText = "Multiple Windows")
    WebElement multipleWindows;

    @FindBy(linkText = "Drag and Drop")
    WebElement dragAndDrop;

    @FindBy(linkText = "Frames")
    WebElement frames;

    @FindBy(linkText = "JavaScript Alerts")
    WebElement javaScriptAlerts;

    public HomePage() {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnHyperLink(String linkText) {
        switch (linkText) {
            case "Form Authentication":
                this.formAuthentication.click();
                break;
            case "Dynamic Loading":
                this.dynamicLoading.click();
                break;
            case "Multiple Windows":
                this.multipleWindows.click();
                break;
            case "Drag and Drop":
                this.dragAndDrop.click();
                break;
            case "Frames":
                this.frames.click();
                break;
            case "JavaScript Alerts":
                this.javaScriptAlerts.click();
                break;
            default:
                throw new NoSuchElementException(linkText);
        }
    }

}
