package com.logitech.pages;

import com.google.inject.Inject;
import com.logitech.helper.DriverHelper;
import io.cucumber.guice.ScenarioScoped;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class FramesPage {

    @Inject
    DriverHelper helper;

    private WebDriver driver;

    @FindBy(linkText = "iFrame")
    WebElement iFrameLnk;

    @FindBy(linkText = "Nested Frames")
    WebElement nestedFrames;

    @FindBy(xpath = "//iframe[@title=\"Rich Text Area. Press ALT-0 for help.\"]")
    public WebElement iFrame;

    @FindBy(id = "tinymce")
    public WebElement iFrameTextArea;

    @FindBy(xpath = "//button[@title=\"Bold\"]")
    WebElement boldButton;


    public FramesPage(DriverHelper helper) {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnIFrame() {
        iFrameLnk.click();
    }

    public void clearTextFromiFrameTxtArea() {
        iFrameTextArea.clear();
    }

    public void clickOnBoldBtn() {
        boldButton.click();
    }

    public void enterTextInFrameTextArea(String text) {
        iFrameTextArea.sendKeys(text);
    }
}
