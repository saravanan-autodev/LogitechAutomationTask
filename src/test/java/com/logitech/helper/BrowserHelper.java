package com.logitech.helper;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper(DriverHelper helper) {
        this.driver = helper.getDriver();
    }

    public String getTheUrlOfNewTab() {
        String currentWindowTitle = driver.getTitle();
        String currentHandle = driver.getWindowHandle();
        String urlOfNewTab = null;
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (!driver.getTitle().equals(currentWindowTitle)) {
                urlOfNewTab = driver.getCurrentUrl();
            }
        }
        driver.switchTo().window(currentHandle);
        return urlOfNewTab;
    }

    public void closeTheNewTab() {
        String parentTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentTab)) {
                driver.switchTo().window(handle);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentTab);
    }

    public void cancelAlert() {
        String windowHandle = driver.getWindowHandle();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        driver.switchTo().window(windowHandle);
    }

    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
    }

    public void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }


    public void dragAndDropElements(WebElement source, WebElement destination) {

        //        Actions actions = new Actions(driver);
        // Actions methods didn't work for this drag and drop hence implemented with JavaScript Executor
//        actions.clickAndHold(source)
//                .pause(Duration.ofSeconds(2))
//                .moveToElement(destination)
//                .pause(Duration.ofSeconds(2))
//                .release(destination)
//                .build()
//                .perform();

//        actions.dragAndDrop(source,destination).build().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", source, destination);
    }

    public void switchToFrame(WebElement iFrame) {
        driver.switchTo().frame(iFrame);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void selectAllText(WebElement element) {
        element.sendKeys(Keys.chord(Keys.COMMAND + "A"));
    }
}
