package com.logitech.pages;

import com.logitech.helper.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {

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
