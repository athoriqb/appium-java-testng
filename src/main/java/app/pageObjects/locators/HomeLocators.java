package app.pageObjects.locators;

import app.pageObjects.actions.BaseActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HomeLocators extends BaseActions {
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]")
    public MobileElement productsHomeView;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]")
    public MobileElement viewProductToggle;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item description\"])[1]")
    public MobileElement firstProductDescriptionText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]")
    public MobileElement filterProductBtn;
    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    })
    public List<MobileElement> productPriceListText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (high to low)\"]")
    public MobileElement priceHighToLowFilter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
    public MobileElement priceLowToHighFilter;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
    public MobileElement firstProductAddToCartBtn;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[1]")
    public MobileElement firstProductRemoveFromCartBtn;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    public MobileElement firstProductNameText;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='test-Price'])[1]")
    public MobileElement firstProductPriceText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]//android.widget.TextView[@text=\"1\"]")
    public MobileElement cartBtn;
}
