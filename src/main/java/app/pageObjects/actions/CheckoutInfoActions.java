package app.pageObjects.actions;

import app.pageObjects.locators.CheckoutInfoLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutInfoActions extends BaseActions{
    CheckoutInfoLocators checkoutInfoLocators;
    public CheckoutInfoActions(AppiumDriver<MobileElement> driver){
        this.checkoutInfoLocators = new CheckoutInfoLocators();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this.checkoutInfoLocators);
    }

    public void waitUntilCheckoutInfoScreenVisible(){
        try {
            waitUntilElementVisible(checkoutInfoLocators.checkoutInfoView, 10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void inputInformation(String firstName, String lastName, String zipCode){
        waitUntilElementVisible(checkoutInfoLocators.firstNameInput,10).sendKeys(firstName);
        waitUntilElementVisible(checkoutInfoLocators.lastNameInput,10).sendKeys(lastName);
        waitUntilElementVisible(checkoutInfoLocators.zipCodeInput,10).sendKeys(zipCode);
    }

    public void clickContinueBtn(){
        waitUntilElementVisible(checkoutInfoLocators.continueBtn,10).click();
    }
}
