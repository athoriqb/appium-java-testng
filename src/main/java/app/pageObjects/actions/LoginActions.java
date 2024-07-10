package app.pageObjects.actions;

import app.pageObjects.locators.LoginLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.GeneralHelper;

import java.lang.reflect.Field;
import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utils.GeneralHelper.getByFromMobileElement;

public class LoginActions extends BaseActions {
    private LoginLocators loginLocators;

    public LoginActions(AppiumDriver<MobileElement> driver) {
        this.loginLocators = new LoginLocators();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this.loginLocators);
    }

    public void inputCredentialsSwagLabs(String username, String password) {
        System.out.println("Entering username: " + username);
        waitUntilElementVisible(loginLocators.usernameField, 10).sendKeys(username);
        System.out.println("Entering password: " + password);
        waitUntilElementVisible(loginLocators.passwordField, 10).sendKeys(password);
    }

    public void clickLoginBtn() {
        System.out.println("Clicking login button");
        waitUntilElementVisible(loginLocators.loginBtn, 10).click();
    }
}
