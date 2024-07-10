package app.pageObjects.actions;

import app.pageObjects.locators.CartLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CartActions extends BaseActions {
    CartLocators cartLocators;
    public CartActions(AppiumDriver<MobileElement> driver){
        this.cartLocators = new CartLocators();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this.cartLocators);
    }

    public void waitUntilCartScreenVisible(){
        try {
            waitUntilElementVisible(cartLocators.yourCartText, 10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Boolean isTotalAmountCorrect(String amount){
        try {
            return amount.equals(cartLocators.totalAmountText.getText());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean isProductNameCorrect(String productName){
        try {
            return productName.equals(cartLocators.productNameText.getText());
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean isProductDescCorrect(String productDesc){
        try {
            return productDesc.equals(cartLocators.productDescriptionText.getText());
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean isProductPriceCorrect(String productPrice){
        try {
            return productPrice.equals(cartLocators.productPriceText.getText());
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void clickCheckoutBtn(){
        waitUntilElementVisible(cartLocators.checkoutBtn,10).click();
    }
}
