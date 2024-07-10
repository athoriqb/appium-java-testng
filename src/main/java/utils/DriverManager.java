package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static config.Config.MOBILE_APP_ACTIVITY;
import static config.Config.MOBILE_APP_PACKAGE;

public class DriverManager {
    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static void initializeDriver(String deviceName, String platformVersion, String port) throws Exception {
        try {
            if (driver == null) {
                File app = new File("src/test/resources/test.apk");
                String absoluteAppPath = app.getAbsolutePath();
                DesiredCapabilities capabilities = MobileCapabilities.getCapabilities(deviceName, "android", platformVersion, absoluteAppPath, "uiautomator2",MOBILE_APP_PACKAGE,MOBILE_APP_ACTIVITY);
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + port), capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }catch (Exception e) {
            System.out.println("Error initializing driver: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
