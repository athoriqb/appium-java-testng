package app.pageObjects.actions;

import app.pageObjects.locators.CheckoutOverviewLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutOverviewActions extends BaseActions{
    CheckoutOverviewLocators checkoutOverviewLocators;
    public CheckoutOverviewActions(AppiumDriver<MobileElement> driver){
        this.checkoutOverviewLocators = new CheckoutOverviewLocators();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this.checkoutOverviewLocators);
    }

    public void waitUntilCheckoutOverviewScreenVisible(){
        try {
            waitUntilElementVisible(checkoutOverviewLocators.checkoutOverviewView, 10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void clickFinishBtn(){
        checkoutOverviewLocators.finishBtn.click();
    }
}
