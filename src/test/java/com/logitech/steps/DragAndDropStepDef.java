package com.logitech.steps;

import com.google.inject.Inject;
import com.logitech.helper.BrowserHelper;
import com.logitech.helper.DriverHelper;
import com.logitech.pages.DragAndDropPage;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@ScenarioScoped
public class DragAndDropStepDef {

    private WebDriver driver;

    @Inject
    private DragAndDropPage dragAndDropPage;

    @Inject
    private BrowserHelper browserHelper;

    @Inject
    private DriverHelper driverHelper;

    public DragAndDropStepDef(DriverHelper helper){
        this.driver = helper.getDriver();
    }

    @Then("I drag box A to box B")
    public void dragAtoB() {
        driverHelper.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        browserHelper.dragAndDropElements(dragAndDropPage.BoxA, dragAndDropPage.BoxB);
    }

    @And("I validate the header of box B should be {string}")
    public void validateTheHeader(String expectedValue) {
        Assert.assertEquals(expectedValue, dragAndDropPage.getValueOfBoxB());
    }
}
