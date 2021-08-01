package com.logitech.pages;

import com.logitech.helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {

    private WebDriver driver;

    @FindBy(id = "column-a")
    public WebElement BoxA;

    @FindBy(id = "column-b")
    public WebElement BoxB;

    public DragAndDropPage(DriverHelper helper) {
        this.driver = helper.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getValueOfBoxB() {
        return BoxB.getText();
    }


}
