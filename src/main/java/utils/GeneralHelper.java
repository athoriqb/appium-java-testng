package utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralHelper {
    public static By getByFromMobileElement(MobileElement mobileElement) {
        String element = mobileElement.toString().split(
                "(?=\\sid:\\s|\\sname:\\s|\\sselector:\\s|\\slink text:|\\sxpath:\\s|" +
                        "By.id:\\s|By.name:\\s|By.tagName:\\s|By.className:\\s|By.cssSelector:\\s|" +
                        "By.linkText:\\s|By.partialLinkText:\\s|By.xpath:\\s|" +
                        "By.AndroidUIAutomator:\\s|By.AccessibilityId:\\s)")[1];

        String[] locator = StringUtils.removeEnd(element, "]").split(":\\s");
        String method = locator[0].trim();
        String selector = StringUtils.removeEnd(locator[1], "'");

        switch (method) {
            case "id":
            case "By.id":
                return By.id(selector);
            case "name":
            case "By.name":
                return By.name(selector);
            case "By.tagName":
                return By.tagName(selector);
            case "By.className":
                return By.className(selector);
            case "selector":
            case "By.cssSelector":
                return By.cssSelector(selector);
            case "By.linkText":
                return By.linkText(selector);
            case "link text":
            case "By.partialLinkText":
                return By.partialLinkText(selector);
            case "By.xpath":
                return By.xpath(selector);
            case "uiAutomator":
            case "By.AndroidUIAutomator":
                return new MobileBy.ByAndroidUIAutomator(selector);
            case "By.AccessibilityId":
                return new MobileBy.ByAccessibilityId(selector);
            default:
                System.out.println("Error! [" + method + "]");
                return null;
        }
    }
    public static String captureScreenShot() {
        try {
            return (String)DriverManager.getDriver().getScreenshotAs(OutputType.BASE64);
        } catch (Exception var1) {
            return null;
        }
    }
}
