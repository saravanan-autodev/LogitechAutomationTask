package com.logitech.pages;

import com.google.inject.Inject;
import com.logitech.helper.DriverHelper;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class DynamicLoadingPage {

    @Inject
    DriverHelper helper;

    private WebDriver driver;

    @FindBy(linkText = "Example 1: Element on page that is hidden")
    WebElement example1;


    @FindBy(linkText = "Example 2: Element rendered after the fact")
    WebElement example2;

    @FindBy(xpath = "//button[text()=\"Start\"]")
    WebElement startBtn;

    @FindBy(xpath = "//*[text()=\"Loading... \"]")
    WebElement progressBar;

    @FindBy(id = "finish")
    WebElement finishMessage;


    public DynamicLoadingPage() {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnExample2() {
        example2.click();
    }

    public void clickOnStartBtn() {
        startBtn.click();
    }

    public boolean isProgressBarDisplayed() {
        return progressBar.isDisplayed();
    }

    public void waitForProgressBarToComplete() {
        if (progressBar.isDisplayed()) {
            waitForProgressBarToComplete();
        }
    }

    public String getFinishMessage() {
        return finishMessage.getText();
    }
}
