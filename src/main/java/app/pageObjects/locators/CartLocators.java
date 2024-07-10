package app.pageObjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartLocators {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"YOUR CART\"]")
    public MobileElement yourCartText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Amount\"]//android.widget.TextView")
    public MobileElement totalAmountText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[1]")
    public MobileElement productNameText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[2]")
    public MobileElement productDescriptionText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView")
    public MobileElement productPriceText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    public MobileElement checkoutBtn;

}
