package app.pageObjects.actions;

import app.pageObjects.locators.HomeLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeActions extends BaseActions {
    private HomeLocators homeLocators;
    public HomeActions(AppiumDriver<MobileElement> driver){
        this.homeLocators = new HomeLocators();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this.homeLocators);
    }
    public Boolean isHomeProductsIsVisible(){
        try {
            waitUntilElementVisible(homeLocators.productsHomeView,10);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void switchViewProductToList(){
        waitUntilElementVisible(homeLocators.viewProductToggle, 10).click();
        Assert.assertTrue(homeLocators.firstProductDescriptionText.isDisplayed(),"Product description not found or product view unable changed");
    }

    public void chooseFilterHighToLow(){
        waitUntilElementVisible(homeLocators.filterProductBtn,10).click();
        waitUntilElementVisible(homeLocators.priceHighToLowFilter,10).click();
        waitUntilElementVisible(homeLocators.firstProductDescriptionText,10);

    }

    public void chooseFilterLowToHigh(){
        waitUntilElementVisible(homeLocators.filterProductBtn,10).click();
        waitUntilElementVisible(homeLocators.priceLowToHighFilter,10).click();
        waitUntilElementVisible(homeLocators.firstProductDescriptionText,10);
    }

    public Boolean isPriceSortedFromHighToLow(){
        try {
            List<Double> prices = new ArrayList<>();
            for (MobileElement element : homeLocators.productPriceListText) {
                String priceText = element.getText().replace("$", "");
                prices.add(Double.parseDouble(priceText));
            }
            System.out.println("Products Price : "+prices);
            List<Double> sortedPricesHighToLow = new ArrayList<>(prices);
            sortedPricesHighToLow.sort(Comparator.reverseOrder());
            System.out.println("Product Price Sorted : "+sortedPricesHighToLow);
            return prices.equals(sortedPricesHighToLow);
        }catch (Exception e){
            return false;
        }
    }

    public Boolean isPriceSortedFromLowToHigh(){
        try {
            List<Double> prices = new ArrayList<>();
            for (MobileElement element : homeLocators.productPriceListText) {
                String priceText = element.getText().replace("$", "");
                prices.add(Double.parseDouble(priceText));
            }
            System.out.println("Products Price : "+prices);
            List<Double> sortedPricesLowToHigh = new ArrayList<>(prices);
            Collections.sort(sortedPricesLowToHigh);
            System.out.println("Product Price Sorted : "+sortedPricesLowToHigh);
            return prices.equals(sortedPricesLowToHigh);
        }catch (Exception e){
            return false;
        }
    }

    public void clickAddToCartBtn(){
        waitUntilElementVisible(homeLocators.firstProductAddToCartBtn,10).click();
        waitUntilElementVisible(homeLocators.firstProductRemoveFromCartBtn,10);
    }

    public void clickCartIconBtn() throws Exception {
        try {
            waitUntilElementVisible(homeLocators.cartBtn,10).click();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("The product not added yet or the cart button not found" );
        }
    }

    public String getProductName(){
        return homeLocators.firstProductNameText.getText();
    }

    public String getProductDescription(){
        return homeLocators.firstProductDescriptionText.getText();
    }

    public String getProductPrice(){
        return homeLocators.firstProductPriceText.getText();
    }

}
