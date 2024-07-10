package app.pageObjects.locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutInfoLocators {

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Checkout: Your Info\"]")
    public MobileElement checkoutInfoView;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    public MobileElement firstNameInput;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    public MobileElement lastNameInput;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    public MobileElement zipCodeInput;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    public MobileElement continueBtn;
}
