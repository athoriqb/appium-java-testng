package app.pageObjects.actions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

public abstract class BaseActions {

    protected MobileElement waitUntilElementVisible(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
        return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
    }
}
