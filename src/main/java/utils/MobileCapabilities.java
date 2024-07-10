package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileCapabilities {
    public static DesiredCapabilities getCapabilities(String deviceName, String platformName, String platformVersion, String appPath, String automationName, String appPackage, String appActivity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appium:platformVersion", platformVersion);
        capabilities.setCapability("appium:app", appPath); // Path to your app
        capabilities.setCapability("appium:automationName", automationName);
        capabilities.setCapability("appium:appPackage",appPackage);
        capabilities.setCapability("appium:appWaitActivity",appActivity);
        return capabilities;
    }
}
