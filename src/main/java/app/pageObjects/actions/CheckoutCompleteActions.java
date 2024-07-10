package app.pageObjects.actions;

import app.pageObjects.locators.CheckoutCompleteLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutCompleteActions extends BaseActions{
    CheckoutCompleteLocators checkoutCompleteLocators;

    public CheckoutCompleteActions(AppiumDriver<MobileElement> driver){
        this.checkoutCompleteLocators = new CheckoutCompleteLocators();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this.checkoutCompleteLocators);
    }

    public Boolean isThankYouScreenVisible(){
        try {
            return checkoutCompleteLocators.thankYouViewText.isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
