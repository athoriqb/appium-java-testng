package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomAsserts {
    private static ExtentTest test;
    private static AppiumDriver driver;

    public CustomAsserts(ExtentTest test, AppiumDriver driver) {
        this.test = test;
        this.driver = driver;
    }

    public static void assertTrue(boolean condition, String message, String errorMessage) {
        try {
            Assert.assertTrue(condition, message);
            test.log(Status.PASS, message);
        } catch (AssertionError e) {
            test.log(Status.FAIL, errorMessage);
            captureScreenshot();
            throw e;
        }
    }

    private static void captureScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = "screenshots/" + System.currentTimeMillis() + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
